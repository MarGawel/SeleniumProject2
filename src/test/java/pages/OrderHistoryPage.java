package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    private WebDriver driver;
    private static String statusExpected = "Awaiting check payment";

    @FindBy(xpath = "//section[@id='content']//tbody/tr[1]/th")
    private WebElement orderReference;

    @FindBy(xpath = "//section[@id='content']//tbody/tr[1]/td[2]")
    private WebElement orderPrice;

    @FindBy(xpath = "//section[@id='content']//tbody/tr[1]//span")
    private WebElement orderStatus;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkOrderHistory(String reference, String price){

        Assert.assertEquals(reference, orderReference.getText());
        Assert.assertEquals(price, orderPrice.getText());
        Assert.assertEquals(statusExpected, orderStatus.getText());
    }
}
