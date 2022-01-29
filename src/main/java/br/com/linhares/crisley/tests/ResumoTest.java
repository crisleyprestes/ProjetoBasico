package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.DriverFactory;
import br.com.linhares.crisley.pages.MenuPage;
import br.com.linhares.crisley.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static br.com.linhares.crisley.DriverFactory.getDriver;

public class ResumoTest extends BaseTest {

    ResumoPage resumoPage = new ResumoPage();
    MenuPage menuPage = new MenuPage();

   @Test
    public void testExcluirMovimentacao(){
        menuPage.acessarTelaResumoMensal();
        resumoPage.setMes("Janeiro");
        resumoPage.setAno("2022");
        resumoPage.buscar();
        resumoPage.excluirMovimentacao("Movimentacao para exclusao");
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }

    @Test
    public void testResumoMensal(){
        menuPage.acessarTelaResumoMensal();
        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

        resumoPage.setMes("Dezembro");
        resumoPage.setAno("2021");
        resumoPage.buscar();

        List<WebElement> elementosEncontrados= DriverFactory.getDriver().
                findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0, elementosEncontrados.size());
    }
}
