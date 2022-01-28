package br.com.linhares.crisley;

public class Propriedades {

    // TRUE = fecha o browser // FALSE = mantém o browser aberto
    public static boolean FECHAR_BROWSER = false;

    public static Browsers browser = Browsers.CHROME;

    public static String NOME_CONTA_ALTERADA = "Novo Usuário de Teste" + System.nanoTime();

    public enum Browsers{
        CHROME,
        FIREFOX
    }
}
