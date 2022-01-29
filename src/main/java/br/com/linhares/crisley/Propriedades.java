package br.com.linhares.crisley;

public class Propriedades {

    // TRUE = fecha o browser // FALSE = mantém o browser aberto
    public static boolean FECHAR_BROWSER = true;

    public static Browsers BROWSER = Browsers.CHROME;

    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.NUVEM;

    public enum Browsers{
        CHROME,
        FIREFOX
    }

    public enum TipoExecucao{
        LOCAL,
        GRID,
        NUVEM
    }
}
