package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.MenuPage;
import br.com.linhares.crisley.pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

public class MovimentacaoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void testInserirMovimentacao(){
        menuPage.acessarCriarMovimentacao();
        movimentacaoPage.setTipoDaMovimentacao("Receita");
        movimentacaoPage.setDataDaMovimentacao("25/08/2019");
        movimentacaoPage.setDataDoPagamento("25/09/2019");
        movimentacaoPage.setDescricao("Testando movimentação");
        movimentacaoPage.setInteressado("Usuário de Teste");
        movimentacaoPage.setValor("1500");
        movimentacaoPage.setConta("Testando novamente");
        movimentacaoPage.setSituacaoPago();
        movimentacaoPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
    }

    @Test
    public void testCamposObrigatorios(){
        menuPage.acessarCriarMovimentacao();
        movimentacaoPage.salvar();
        Assert.assertEquals("Data da Movimentação é obrigatório",
                movimentacaoPage.obterMsgErroDataMovimentacao());
        Assert.assertEquals("Data do pagamento é obrigatório", movimentacaoPage.obterMsgErroDataPagamento());
        Assert.assertEquals("Descrição é obrigatório", movimentacaoPage.obterMsgErroDescricao());
        Assert.assertEquals("Interessado é obrigatório", movimentacaoPage.obterMsgErroInteressado());
        Assert.assertEquals("Valor é obrigatório", movimentacaoPage.obterMsgErroValor());
        Assert.assertEquals("Valor deve ser um número", movimentacaoPage.obterValidacaoErroValor());
    }

    @Test
    public void testInserirMovimentacaoFutura(){
       menuPage.acessarCriarMovimentacao();
        movimentacaoPage.setTipoDaMovimentacao("Receita");
        movimentacaoPage.setDataDaMovimentacao("25/08/2022");
        movimentacaoPage.setDataDoPagamento("25/09/2022");
        movimentacaoPage.setDescricao("Testando movimentação");
        movimentacaoPage.setInteressado("Usuário de Teste");
        movimentacaoPage.setValor("1500");
        movimentacaoPage.setConta("Testando novamente");
        movimentacaoPage.setSituacaoPago();
        movimentacaoPage.salvar();
        Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual",
                movimentacaoPage.obterErroDataMovimentacaoMenorDataAtual());
    }
}
