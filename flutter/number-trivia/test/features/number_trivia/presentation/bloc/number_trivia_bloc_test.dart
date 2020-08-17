import 'package:dartz/dartz.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mockito/mockito.dart';
import 'package:numbertrivia/core/error/failures.dart';
import 'package:numbertrivia/core/usecases/usecase.dart';
import 'package:numbertrivia/core/util/input_converter.dart';
import 'package:numbertrivia/features/number_trivia/domain/entities/number_trivia.dart';
import 'package:numbertrivia/features/number_trivia/domain/usecases/get_concrete_number_trivia.dart';
import 'package:numbertrivia/features/number_trivia/domain/usecases/get_random_number_trivia.dart';
import 'package:numbertrivia/features/number_trivia/presentation/bloc/bloc.dart';

class MockGetConcreteNumberTrivia extends Mock implements GetConcreteNumberTrivia {}

class MockGetRandomNumberTrivia extends Mock implements GetRandomNumberTrivia {}

class MockInputConverter extends Mock implements InputConverter {}

void main() {
  NumberTriviaBloc bloc;
  MockGetConcreteNumberTrivia mockGetConcreteNumberTrivia;
  MockGetRandomNumberTrivia mockGetRandomNumberTrivia;
  MockInputConverter mockInputConverter;

  setUp(() {
    mockGetConcreteNumberTrivia = MockGetConcreteNumberTrivia();
    mockGetRandomNumberTrivia = MockGetRandomNumberTrivia();
    mockInputConverter = MockInputConverter();

    bloc = NumberTriviaBloc(
      concrete: mockGetConcreteNumberTrivia,
      random: mockGetRandomNumberTrivia,
      inputConverter: mockInputConverter,
    );
  });

  test('initialState should be Empty', () {
    expect(bloc.initialState, equals(Empty()));
  });

  group('GetTriviaForConcreteNumber', () {
    final numberString = "1";
    final numberParsed = 1;
    final numberTrivia = NumberTrivia(text: 'test trivia', number: 1);

    void setUpMockInputConverterSuccess() =>
        when(mockInputConverter.stringToUnsignedInteger(any)).thenReturn(Right(numberParsed));

    test('should call the InputConverter to validate and convert the string to an unsigned integer', () async {
      setUpMockInputConverterSuccess();

      bloc.dispatch(GetTriviaForConcreteNumber(numberString));
      await untilCalled(mockInputConverter.stringToUnsignedInteger(any));

      verify(mockInputConverter.stringToUnsignedInteger(numberString));
    });

    test('should emit [Error] when the input is invalid', () async {
      when(mockInputConverter.stringToUnsignedInteger(any)).thenReturn(Left(InvalidInputFailure()));

      final expected = [Empty(), Error(message: INVALID_INPUT_FAILURE_MESSAGE)];
      expectLater(bloc.state, emitsInOrder(expected));

      bloc.dispatch(GetTriviaForConcreteNumber(numberString));
    });

    test('should get data from the concrete use case', () async {
      setUpMockInputConverterSuccess();
      when(mockGetConcreteNumberTrivia(any)).thenAnswer((_) async => Right(numberTrivia));

      bloc.dispatch(GetTriviaForConcreteNumber(numberString));
      await untilCalled(mockGetConcreteNumberTrivia(any));

      verify(mockGetConcreteNumberTrivia(Params(number: numberParsed)));
    });

    test('should emit [Loading, Loaded] when data is gotten successfully', () async {
      setUpMockInputConverterSuccess();
      when(mockGetConcreteNumberTrivia(any)).thenAnswer((_) async => Right(numberTrivia));

      final expected = [Empty(), Loading(), Loaded(trivia: numberTrivia)];
      expectLater(bloc.state, emitsInOrder(expected));

      bloc.dispatch(GetTriviaForConcreteNumber(numberString));
    });

    test('should emit [Loading, Error] when getting data fails', () async {
      setUpMockInputConverterSuccess();
      when(mockGetConcreteNumberTrivia(any)).thenAnswer((_) async => Left(ServerFailure()));

      final expected = [Empty(), Loading(), Error(message: SERVER_FAILURE_MESSAGE)];
      expectLater(bloc.state, emitsInOrder(expected));

      bloc.dispatch(GetTriviaForConcreteNumber(numberString));
    });

    test('should emit [Loading, Error] with a proper message for the error hen getting data fails', () async {
      setUpMockInputConverterSuccess();
      when(mockGetConcreteNumberTrivia(any)).thenAnswer((_) async => Left(CacheFailure()));

      final expected = [Empty(), Loading(), Error(message: CACHE_FAILURE_MESSAGE)];
      expectLater(bloc.state, emitsInOrder(expected));

      bloc.dispatch(GetTriviaForConcreteNumber(numberString));
    });

  });

  group('GetTriviaForRandomNumber', () {
    final numberTrivia = NumberTrivia(text: 'test trivia', number: 1);

    test('should get data from the concrete use case', () async {
      when(mockGetRandomNumberTrivia(any)).thenAnswer((_) async => Right(numberTrivia));

      bloc.dispatch(GetTriviaForRandomNumber());
      await untilCalled(mockGetRandomNumberTrivia(any));

      verify(mockGetRandomNumberTrivia(NoParams()));
    });

    test('should emit [Loading, Loaded] when data is gotten successfully', () async {
      when(mockGetRandomNumberTrivia(any)).thenAnswer((_) async => Right(numberTrivia));

      final expected = [Empty(), Loading(), Loaded(trivia: numberTrivia)];
      expectLater(bloc.state, emitsInOrder(expected));

      bloc.dispatch(GetTriviaForRandomNumber());
    });

    test('should emit [Loading, Error] when getting data fails', () async {
      when(mockGetRandomNumberTrivia(any)).thenAnswer((_) async => Left(ServerFailure()));

      final expected = [Empty(), Loading(), Error(message: SERVER_FAILURE_MESSAGE)];
      expectLater(bloc.state, emitsInOrder(expected));

      bloc.dispatch(GetTriviaForRandomNumber());
    });

    test('should emit [Loading, Error] with a proper message for the error hen getting data fails', () async {
      when(mockGetRandomNumberTrivia(any)).thenAnswer((_) async => Left(CacheFailure()));

      final expected = [Empty(), Loading(), Error(message: CACHE_FAILURE_MESSAGE)];
      expectLater(bloc.state, emitsInOrder(expected));

      bloc.dispatch(GetTriviaForRandomNumber());
    });

  });
}
