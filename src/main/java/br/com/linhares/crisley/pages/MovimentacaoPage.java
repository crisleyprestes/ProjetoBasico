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

    public void setValor(String valor){
        escrever("valor", valor);
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

    public String obterMsgErroDataMovimentacao(){
        return obterTexto(By.xpath("//li[.='Data da Movimentação é obrigatório']"));
    }

    public String obterMsgErroDataPagamento(){
        return obterTexto(By.xpath("//li[.='Data do pagamento é obrigatório']"));
    }

    public String obterMsgErroDescricao(){
        return obterTexto(By.xpath("//li[.='Descrição é obrigatório']"));
    }

    public String obterMsgErroInteressado(){
        return obterTexto(By.xpath("//li[.='Interessado é obrigatório']"));
    }

    public String obterMsgErroValor(){
        return obterTexto(By.xpath("//li[.='Valor é obrigatório']"));
    }

    public String obterValidacaoErroValor(){
        return obterTexto(By.xpath("//li[.='Valor deve ser um número']"));
    }

    public String obterErroDataMovimentacaoMenorDataAtual() {
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }
}
