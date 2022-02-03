package br.com.linhares.crisley;

import static br.com.linhares.crisley.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    /****************** Alertas *****************/

    public void alertaEscrever(String texto){
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(texto);
        alert.accept();
    }

    public String alertaObterTexto(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();

        return valor;
    }

    public String alertaObterTextoEAceita(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
    }

    public String alertaObterTextoENega(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;
    }

    /********************** Botões *********************/

    public void clicarBotao(String id_campo){
        getDriver().findElement(By.id(id_campo));
    }

    public void clicarBotao(By by){
        getDriver().findElement(by).click();
    }

    public void clicarBotaoPorTexto(String texto){
        clicarBotao(By.xpath("//button[.='"+texto+"']"));
    }

    public void clicarBotaoPorValue(String texto){
        clicarBotao(By.xpath("//input[@value='"+texto+"']"));
    }

    public void fechar(){
        getDriver().close();
    }

    /********************** Checkbox *******************/

    public boolean verificarCheckBoxSelecionado(By by){
        if(getDriver().findElement(by).isSelected()){
            return true;
        }
        return false;
    }

    /******************** Combos *********************/

    public void deselecionarCombo(String id_campo, String opcao){
        WebElement element = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        combo.deselectByVisibleText(opcao);
    }

    public int obterQuantidadeOpcoesCombo(String id_campo){
        WebElement element = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public String obterValorCombo(String id_campo){
        WebElement element = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obterValoresCombo(String id_campo){
        WebElement element = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for(WebElement opcao:allSelectedOptions){
            valores.add(opcao.getText());
        }
        return valores;
    }

    public void selecionarCombo(String id_campo, String opcao){
        WebElement comboBox = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(comboBox);
        combo.selectByVisibleText(opcao);
    }

    public void selecionarComboPrime(By by){
        getDriver().findElement(by).click();
    }

    public void selecionarCombo(By by, String opcao){
        WebElement comboBox = getDriver().findElement(by);
        Select combo = new Select(comboBox);
        combo.selectByVisibleText(opcao);
    }

    public boolean verificarOpcaoCombo(String id_campo, String opcao){
        WebElement element = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();

        for(WebElement option: options){
            if(option.getText().equals(opcao)){
                return true;
            }
        }
        return false;
    }

    /******************** Frames *********************/

    public void entrarFrame(String id_campo){
        getDriver().switchTo().frame(id_campo);
    }

    public void sairFrame(){
        getDriver().switchTo().defaultContent();
    }

    /********************** Janelas *********************/

    public void trocarJanela(String nome){
        getDriver().switchTo().window(nome);
    }

    /****************** JavaScript ********************/

    public Object executarJS(String comando, Object... parametro){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(comando,parametro);
    }

    /********************* Links ***********************/

    public void clicarLink(String link){
        getDriver().findElement(By.linkText(link)).click();
    }

    /********************** Radios **********************/

    public boolean checarSeRadioEstaSelecionado(String id_campo){
        return getDriver().findElement(By.id(id_campo)).isSelected();
    }

    public void clicarRadio(String id_campo){
        clicarRadio(By.id(id_campo));
    }

    public void clicarRadio(By by){
        getDriver().findElement(by).click();
    }

    /***************** Tabelas ************************/

    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botão
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botão da celula encontrada
        WebElement celula = tabela.findElement(By.xpath("//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        return celula;
    }

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
        WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
        celula.findElement(By.xpath(".//input")).click();
    }


    protected int obterIndiceColuna(String coluna, WebElement tabela){
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for(int i = 0; i < colunas.size(); i++){
            if(colunas.get(i).getText().equals(coluna)){
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna){
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinha = -1;
        for(int i = 0; i < linhas.size(); i++){
            if(linhas.get(i).getText().equals(valor)){
                idLinha = i+1;
                break;
            }
        }
        return idLinha;
    }

    /******************** Text Fields *****************/

    public void escrever(By by, String texto){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void escrever(String id_campo, String texto){
        getDriver().findElement(By.id(id_campo)).clear();
        getDriver().findElement(By.id(id_campo)).sendKeys(texto);
    }

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id_campo){
        return obterTexto(By.id(id_campo));
    }

    public String obterValorCampo(String id_campo){
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    public String obterValueElemento(String id_campo){
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }
}
