import 'package:bytebank/models/transfer.dart';
import 'package:bytebank/screens/transfer/transfer_form.dart';
import 'package:flutter/material.dart';

class ListaTransferencias extends StatefulWidget {
  // only constants stay here.. variables goes to the state
  final List<Transferencia> _transfers = List();

  @override
  State<StatefulWidget> createState() {
    return ListaTransferenciasState();
  }
}

class ListaTransferenciasState extends State<ListaTransferencias> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Transferências'),
        ),
        body: ListView.builder(
          itemCount: widget._transfers.length,
          itemBuilder: (context, index) {
            final transfer = widget._transfers[index];
            return ItemTransferencia(transfer);
          },
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.add),
          onPressed: () => onClickAddTransfer(context),
        ));
  }

  void onClickAddTransfer(context) {
    Navigator.push(context, MaterialPageRoute(builder: (context) {
      return FormularioTransferencia();
    })).then((transfer) {
      if (transfer != null) {
        setState(() {
          widget._transfers.add(transfer);
        });
      }
    });
  }
}

class ItemTransferencia extends StatelessWidget {
  final Transferencia _transferencia;

  ItemTransferencia(this._transferencia);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        leading: Icon(Icons.monetization_on),
        title: Text(_transferencia.value.toString()),
        subtitle: Text(_transferencia.accountNumber.toString()),
      ),
    );
  }
}
