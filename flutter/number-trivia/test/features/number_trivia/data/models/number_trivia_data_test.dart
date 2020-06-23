import 'dart:convert';

import 'package:flutter_test/flutter_test.dart';
import 'package:numbertrivia/features/number_trivia/data/models/number_trivia_data.dart';
import 'package:numbertrivia/features/number_trivia/domain/entities/number_trivia.dart';

import '../../../../fixtures/fixture_reader.dart';

void main() {
  final numberTriviaData = NumberTriviaData(number: 1, text: 'Test Text');

  test('should be a subclass of NumberTrivia entity', () async {
    expect((numberTriviaData), isA<NumberTrivia>());
  });

  group('map NumberTriviaData from JSON', () {
    test('should return a valid data model when the JSON number is an integer',
        () async {
      final Map<String, dynamic> jsonMap = json.decode(fixture('trivia.json'));
      final result = NumberTriviaData.fromJson(jsonMap);
      expect(result, numberTriviaData);
    });

    test(
        'should return a valid data model when the JSON number is regarded as a double',
        () async {
      final Map<String, dynamic> jsonMap =
          json.decode(fixture('trivia_double.json'));

      final result = NumberTriviaData.fromJson(jsonMap);
      expect(result, numberTriviaData);
    });
  });

  group('map NumberTriviaData to JSON', () {
    test('should return a JSON map containing the proper data', () async {
      final result = numberTriviaData.toJson();
      final expectedMap = {"text": "Test Text", "number": 1};
      expect(result, expectedMap);
    });
  });
}
