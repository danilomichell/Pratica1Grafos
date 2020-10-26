# Primeira prática 1 da matéria de Teoria dos grafos
## Componentes
* Amadeu martim Silva De Oliveira  - 1191114977
* Danilo Michell Lisboa de Freitas - 1191133823
* Paulo Henrique Medeiros Bittencourt - 1191160405
## Tutorial de uso 
_Na classe Pratica1Grafos.java, substitua o nome do arquivo contido na variável "caminho" pelo nome do arquivo que contém o grafo desejado, respectivamente com o tipo do arquivo. Exemplo: "grafo1.txt". em seguida execute a classe "Main", onde inicialmente, os métodos devem ser ligados, exemplo: Grafo.imprimirGrafo(listas, vértices);, passando sempre os parâmetros corretamente. O sistema conta atualmente com 4 métodos sendo eles: imprimirGrafo, getAdjacentes, ehRegular e ehCompleto
* Funcionamento do método imprimirGrafos:
Na classe main, inicialize o método passando como parâmetros a lista que contém o grafo e seus vértices, exemplo: Grafo.imprimirGrafo(listas, vértices);
* Funcionamento do método getAdjacentes:
Na classe "main", inicialize o método passando como parâmetro o vértice, o numero de vértice e a lista com grafos, exemplo: Grafo.getAdjacentes("1", vértices, listas);
* Funcionamento do método ehRegular:
Na classe "main", inicialize o método usando como parâmetro os vértices e a lista com grafos, exemplo: boolean regular = grafo.ehRegular(vértices, listas);
**OBS**: na nossa classe "main" colocamos uma estrutura if/else para informar se o grafo é regular ou não através da resposta fornecida pelo método ehRegular

* Funcionamento do método ehCompleto:
Na classe "main", inicialize o método passando como parâmetro o número de vértices e a lista com grafos, exemplo:  boolean completo = grafo.ehCompleto(vértices, listas);
**OBS**: na nossa classe "main" colocamos uma estrutura if/else para informar se o grafo é completo ou não através da resposta fornecida pelo método ehCompleto_

* Funcionamento do método buscaLargura:
Na classe “grafo”, utilize ele para fazer com que faça uma busca em largura, que é percorrer todo o grafo e no processo ele marca quem foi visitado para não adicionar mais esse valor na fila, depois do processo feito ele retorna os valores visitados.
**OBS**:no método buscaLargura é preciso substituir qual vértice vai iniciar a busca.

* Funcionamento do método ehConexo:
Na classe "main", inicialize o método usando como parâmetro os vértices e a lista com os grafos(O vértice inicial já foi alocado no metodo buscaLargura) e ele irá retornar o valor booleano se é falso ou verdadeiro, caso o grafo seja conexo, que é ser um grafo onde todos os vértices estão ligados.
**OBS_1**: Foi preciso trocar o caminho poís estava dando erro na hora da de compilar e rodar o código no Visual Studio
**OBS_2**: na nossa classe "main" colocamos uma estrutura if/else para informar se o grafo é conexo ou não através da resposta fornecida pelo método ehConexo_

* Funcionamento do algoritmo de Menor caminho(Dijkstra):
Nessa tarefa nós implementamos o algoritmo de menor caminho em java, seu funcionamento se da dessa forma, escolhe um vértice de origem e marca o mesmo, "adiciona seus adjacentes em uma lista" seus adjacentes junto com a distancia que decorre do mesmo, após isso ele escolhe o que tem a menor distancia e vai para ele, nisso ele faz o mesmo processo agora com o valor da distancia anterior exemplo: A para B tem a distancia de 3, e de B para C tem a distancia de 4 + 3(Distancia vinda de A para B), Após isso faz esse processo até que todos estejam marcados.
**OBS_1**: Nós tivemos que "refazer" e seperar esse algoritmo poís ele utiliza matris, algo que nós não usamos nas outras implementações.



