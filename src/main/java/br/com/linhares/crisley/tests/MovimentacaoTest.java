package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.MenuPage;
import br.com.linhares.crisley.pages.MovimentacaoPage;
import br.com.linhares.crisley.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.com.linhares.crisley.utils.DataUtils.*;

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
        List<String> erros = movimentacaoPage.obterErros();
        Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório", "Interessado é obrigatório",
                "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void testInserirMovimentacaoFutura(){
        menuPage.acessarCriarMovimentacao();

        Date dataFutura = obterDataComDiferencaDias(5);

        movimentacaoPage.setTipoDaMovimentacao("Receita");
        movimentacaoPage.setDataDaMovimentacao(obterDataFormatada(dataFutura));
        movimentacaoPage.setDataDoPagamento(obterDataFormatada(dataFutura));
        movimentacaoPage.setDescricao("Testando movimentação");
        movimentacaoPage.setInteressado("Usuário de Teste");
        movimentacaoPage.setValor("1500");
        movimentacaoPage.setConta("Testando novamente");
        movimentacaoPage.setSituacaoPago();
        movimentacaoPage.salvar();

        List<String> erros = movimentacaoPage.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }
}
