package br.com.linhares.crisley.pages;

import br.com.linhares.crisley.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListarContas(){
        clicarLink("Contas");
        clicarLink("Listar");
    }

    public void acessarCriarMovimentacao(){
        clicarLink("Criar Movimentação");
    }

    public void acessarResumoMensal() {
        clicarLink("Resumo Mensal");
    }
}
