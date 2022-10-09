package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TransferToCardScreen {
    By payerCardField = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By payerName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By payerSurname = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By receiverCardField = By.xpath("//input[@data-qa-node='numberreceiver']");
    By receiverName = By.xpath("//input[@data-qa-node='firstNamereceiver']");
    By receiverSurname = By.xpath("//input[@data-qa-node='lastNamereceiver']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By currencyButton = By.xpath("//button[@data-qa-node='currency']");
    // to pay UAH:
    By selectCurrencyUAH = By.xpath("//button[@data-qa-node='currency-option' and @data-qa-value='UAH']");
    // to pay USD:
    By selectCurrencyUSD = By.xpath("//button[@data-qa-node='currency-option' and @data-qa-value='USD']");
    // to pay EUR:
    By selectCurrencyEUR = By.xpath("//button[@data-qa-node='currency-option' and @data-qa-value='EUR']");
    By addComment = By.xpath("//span[@data-qa-node='toggle-comment']");
    By commentText = By.xpath("//textarea[@data-qa-node='comment']");
    By submitButton = By.xpath("//button[@type='submit']");
    String transferToCardUrl = "https://next.privat24.ua/money-transfer/card";

    private static WebDriver driver;

    public TransferToCardScreen (WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.get(transferToCardUrl);
    }

    public void fillPayerCard(String payerCardField){
        driver.findElement(this.payerCardField).sendKeys(payerCardField);
    }

    public void fillExpiredDate(String expiredDate){
        driver.findElement(this.expiredDate).sendKeys(expiredDate);
    }

    public void fillCvv(String cvv){
        driver.findElement(this.cvv).sendKeys(cvv);
    }

    public void fillPayerName(String payerName){
        driver.findElement(this.payerName).sendKeys(payerName);
    }

    public void fillPayerSurname(String payerSurname){
        driver.findElement(this.payerSurname).sendKeys(payerSurname);
    }

    public void fillReceiverCard(String receiverCardField){
        driver.findElement(this.receiverCardField).sendKeys(receiverCardField);
    }

    public void fillReceiverName(String receiverName){
        driver.findElement(this.receiverName).sendKeys(receiverName);
    }

    public void fillReceiverSurname(String receiverSurname){
        driver.findElement(this.receiverSurname).sendKeys(receiverSurname);
    }

    public void fillAmount(String amount){
        driver.findElement(this.amount).click();
        while(!driver.findElement(this.amount).getAttribute("value").equals("")){
            driver.findElement(this.amount).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(this.amount).sendKeys(amount);
    }

    public void currencyButtonClick(){
        driver.findElement(currencyButton).click();
    }

    // to pay UAH:
    public void UahCurrencyButtonClick(){
        driver.findElement(selectCurrencyUAH).click();
    }

    // to pay USD:
    public void UsdCurrencyButtonClick(){
        driver.findElement(selectCurrencyUSD).click();
    }

    // to pay EUR:
    public void EurCurrencyButtonClick(){
        driver.findElement(selectCurrencyEUR).click();
    }

    public void AddCommentButtonClick(){
        driver.findElement(addComment).click();
    }

    public void fillComment(String commentText){
        driver.findElement(this.commentText).sendKeys(commentText);
    }

    public void submitButtonClick(){
        driver.findElement(submitButton).submit();
    }

    public void fillForm(String payerCard, String monthYear, String cvv, String payerName, String payerSurname, String receiverCard, String receiverName, String receiverSurname, String amount, String comment) throws InterruptedException {
        fillPayerCard(payerCard);
        fillExpiredDate(monthYear);
        fillCvv(cvv);
        fillPayerName(payerName);
        fillPayerSurname(payerSurname);
        fillReceiverCard(receiverCard);
        fillReceiverName(receiverName);
        fillReceiverSurname(receiverSurname);
        fillAmount(amount);
        currencyButtonClick();
        UsdCurrencyButtonClick();
        AddCommentButtonClick();
        fillComment(comment);
        submitButtonClick();
        Thread.sleep(3000); // Just for visualisation
    }
}
