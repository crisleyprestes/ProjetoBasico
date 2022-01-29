package br.com.linhares.crisley.pages;

import br.com.linhares.crisley.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {

    public void setMes(String mes){
        selecionarCombo("mes", mes);
    }

    public void setAno(String ano){
        selecionarCombo("ano", ano);
    }

    public void buscar(){
        clicarBotao(By.xpath("//input[@value='Buscar']"));
    }

    public void excluirMovimentacao(String conta){
        obterCelula("Descrição", conta, "Ações", "tabelaExtrato").
                findElement(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }

    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
