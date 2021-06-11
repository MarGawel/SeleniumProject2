package testing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import pl.gawel.ScreenShot;

import java.util.concurrent.TimeUnit;

public class BuyingTest {
    private static WebDriver driver;
    private String product = "Hummingbird Printed Sweater";
    private String size = "M";
    private String quantity = "5";


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void buyingTest(){
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signIn("dznjmhufehcahoslbj@niwghx.com", "qwe123");
        Assert.assertEquals("Marcin Marcin", signInPage.getNameUser());

        MainPage mainPage = new MainPage(driver);
        mainPage.setSearch(product);
        mainPage.getProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.setSize(size);
        productPage.setQuantity(quantity);

        productPage.checkRabat();

        productPage.clickAddButton();

        productPage.setProceedToCheckout();
        productPage.setProceedToCheckout();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.setConfirmAddresses();
        orderPage.setShoppingMethod();
        orderPage.setConfirmShoppingMethod();
        orderPage.setPaymentOption();
        orderPage.setApproveTerms();
        orderPage.setOrder();

        OrderConfirmPage orderConfirmPage = new OrderConfirmPage(driver);
        String price = orderConfirmPage.getPriceElement();
        String reference = orderConfirmPage.getOrderReferenceElement();

        ScreenShot shot = new ScreenShot();
        shot.makeScreenShot();

        orderPage.setUserAccount();
        mainPage.setOrderHistoryElement();

        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.checkOrderHistory(reference, price);

    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}
