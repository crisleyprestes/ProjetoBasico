package br.com.linhares.crisley.pages;

import br.com.linhares.crisley.BasePage;

public class HomePage extends BasePage {

    public String obterSaldoConta(String nomeConta){
           return obterCelula("Conta", nomeConta, "Saldo", "tabelaSaldo").getText();
        }
}
