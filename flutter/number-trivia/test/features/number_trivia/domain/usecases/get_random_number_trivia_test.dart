import 'package:dartz/dartz.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mockito/mockito.dart';
import 'package:numbertrivia/core/usecases/usecase.dart';
import 'package:numbertrivia/features/number_trivia/domain/entities/number_trivia.dart';
import 'package:numbertrivia/features/number_trivia/domain/repositories/number_trivia_repository.dart';
import 'package:numbertrivia/features/number_trivia/domain/usecases/get_random_number_trivia.dart';

class MockNumberTriviaRepository extends Mock
    implements NumberTriviaRepository {}

void main() {
  GetRandomNumberTrivia getRandomNumberTrivia;
  MockNumberTriviaRepository mockRepository;

  setUp(() {
    mockRepository = MockNumberTriviaRepository();
    getRandomNumberTrivia = GetRandomNumberTrivia(mockRepository);
  });

  final tNumberTrivia = NumberTrivia(number: 1, text: 'test');
  test(
    'should get trivia from the repository',
        () async {
      when(mockRepository.getRandomNumberTrivia())
          .thenAnswer((_) async => Right(tNumberTrivia));

      final result = await getRandomNumberTrivia(NoParams());

      expect(result, Right(tNumberTrivia));
      verify(mockRepository.getRandomNumberTrivia());
      verifyNoMoreInteractions(mockRepository);
    },
  );
}