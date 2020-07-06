import 'dart:convert';

import 'package:meta/meta.dart';
import 'package:numbertrivia/core/error/exceptions.dart';
import 'package:numbertrivia/features/number_trivia/data/models/number_trivia_data.dart';
import 'package:shared_preferences/shared_preferences.dart';

abstract class NumberTriviaLocalDataSource {
  Future<NumberTriviaData> getLastNumberTrivia();

  Future<void> cacheNumberTrivia(NumberTriviaData numberTriviaData);
}

const CACHED_NUMBER_TRIVIA = 'CACHED_NUMBER_TRIVIA';

class NumberTriviaLocalDataSourceImpl implements NumberTriviaLocalDataSource {
  final SharedPreferences sharedPreferences;

  NumberTriviaLocalDataSourceImpl({@required this.sharedPreferences});

  @override
  Future<NumberTriviaData> getLastNumberTrivia() {
    final jsonString = sharedPreferences.getString(CACHED_NUMBER_TRIVIA);

    if (jsonString != null) {
      return Future.value(NumberTriviaData.fromJson(json.decode(jsonString)));
    }

    throw CacheException();
  }

  @override
  Future<void> cacheNumberTrivia(NumberTriviaData numberTriviaData) {
    return sharedPreferences.setString(CACHED_NUMBER_TRIVIA, jsonEncode(numberTriviaData.toJson()));
  }


}