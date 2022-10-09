import Screens.TransferToCardReviewScreen;
import Screens.TransferToCardScreen;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TransferToCardTests {
    String testPayerCard = "4111 1111 1111 1111";
    String monthYear = "1224";
    String cvvNumber = "123";
    String tesPayerName = "SERHII";
    String testPayerSurname = "STOIANOV";
    String testReceiverCard = "4444 3333 2222 1111";
    String testReceiverName = "DMYTRO";
    String testReceiverSurname = "TSYBINOGIN";
    String minAmount = "10";
    String maxAmount = "820";
    String comment = "Bribe";
    String minCommission = "3.15";
    String maxCommission = "19.35";
    String recipientCommission = "0";
    String minTotalDebit = "13.15";
    String maxTotalDebit = "839.35";
    String fullReceiverName = testReceiverName + " " + testReceiverSurname;
    private WebDriver driver;
    private TransferToCardScreen transferToCardScreen;
    private TransferToCardReviewScreen transferToCardReviewScreen;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        transferToCardScreen = new TransferToCardScreen(driver);
        transferToCardReviewScreen = new TransferToCardReviewScreen(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        transferToCardScreen.navigate();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkTransferToCardMinSum() throws InterruptedException {
        transferToCardScreen.fillForm(testPayerCard, monthYear, cvvNumber, tesPayerName, testPayerSurname, testReceiverCard, testReceiverName, testReceiverSurname, minAmount, comment);
        transferToCardReviewScreen.checkTransferToCardReviewScreen(comment, fullReceiverName, testPayerCard, testReceiverCard, minAmount, minAmount, minCommission, recipientCommission, minTotalDebit);
    }

    @Test
    public void checkTransferToCardMaxSum() throws InterruptedException {
        transferToCardScreen.fillForm(testPayerCard, monthYear, cvvNumber, tesPayerName, testPayerSurname, testReceiverCard, testReceiverName, testReceiverSurname, maxAmount, comment);
        transferToCardReviewScreen.checkTransferToCardReviewScreen(comment, fullReceiverName, testPayerCard, testReceiverCard, maxAmount, maxAmount, maxCommission, recipientCommission, maxTotalDebit);
    }
}
