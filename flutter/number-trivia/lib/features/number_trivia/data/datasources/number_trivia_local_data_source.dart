import 'package:numbertrivia/features/number_trivia/data/models/number_trivia_data.dart';
import 'package:numbertrivia/features/number_trivia/domain/entities/number_trivia.dart';

abstract class NumberTriviaLocalDataSource {
  Future<NumberTrivia> getLastNumberTrivia();

  Future<void> cacheNumberTrivia(NumberTriviaData numberTriviaData);
}
