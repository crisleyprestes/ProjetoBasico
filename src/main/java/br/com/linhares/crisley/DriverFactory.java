package br.com.linhares.crisley;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    //private static WebDriver driver;
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    private DriverFactory(){
    }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;
        if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {
            switch (Propriedades.BROWSER) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
            }
            }
            if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.GRID) {
                DesiredCapabilities capabilities = null;
                switch (Propriedades.BROWSER) {
                    case FIREFOX:
                        DesiredCapabilities.firefox();
                        break;
                    case CHROME:
                        DesiredCapabilities.chrome();
                        break;
                }
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.0.184:4444/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    System.err.println("Falha na conexão com o GRID");
                    e.printStackTrace();
                }
            }
        if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.NUVEM) {
            DesiredCapabilities capabilities = null;
            switch (Propriedades.BROWSER) {
                case FIREFOX:
                    DesiredCapabilities.firefox();
                    break;
                case CHROME:
                    DesiredCapabilities.chrome();
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL
                        ("https://oauth-prestes40-e2658:f60b7c0c-233f-4fd5-b4ee-a5606b3bf777@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
                        capabilities);
            } catch (MalformedURLException e) {
                System.err.println("Falha na conexão com o GRID");
                e.printStackTrace();
            }
        }
            driver.manage().window().maximize();
            return driver;
        }

        public static void killDriver() {
            WebDriver driver = getDriver();
            if (driver != null) {
                driver.quit();
                driver = null;
            }
            if (threadDriver != null) {
                threadDriver.remove();
            }
        }
    }

