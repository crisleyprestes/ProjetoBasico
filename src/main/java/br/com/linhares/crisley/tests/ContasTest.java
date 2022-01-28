package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.ContasPage;
import br.com.linhares.crisley.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ContasTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();
    MovimentacaoTest movimentacaoTest = new MovimentacaoTest();

    @Test
    public void testInserirConta(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Humberto Corrêa");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testAlterarConta(){
        menuPage.acessarTelaListarContas();
        contasPage.clicarAlterarConta("Testando");
        contasPage.setNome("Testando novamente");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testInserirContaComMesmoNome(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Humberto Corrêa");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }

    @Test
    public void testExcluirContaComMovimentacao(){
        movimentacaoTest.testInserirMovimentacaoPendente();
        menuPage.acessarTelaListarContas();
        contasPage.clicarExcluirConta("Testando novamente");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}