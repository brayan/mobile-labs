import 'package:numbertrivia/features/number_trivia/domain/entities/number_trivia.dart';
import 'package:meta/meta.dart';

class NumberTriviaData extends NumberTrivia {
  NumberTriviaData({@required String text, @required int number})
      : super(text: text, number: number);

  factory NumberTriviaData.fromJson(Map<String, dynamic> json) {
    return NumberTriviaData(
        text: json['text'], number: (json['number'] as num).toInt());
  }

  Map<String, dynamic> toJson() {
    return {
      "text": text,
      "number": number
    };
  }
}
