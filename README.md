# ProjetoBasico


### Descrição

- Projeto referente às aplicações **_Campo de Treinamento_** e **_Seu Barriga_** utilizadas no curso **_Testes funcionais com Selenium WebDriver: Do básico ao GRID_** da Udemy.

### Setup do projeto

- Para executar o projeto são necessárias as seguintes dependências:

  - [Selenium WebDriver Java v3.11.0](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.11.0)
  - [JUnit v4.12](https://mvnrepository.com/artifact/junit/junit/4.12)
  - [Apache Commons-io v2.11.0](https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0)
  - [Maven Surefire Plugin v3.0.0-M5](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin/3.0.0-M5)
  - [Java v8u361](https://www.oracle.com/br/java/technologies/javase/javase8u211-later-archive-downloads.html)
  - [Google Chrome v110.0.5481.178](https://www.google.com/intl/pt-BR/chrome/)
  - [IntelliJ Idea IDE](https://www.jetbrains.com/idea/download/#section=windows) 
  - [Git v2.39.1](https://git-scm.com/downloads)

### Clonando/Importando o projeto

- Clone o projeto via CLI:
<pre>
git clone https://github.com/crisleyprestes/ProjetoBasico.git
</pre>

- Aguarde o _clone_ ser finalizado.

- Na sua IDE de preferência, faça o _import_ do projeto.

- Aguarde as dependências serem baixadas pelo **_Maven_** através do arquivo **_pom.xml_**.

#### Estutura do projeto

O projeto é estruturado conforme os diretórios abaixo:

- **_src_**: Contém o código da automação e demais estruturas.
  - **_pages_**: Contém as páginas das _feature_ das aplicações automatizadas.
  - **_suite_**: Contém a classe que gerencia a execução da automação.
  - **_tests_**: Contém os testes automatizados de cada _feature_.
  - **_utils_**: Contém a classe que gerencia as evidências de execução dos testes.
- **_drivers_**: Contém os drivers utilizados na automação.

**Notas**:
  - **Notas**: Cada teste automatizado, ao fim da execução gera um screenshot de evidência. Este arquivo é salvo em **_/target/screenshots_** e não é _commitado_ para o GitHub.
