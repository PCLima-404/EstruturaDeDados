void main() {
  Set<String> participantes = {'Eduardo', 'Pedro', 'João'};

  participantes.add('Lucas'); 
  participantes.add('Sofia');

  participantes.remove('João');

  print(participantes.contains('Pedro') 
    ? 'Pedro está participando.' 
    : 'Pedro não está participando.');

  print('Total de participantes: ${participantes.length}');


  var participantesOrdenados = participantes.toList()..sort();
  print('Participantes (em ordem alfabética):');
  for (var participante in participantesOrdenados) {
    print(participante);
  }
}
