import 'package:bytebank/components/editor.dart';
import 'package:bytebank/models/transfer.dart';
import 'package:flutter/material.dart';

const appBarTitle = 'Formulário de Transferência';
const labelValue = 'Valor';

class FormularioTransferencia extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new FormularioTransferenciaState();
  }
}

class FormularioTransferenciaState extends State<FormularioTransferencia> {
  final _controllerAccountNumber = TextEditingController();
  final _controllerValue = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(appBarTitle),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Editor(
                controller: _controllerAccountNumber,
                label: "Número da Conta",
                hint: "0000"),
            Editor(
                controller: _controllerValue,
                label: labelValue,
                hint: "0.00",
                icon: Icons.monetization_on),
            RaisedButton(
              child: Text("Confirmar"),
              onPressed: () => _createTransfer(context),
            )
          ],
        ),
      ),
    );
  }

  void _createTransfer(BuildContext context) {
    final account = int.tryParse(_controllerAccountNumber.text);
    final value = double.tryParse(_controllerValue.text);

    if (account != null && value != null) {
      final transferencia = Transferencia(value, account);
      debugPrint("$transferencia");
      Navigator.pop(context, transferencia);
    }
  }
}