package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.HomePage;
import br.com.linhares.crisley.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import static br.com.linhares.crisley.Propriedades.NOME_CONTA_ALTERADA;

public class HomeTest extends BaseTest {

    HomePage homePage = new HomePage();
    MenuPage menuPage = new MenuPage();

    @Test
    public void testVerificarSaldoConta(){
        menuPage.acessarTelaHome();
        Assert.assertEquals("1500.00", homePage.obterSaldoConta(NOME_CONTA_ALTERADA));
    }
}
