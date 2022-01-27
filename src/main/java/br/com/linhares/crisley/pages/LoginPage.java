package br.com.linhares.crisley.pages;

import br.com.linhares.crisley.BasePage;
import org.openqa.selenium.By;

import static br.com.linhares.crisley.DriverFactory.getDriver;

public class LoginPage extends BasePage {

    public void acessarTelaInicial(){
        getDriver().get("https://seubarriga.wcaquino.me/login");
    }

    public void setEmail(String email){
        escrever("email", email);
    }

    public void setSenha(String senha){
        escrever("senha", senha);
    }

    public void entrar(){
        clicarBotao(By.xpath("//button[.='Entrar']"));
    }

    public void logar(String email, String senha){
        setEmail(email);
        setSenha(senha);
        entrar();
    }

}
