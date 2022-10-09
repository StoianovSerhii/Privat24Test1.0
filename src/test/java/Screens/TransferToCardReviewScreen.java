package Screens;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferToCardReviewScreen {
    By descriptionComment = By.xpath("//div[@data-qa-node='comment']");
    By receiverName = By.xpath("//div[@data-qa-node='receiver-name']");
    By payerCard = By.xpath("//span[@data-qa-node='payer-card']");
    By receiverCard = By.xpath("//span[@data-qa-node='receiver-card']");
    By payerAmount = By.xpath("//div[@data-qa-node='payer-amount']");
    By toEnrollment = By.xpath("//div[@data-qa-node='receiver-amount']");
    By senderCommission = By.xpath("//div[@data-qa-node='payer-currency']");
    By recipientCommission = By.xpath("//div[@data-qa-node='receiver-currency']");
    By totalAmount = By.xpath("//div[@data-qa-node='total']");

    private static WebDriver driver;

    public TransferToCardReviewScreen (WebDriver driver){
        this.driver = driver;
    }

    public String getDescriptionComment(){
        return driver.findElement(descriptionComment).getText();
    }

    public String getReceiverName(){
        return driver.findElement(receiverName).getText();
    }

    public String getTestPayerCardValue(){
        return driver.findElement(payerCard).getText();
    }

    public String getTestReceiverCardValue(){
        return driver.findElement(receiverCard).getText();
    }

    public String getPayerAmount(){
        return driver.findElement(payerAmount).getText();
    }

    public String getReceiverAmount(){
        return driver.findElement(toEnrollment).getText();
    }

    public String getSenderCommission(){
        return driver.findElement(senderCommission).getText();
    }

    public String getRecipientCommission(){
        return driver.findElement(recipientCommission).getText();
    }

    public String getTotalDebit(){
        return driver.findElement(totalAmount).getText();
    }

    public void checkDescriptionComment(String descriptionComment){
        Assert.assertEquals(descriptionComment, getDescriptionComment());
    }

    public void checkReceiverName(String receiverName){
        Assert.assertEquals(receiverName, getReceiverName());
    }

    public void checkTestPayerCardValue(String testPayerCardValue){
        Assert.assertEquals(testPayerCardValue, getTestPayerCardValue());
    }

    public void checkTestReceiverCardValue(String testReceiverCardValue){
        Assert.assertEquals(testReceiverCardValue, getTestReceiverCardValue());
    }

    public void checkPayerAmount(String payerAmount){
        Assert.assertEquals(payerAmount, getPayerAmount());
    }

    public void checkReceiverAmount(String receiverAmount){
        Assert.assertEquals(receiverAmount, getReceiverAmount());
    }

    public void checkSenderCommission(String senderCommission){
        Assert.assertEquals(senderCommission, getSenderCommission());
    }

    public void checkRecipientCommission(String recipientCommission){
        Assert.assertEquals(recipientCommission, getRecipientCommission());
    }

    public void checkTotalDebit(String totalDebit){
        Assert.assertEquals(totalDebit, getTotalDebit());
    }

    public void checkTransferToCardReviewScreen(String descriptionComment, String receiverName, String testPayerCardValue, String testReceiverCardValue, String payerAmount, String receiverAmount, String senderCommission, String recipientCommission, String totalDebit){
        checkDescriptionComment(descriptionComment);
        checkReceiverName(receiverName);
        checkTestPayerCardValue(testPayerCardValue);
        checkTestReceiverCardValue(testReceiverCardValue);
        checkPayerAmount(payerAmount + " USD");
        checkReceiverAmount(receiverAmount + " USD");
        checkSenderCommission(senderCommission + " USD");
        checkRecipientCommission(recipientCommission + " USD");
        checkTotalDebit("Total to debit " + totalDebit + " USD") ;
    }
}
