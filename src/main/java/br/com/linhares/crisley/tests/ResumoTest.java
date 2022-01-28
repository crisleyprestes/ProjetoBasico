package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.MenuPage;
import br.com.linhares.crisley.pages.ResumoPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static br.com.linhares.crisley.DriverFactory.getDriver;
import static br.com.linhares.crisley.Propriedades.NOME_CONTA_ALTERADA;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

    ResumoPage resumoPage = new ResumoPage();
    MenuPage menuPage = new MenuPage();

    @Test
    public void test1_ExcluirMovimentacao(){
        menuPage.acessarTelaResumoMensal();
        resumoPage.setMes("Janeiro");
        resumoPage.setAno("2022");
        resumoPage.buscar();
        resumoPage.excluirMovimentacao(NOME_CONTA_ALTERADA);
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }

    @Test
    public void test2_ResumoMensal(){
        menuPage.acessarTelaResumoMensal();
        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
    }
}
