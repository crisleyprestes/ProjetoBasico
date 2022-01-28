package br.com.linhares.crisley;

import br.com.linhares.crisley.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.com.linhares.crisley.DriverFactory.getDriver;
import static br.com.linhares.crisley.DriverFactory.killDriver;

public class BaseTest {

    @Rule
    public TestName testname = new TestName();

    @After
    public void finaliza() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo,new File("target/screenshot/" + testname.getMethodName() + ".jpg"));

        if(Propriedades.FECHAR_BROWSER) {
            killDriver();
        }
    }
}
