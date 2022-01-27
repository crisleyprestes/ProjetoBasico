package br.com.linhares.crisley.pages;

import br.com.linhares.crisley.BasePage;
import org.openqa.selenium.By;

public class MovimentacaoPage extends BasePage {

    public void tipoDaMovimentacao(String opcao){
        selecionarCombo("tipo", opcao);
    }

    public void dataDaMovimentacao(String data){
        escrever("data_transacao", data);
    }

    public void dataDoPagamento(String data){
        escrever("data_pagamento", data);
    }

    public void descricao(String texto){
        escrever("descricao", texto);
    }

    public void interessado(String nome){
        escrever("interessado", nome);
    }

    public void valor(Integer valor){
        escrever("valor", String.valueOf(valor));
    }

    public void conta(String conta){
        selecionarCombo("conta", conta);
    }

    public void situacaoPendente(){
        clicarRadio("status_pendente");
    }

    public void salvar(){
        clicarBotao(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
