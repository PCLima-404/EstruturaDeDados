void main() {
  Map<String, double> cardapio = {
    'Café': 3.50,
    'Sanduíche': 7.00,
    'Suco': 5.00,
  };

  cardapio['Bolo'] = 4.00;

  cardapio['Sanduíche'] = 8.00;

  print('Preço do café: R\$${cardapio['Café']}');

  cardapio.remove('Suco');

  print(cardapio.containsKey('Bolo') 
    ? 'Bolo disponível por R\$${cardapio['Bolo']}' 
    : 'Bolo não encontrado.');

  print('Cardápio completo:');
  for (var item in cardapio.entries) {
    print('${item.key} - R\$${item.value}');
  }
}
