## O Problema

Um time de robôs deve ser colocado pela NASA para explorar um terreno em Marte. Esse terreno, que é retangular, precisa 
ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região, enviando 
essas imagens novamente para a Terra.

A posição de cada robô é representada pela combinação de coordenadas cartesianas `(x, y)` e por uma letra, que pode 
representar uma das quatro orientações: `NORTH`, `SOUTH`, `EAST` e `WEST`. 

Para simplificar a navegação, a região "marciana" a ser explorada foi subdividia em sub-regiões retangulares. Uma posição 
válida de um robô, seria `(0, 0, N)`, que significa que o robô está posicionado no canto esquerdo inferior do terreno, voltado para o Norte.

Para controlar cada robô, a NASA envia uma string simples, que pode conter as letras `L`, `R` e `M`. As letras `L` e `R` 
fazem o robô rotacionar em seu próprio eixo 90 graus para esquerda ou para direita, respectivamente, sem se mover 
da sua posição atual. A letra `M` faz o robô deslocar-se uma posição para frente.

Assuma que um robô se movimenta para o Norte em relação ao eixo y. Ou seja, um passo para o Norte da posição `(x, y)`, é a posição `(x, y+1)`.

Exemplo: Se o robô está na posição `(0,0,N)`, o comando `MML` fará ele chegar na posição `(0,2,W)`

## Iniciando a Aplicação

Projeto Java implementado utilizando Java 17, Spring Boot, gerenciamento de builds com Maven. A interface de comunicação com o robô é REST.

### Requisitos

* Maven
* Java 17

### Gerando o Pacote

Sendo um projeto Maven, execute os goals `clean` e `install` na raiz do projeto para baixar as dependências e gerar `jar` do projeto.

```bash
$ mvn clean install
```

### Executando o Jar

Como se trata de um projeto Spring Boot, podemos simplismente executar o `jar` que foi gerado na pasta `target` e a aplicação irá subir em um tomcat embedded.

```bash
$ java -jar explorerapp-0.0.1-SNAPSHOT.jar
```

Pronto, a aplicação deve estar online na porta `8080`.


## API

**ENDPOINT**

```
POST http://localhost:8080/rest/mars/{command}
```

Exemplo de endpoint: `http://localhost:8080/rest/mars/MMRMMRMM`

**PARÂMETROS DA REQUISIÇÃO**

Parâmetro | Descrição
------------ | -------------
`command` | Comando que será utilizado pelo robô para chegar até determinada posição. Ex: `MMRMMRMM`.

**RESPOSTAS POSSÍVEIS**

Código | Resposta
------------ | -------------
`200` | `(2, 0, S)` 
`400` | `Comando inválido.`
