# ProjetoBasico


### Descrição

- Esta projeto se refere às aplicações **_Campo de Treinamento_** e **_Seu Barriga_** utilizadas como prática no curso **_Testes funcionais com Selenium WebDriver: Do básico ao GRID_** da Udemy.

### Setup do projeto

Para executar o projeto são necessários as seguintes aplicações/ferramentas:

- Selenium WebDriver Java v3.11.0
- JUnit v4.12
- Apache Commons-io v2.11.0
- Maven Surefire Plugin v3.0.0-M5
- Java
- Google Chrome
- IntelliJ Idea IDE
- Git

### Clonando o projeto

- Clone o projeto:
<pre>git clone https://github.com/crisleyprestes/ProjetoBasico.git</pre>

- Importe o projeto para a IDE

### Estutura do projeto

O projeto é constituído dos seguintes diretórios/arquivos:

- **_src_**: Diretório com o código da automação e estruturas utilizadas no projeto. Dentro dele estão os seguintes diretórios/arquivos:
  - **_pages_**: Classes de páginas de cadas _feature_ das aplicações **_Campo de Treinamento_** e **_Seu Barriga_**.
  - **_suite_**: Tem a classe **_SuiteGeral.java_**, utilizada para ordenar a execução das classes de teste dentro da automação.
  - **_tests_**: Classes com os testes automatizados para cada _feature_ das aplicações **_Campo de Treinamento_** e **_Seu Barriga_**.
  - **_utils_**: Tem a classe **_DataUtils.java_**, com métodos para a coleta de data formatada para uso em métodos de teste e geração de evidências de execução dos testes.
  - **_BasePage.java_**: Classe com os métodos gerais utilizados ao longo do projeto de automação.
  - **_BaseTest.java_**: Classe com os métodos gerais utilizados na execução das classes de teste automatizadas.
  - **_DriverFactory.java_**: Classe que instancia o _driver_ do _Selenium_ e determina a configuração de acesso às aplicações **_Campo de Treinamento_** e **_Seu Barriga_** a depender do tipo de conexão do teste e do navegador utilizados nos testes.
  - **_Propriedades.java_**: Classe que passa os parâmetros de acesso de conexão e browser a serem utilizados nas aplicações **_Campo de Treinamento_** e **_Seu Barriga_**.

- **_drivers_**: Diretório com os drivers utilizados na automação.
  - **_chromedriver_**: Driver do _Chrome_.
  - **_geckdriver_**: Driver do _Firefox_.
