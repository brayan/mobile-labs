import 'dart:convert';

import 'package:flutter_test/flutter_test.dart';
import 'package:http/http.dart' as http;
import 'package:matcher/matcher.dart';
import 'package:mockito/mockito.dart';
import 'package:numbertrivia/core/error/exceptions.dart';
import 'package:numbertrivia/features/number_trivia/data/datasources/number_trivia_remote_data_source.dart';
import 'package:numbertrivia/features/number_trivia/data/models/number_trivia_data.dart';

import '../../../../fixtures/fixture_reader.dart';

class MockHttpClient extends Mock implements http.Client {}

void main() {
  NumberTriviaRemoteDataSourceImpl dataSource;
  MockHttpClient mockHttpClient;

  setUp(() {
    mockHttpClient = MockHttpClient();
    dataSource = NumberTriviaRemoteDataSourceImpl(client: mockHttpClient);
  });

  void setUpMockHttpClientSuccess200() {
    when(mockHttpClient.get(any, headers: anyNamed('headers')))
        .thenAnswer((_) async => http.Response(fixture('trivia.json'), 200));
  }

  void setUpMockHttpClientFailure404() {
    when(mockHttpClient.get(any, headers: anyNamed('headers')))
        .thenAnswer((_) async => http.Response('Something went wrong', 404));
  }

  group('getConcreteNumberTrivia', () {
    final number = 1;
    final numberTriviaData = NumberTriviaData.fromJson(jsonDecode(fixture('trivia.json')));

    test('should perform a GET request on a URL with number being the endpoint and with application/json header',
        () async {
      setUpMockHttpClientSuccess200();

      dataSource.getConcreteNumberTrivia(number);

      verify(mockHttpClient.get('http://numbersapi.com/$number', headers: {
        'Content-Type': 'application/json',
      }));
    });

    test('should return NumberTriviaData when the response code is 200 (success)', () async {
      setUpMockHttpClientSuccess200();

      final result = await dataSource.getConcreteNumberTrivia(number);

      expect(result, equals(numberTriviaData));
    });

    test('should throw a ServerException when the response code is 404 or other', () async {
      setUpMockHttpClientFailure404();

      final call = dataSource.getConcreteNumberTrivia;

      expect(() => call(number), throwsA(TypeMatcher<ServerException>()));
    });
  });

  group('getRandomNumberTrivia', () {
    final numberTriviaData = NumberTriviaData.fromJson(jsonDecode(fixture('trivia.json')));

    test('should perform a GET request on a URL with number being the endpoint and with application/json header',
            () async {
          setUpMockHttpClientSuccess200();

          dataSource.getRandomNumberTrivia();

          verify(mockHttpClient.get('http://numbersapi.com/random', headers: {
            'Content-Type': 'application/json',
          }));
        });

    test('should return NumberTriviaData when the response code is 200 (success)', () async {
      setUpMockHttpClientSuccess200();

      final result = await dataSource.getRandomNumberTrivia();

      expect(result, equals(numberTriviaData));
    });

    test('should throw a ServerException when the response code is 404 or other', () async {
      setUpMockHttpClientFailure404();

      final call = dataSource.getRandomNumberTrivia;

      expect(() => call(), throwsA(TypeMatcher<ServerException>()));
    });
  });
}
