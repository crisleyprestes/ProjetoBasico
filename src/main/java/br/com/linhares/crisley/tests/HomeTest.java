package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class HomeTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void testVerificarSaldoConta(){
        Assert.assertEquals("1500.00", homePage.obterSaldoConta("Novo Usuário de Teste"));
    }
}
