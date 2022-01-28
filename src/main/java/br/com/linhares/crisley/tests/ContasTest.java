package br.com.linhares.crisley.tests;

import br.com.linhares.crisley.BaseTest;
import br.com.linhares.crisley.pages.ContasPage;
import br.com.linhares.crisley.pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContasTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void test1_InserirConta(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Usuário de Teste");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test2_AlterarConta(){
        menuPage.acessarTelaListarContas();
        contasPage.clicarAlterarConta("Usuário de Teste");
        contasPage.setNome("Novo Usuário de Teste");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test3_InserirContaComMesmoNome(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Novo Usuário de Teste");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }
}