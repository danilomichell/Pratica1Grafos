# Primeira prática 1 da matéria de Teoria dos grafos
## Componentes
* Amadeu martim Silva De Oliveira  - 1191114977
* Danilo Michell Lisboa de Freitas - 1191133823
* Paulo Henrique Medeiros Bittencourt - 1191160405
## Tutorial de uso 
_Na classe Pratica1Grafos.java, substitua o nome do arquivo contido na variável "caminho" pelo nome do arquivo que contém o grafo desejado, respectivamente com o tipo do arquivo. Exemplo: "grafo1.txt". em seguida execute a classe "Main", onde inicialmente, os métodos devem ser ligados, exemplo: Grafo.imprimirGrafo(listas, vertices);, passando sempre os parâmetros corretamente. O sistema conta atualmente com 4 métodos sendo eles: imprimirGrafo, getAdjacentes, ehRegular e ehCompleto
* Funcionamento do método imprimirGrafos:
Na classe main, inicialize o método passando como paraâmetros a lista que contém o grafo e seus vertices, exemplo: Grafo.imprimirGrafo(listas, vertices);
* Funcionamento do método getAdjacentes:
Na classe "main", inicialize o método passando como parâmetro o vertice, o numero de vertice e a lista com grafos, exemplo: rafo.getAdjacentes("1", vertices, listas);
* Funcionamento do método ehRgular:
Na classe "main", inicialize o método passando como parâmetro os vertices e a lista com grafos, exemplo: boolean regular = grafo.ehRegular(vertices, listas);
**OBS**: na nossa classe "main" colocamos uma estrutura if/else para iformar se o grafo é regular ou não através da resposta fornecida pelo método ehRegular
* Funcionamento do método ehCompleto:
Na classe "main", inicialize o método passando como parâmetro o número de vertices e a lista com grafos, exemplo:  boolean completo = grafo.ehCompleto(vertices, listas);
**OBS**: na nossa classe "main" colocamos uma estrutura if/else para iformar se o grafo é regular ou não através da resposta fornecida pelo método ehCompleto_
