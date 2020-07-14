import 'package:dartz/dartz.dart';
import 'package:numbertrivia/core/error/failures.dart';

class InputConverter {
  Either<Failure, int> stringToUnsignedInteger(String str) {
    final integer = int.tryParse(str);

    if (integer == null || integer.isNegative) {
      return Left(InvalidInputFailure());
    }

    return Right(integer);
  }
}

class InvalidInputFailure extends Failure {}