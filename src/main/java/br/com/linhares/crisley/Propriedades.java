package br.com.linhares.crisley;

public class Propriedades {

    // TRUE = fecha o browser // FALSE = mantém o browser aberto
    public static boolean FECHAR_BROWSER = true;

    public static Browsers browsers = Browsers.CHROME;

    public enum Browsers{
        CHROME,
        FIREFOX
    }
}
