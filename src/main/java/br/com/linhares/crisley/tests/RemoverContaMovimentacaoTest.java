package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.ContasPage;
import br.com.linhares.crisley.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import static br.com.linhares.crisley.Propriedades.NOME_CONTA_ALTERADA;

public class RemoverContaMovimentacaoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaComMovimentacao(){
        menuPage.acessarTelaListarContas();
        contasPage.clicarExcluirConta(NOME_CONTA_ALTERADA);
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
