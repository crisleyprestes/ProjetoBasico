package br.com.linhares.crisley.pages;

import br.com.linhares.crisley.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome){
        escrever("nome", nome);
    }

    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMensagemErro(){
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void salvar(){
        clicarBotaoPorTexto("Salvar");
    }

    public void clicarAlterarConta(String nomeConta){
        obterCelula("Conta", nomeConta, "Ações", "tabelaContas").
                findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public void clicarExcluirConta(String nomeConta){
        obterCelula("Conta", nomeConta, "Ações", "tabelaContas").
                findElement(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
