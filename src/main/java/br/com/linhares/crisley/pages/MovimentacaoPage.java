package br.com.linhares.crisley.pages;

import br.com.linhares.crisley.BasePage;
import org.openqa.selenium.By;

public class MovimentacaoPage extends BasePage {

    public void setTipoDaMovimentacao(String opcao){
        selecionarCombo("tipo", opcao);
    }

    public void setDataDaMovimentacao(String data){
        escrever("data_transacao", data);
    }

    public void setDataDoPagamento(String data){
        escrever("data_pagamento", data);
    }

    public void setDescricao(String texto){
        escrever("descricao", texto);
    }

    public void setInteressado(String nome){
        escrever("interessado", nome);
    }

    public void setValor(Integer valor){
        escrever("valor", String.valueOf(valor));
    }

    public void setConta(String conta){
        selecionarCombo("conta", conta);
    }

    public void setSituacaoPago(){
        clicarRadio("status_pago");
    }

    public void salvar(){
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
