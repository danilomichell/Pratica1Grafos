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

* Funcionamento do algoritmo de Menor caminho(Dijkstra): Explicando o funcionamento do código do algoritmo de Dijkstra(Menor caminho), na classe main utiliza o método carregarGrafoDijkstra() para carregar o grafo do caminho adicionado na classe GrafoDijkstra, depois para usar o método menorCaminho1() precisa passar os vértices precisam ser passados com a seguinte expressão "A" fazendo assim por meio de String chamar o mesmo com esse nome e por fim coloca o próprio grafo sendo instanciado, mesma explicação para o outro método, agora passando dois vértices para que faça o menor caminho entre eles. Exemplo: menorCaminho1("A", grafo2); 
**OBS_1**: Nós tivemos que fazer separado do algoritmo que representa o grafo em lista encadeada, pois ele representa o grafo através de uma matriz, algo que nós não usamos nas outras implementações.




