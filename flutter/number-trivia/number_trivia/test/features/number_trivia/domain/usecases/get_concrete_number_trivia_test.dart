import 'package:dartz/dartz.dart';
import 'package:mockito/mockito.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:numbertrivia/features/number_trivia/domain/entities/number_trivia.dart';
import 'package:numbertrivia/features/number_trivia/domain/repositories/number_trivia_repository.dart';
import 'package:numbertrivia/features/number_trivia/domain/usecases/get_concrete_number_trivia.dart';

class MockNumberTriviaRepository extends Mock
    implements NumberTriviaRepository {}

void main() {
  GetConcreteNumberTrivia getConcreteNumberTrivia;
  MockNumberTriviaRepository mockRepository;

  setUp(() {
    mockRepository = MockNumberTriviaRepository();
    getConcreteNumberTrivia = GetConcreteNumberTrivia(mockRepository);
  });

  final tNumber = 1;
  final tNumberTrivia = NumberTrivia(number: 1, text: 'test');
  test(
    'should get trivia for the number from the repository',
    () async {
      when(mockRepository.getConcreteNumberTrivia(any))
          .thenAnswer((_) async => Right(tNumberTrivia));

      final result = await getConcreteNumberTrivia.execute(number: tNumber);

      expect(result, Right(tNumberTrivia));
      verify(mockRepository.getConcreteNumberTrivia(tNumber));
      verifyNoMoreInteractions(mockRepository);
    },
  );
}
