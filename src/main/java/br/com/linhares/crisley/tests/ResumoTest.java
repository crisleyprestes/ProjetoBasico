package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.MenuPage;
import br.com.linhares.crisley.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTest extends BaseTest {

    private ResumoPage resumoPage = new ResumoPage();
    private MenuPage menuPage = new MenuPage();

    @Test
    public void testExcluirMovimentacao(){
        menuPage.acessarResumoMensal();
        resumoPage.setMes("Agosto");
        resumoPage.setAno("2019");
        resumoPage.clicarBotaoPorValue("Buscar");
        resumoPage.excluirMovimentacao("Testando novamente");
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }
}
