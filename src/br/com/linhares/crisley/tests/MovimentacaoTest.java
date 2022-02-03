package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.MenuPage;
import br.com.linhares.crisley.pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.com.linhares.crisley.utils.DataUtils.obterDataComDiferencaDias;
import static br.com.linhares.crisley.utils.DataUtils.obterDataFormatada;

public class MovimentacaoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Ignore
    public void testInserirMovimentacaoPendente(){
        menuPage.acessarTelaCriarMovimentacao();
        movimentacaoPage.setTipoDaMovimentacao("Receita");
        movimentacaoPage.setDataDaMovimentacao("01/01/2022");
        movimentacaoPage.setDataDoPagamento("05/01/2022");
        movimentacaoPage.setDescricao("Testando movimentação");
        movimentacaoPage.setInteressado("Interessado Qualquer");
        movimentacaoPage.setValor("1500");
        movimentacaoPage.setConta("Conta para movimentacoes");
        movimentacaoPage.setSituacaoPendente();
        movimentacaoPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
    }

    @Test
    public void testInserirMovimentacaoPago(){
        menuPage.acessarTelaCriarMovimentacao();
        movimentacaoPage.setTipoDaMovimentacao("Receita");
        movimentacaoPage.setDataDaMovimentacao("01/01/2022");
        movimentacaoPage.setDataDoPagamento("05/01/2022");
        movimentacaoPage.setDescricao("Testando a movimentação");
        movimentacaoPage.setInteressado("Interessado Qualquer");
        movimentacaoPage.setValor("1500");
        movimentacaoPage.setConta("Conta para movimentacoes");
        movimentacaoPage.setSituacaoPago();
        movimentacaoPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
    }

    @Test
    public void testCamposObrigatorios(){
        menuPage.acessarTelaCriarMovimentacao();
        movimentacaoPage.salvar();
        List<String> erros = movimentacaoPage.obterErros();
        Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório", "Interessado é obrigatório",
                "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void testInserirMovimentacaoFutura(){
        menuPage.acessarTelaCriarMovimentacao();

        Date dataFutura = obterDataComDiferencaDias(5);

        movimentacaoPage.setTipoDaMovimentacao("Receita");
        movimentacaoPage.setDataDaMovimentacao(obterDataFormatada(dataFutura));
        movimentacaoPage.setDataDoPagamento(obterDataFormatada(dataFutura));
        movimentacaoPage.setDescricao("Testando a movimentação");
        movimentacaoPage.setInteressado("Interessado Qualquer");
        movimentacaoPage.setValor("1500");
        movimentacaoPage.setConta("Conta para movimentacoes");
        movimentacaoPage.setSituacaoPago();
        movimentacaoPage.salvar();

        List<String> erros = movimentacaoPage.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }
}
