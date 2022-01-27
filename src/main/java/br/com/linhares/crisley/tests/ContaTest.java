package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.ContasPage;
import br.com.linhares.crisley.pages.MenuPage;
import br.com.linhares.crisley.pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();
    MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

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
    public void testInserirMovimentacao(){
        menuPage.acessarCriarMovimentacao();
        movimentacaoPage.tipoDaMovimentacao("Receita");
        movimentacaoPage.dataDaMovimentacao("25/08/2019");
        movimentacaoPage.dataDoPagamento("25/09/2019");
        movimentacaoPage.descricao("Testando movimentação");
        movimentacaoPage.interessado("Usuário de Teste");
        movimentacaoPage.valor(Integer.valueOf("1500"));
        movimentacaoPage.conta("Testando novamente");
        movimentacaoPage.situacaoPendente();
        movimentacaoPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
    }

}
