
void main() {
  List<String> filaClientes = ['Mary', 'Henrique', 'Marco'];


  filaClientes.add('Pc');

  filaClientes.insert(1, 'Eduardo');

  print('Atendendo: ${filaClientes[0]}'); 

  filaClientes.remove('Henrique');

  filaClientes.removeAt(0); 

  if (filaClientes.contains('Mary')) {
    print('Ainda está aguardando');
  }else{print("desistiu ou foi atendida")}

  filaClientes.sort();

  print('Fila atual: $filaClientes');
}
