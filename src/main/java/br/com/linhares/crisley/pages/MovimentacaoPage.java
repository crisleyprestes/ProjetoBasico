package br.com.linhares.crisley.pages;

import br.com.linhares.crisley.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static br.com.linhares.crisley.DriverFactory.getDriver;

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

    public List<String> obterErros(){
        List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<String>();
        for(WebElement erro: erros){
            retorno.add(erro.getText());
        }
        return retorno;
    }

}
