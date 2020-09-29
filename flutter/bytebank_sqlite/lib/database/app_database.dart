import 'package:bytebank_sqlite/models/contact.dart';
import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';

Future<Database> createDatabase() async {
  final String dbPath = await getDatabasesPath();
  final String path = join(dbPath, "bytebank.db");

  return openDatabase(path, onCreate: _onCreateDatabase, version: 1);
}

Future<int> save(Contact contact) async {
  final Database database = await createDatabase();
  final Map<String, dynamic> contactMap = Map();

  contactMap["name"] = contact.name;
  contactMap["account_number"] = contact.accountNumber;

  return database.insert("contacts", contactMap);
}

Future<List<Contact>> findAll() async {
  final Database database = await createDatabase();

  final List<Map<String, dynamic>> contactsDataMap = await database.query("contacts");
  final List<Contact> contacts = List();

  for (Map<String, dynamic> contactsMap in contactsDataMap) {
    final Contact contact = Contact(
      contactsMap["id"],
      contactsMap["name"],
      contactsMap["account_number"],
    );

    contacts.add(contact);
  }

  return contacts;
}

void _onCreateDatabase(Database database, int version) {
  database.execute("CREATE TABLE contacts("
      "id INTEGER PRIMARY KEY, "
      "name TEXT, "
      "account_number INTEGER)");
}
