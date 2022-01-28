package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.MenuPage;
import br.com.linhares.crisley.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTest extends BaseTest {

    private ResumoPage resumoPage = new ResumoPage();
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoTest movimentacaoTest = new MovimentacaoTest();

    @Test
    public void testExcluirMovimentacao(){
        movimentacaoTest.testInserirMovimentacaoPendente();
        menuPage.acessarTelaResumoMensal();
        resumoPage.setMes("Janeiro");
        resumoPage.setAno("2022");
        resumoPage.buscar();
        resumoPage.excluirMovimentacao("Testando novamente");
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }
}
