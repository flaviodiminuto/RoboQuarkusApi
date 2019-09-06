# RoboQuarkusApi
Estudo de Quarkus/api/java/design pattern e paciencia :)

# Preparação para testar
### Adicionando bateria
* Adicione um diretório a partir do diretório raiz chamado "robo"
* Por exemplo:
  * Windows `C:/robo/bateria.txt`
  * Linux `/robo/bateria.txt`
* A bateria.txt deve conter linhas com valores separados por `;`
* Campos da bateria devem ser `NomeDoRobo`,`nivelBateria`,`Data (dd/mm/yyy 00:00:00)`
  * exemplo de uma linha: `Romarinho;5;24/09/1988 01:14:00`

# Testando
Com a bateria preparada podemos iniciar a aplicação

### Iniciando aplicação
* Caso já tenha as variáveis de ambiente configuradas JAVA_HOME, PATH, navegue até a pasta `target` dentro da pasta raiz do projeto.
* Execute o commando java -jar robo-beta-1.0-SNAPSHOT.jar que já estã compilado

Dicas:
* Sem as variáveis de ambiente configuradas será necessário fornecer caminho completo para executar do java
  * exemplo: `java -jar C:/robo/RoboQuarkusApi/target/robo-beta-1.0-SNAPSHOT.jar` (Acredito ser isso)
* Tente deixar a pasta do projeto proximo a masta raiz do sistema

### Chamadas ao Robo
Com a aplicação iniciada utilize o endereco da máquina + porta+ chamada
  * exemplo de execução local - `http://localhost:8080/robo/Romarinho/ligar`

* GET /robo
  * Produces: text/plain
  * exemplo - `http://localhost:8080/robo`
* GET /robo/{nomerobo}
  * Produces: text/plain
  * exemplo - `http://localhost:8080/robo/Romarinho`
* GET /robo/{nomerobo}/{valor1}/{operacao}/{valor2}
  * Produces: text/plain
    * Operacoes disponíveis - `somar`,`subtrair`,`multiplicar`,`dividir`
    * exemplo - `http://localhost:8080/robo/Romarinho/24/multiplicar/58`
* GET /robo/{nomerobo}/{operacao}
  * Produces: text/plain
    * operação disponivel - `ligar`
    * exemplo - `http://localhost:8080/robo/Romarinho/ligar`

  
### Importante
  * Não esqueça de colocar o arquivo para bateria.txt na pasta robo que estã na pasta raiz do sistema

### Enfim
  Nada muito complexo e sim empolgante,
  ### Mão na massa!

#### Consulte também 
* [Quarkus.io](https://quarkus.io "Quarkus.io Home")
* [Quarkus GetStarted](https://quarkus.io/guides/getting-started-guide "Quarkus Get Started")
