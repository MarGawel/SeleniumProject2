package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='price']/strong")
    private WebElement priceElement;

    @FindBy(xpath = "//div[@id='order-details']//li[1]")
    private WebElement orderReferenceElement;

    public OrderConfirmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPriceElement() {
        String price = priceElement.getText();
        return price;
    }

    public String getOrderReferenceElement() {
        String reference = orderReferenceElement.getText().substring(17, 26);
        return reference;
    }
}
