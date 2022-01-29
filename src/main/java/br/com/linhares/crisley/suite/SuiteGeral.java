package br.com.linhares.crisley.suite;

import br.com.linhares.crisley.DriverFactory;
import br.com.linhares.crisley.pages.LoginPage;
import br.com.linhares.crisley.tests.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContasTest.class,
        MovimentacaoTest.class,
        RemoverContaMovimentacaoTest.class,
        HomeTest.class,
        ResumoTest.class
})
public class SuiteGeral {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void reset(){
        page.acessarTelaInicial();
        page.setEmail("prestes40@gmail.com");
        page.setSenha("c19-p02-l90");
        page.entrar();
        page.resetar();
        DriverFactory.killDriver();
    }
}
