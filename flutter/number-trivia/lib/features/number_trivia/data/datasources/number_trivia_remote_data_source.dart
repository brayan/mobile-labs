import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:meta/meta.dart';
import 'package:numbertrivia/core/error/exceptions.dart';
import 'package:numbertrivia/features/number_trivia/data/models/number_trivia_data.dart';

abstract class NumberTriviaRemoteDataSource {
  Future<NumberTriviaData> getConcreteNumberTrivia(int number);

  Future<NumberTriviaData> getRandomNumberTrivia();
}

class NumberTriviaRemoteDataSourceImpl implements NumberTriviaRemoteDataSource {
  final http.Client client;

  NumberTriviaRemoteDataSourceImpl({@required this.client});

  @override
  Future<NumberTriviaData> getConcreteNumberTrivia(int number) => _getTriviaFromUrl('http://numbersapi.com/$number');

  @override
  Future<NumberTriviaData> getRandomNumberTrivia() => _getTriviaFromUrl('http://numbersapi.com/random');

  Future<NumberTriviaData> _getTriviaFromUrl(String url) async {
    final response = await client.get(url, headers: {
      'Content-Type': 'application/json',
    });

    if (response.statusCode == 200) {
      return NumberTriviaData.fromJson(jsonDecode(response.body));
    } else {
      throw ServerException();
    }
  }
}
