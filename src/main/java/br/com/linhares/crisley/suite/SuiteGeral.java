package br.com.linhares.crisley.suite;

import br.com.linhares.crisley.tests.*;
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
}
