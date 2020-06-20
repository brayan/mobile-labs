class Transferencia {
  final double value;
  final int accountNumber;

  Transferencia(this.value, this.accountNumber);

  @override
  String toString() {
    return 'Transferencia{value: $value, accountNumber: $accountNumber}';
  }
}