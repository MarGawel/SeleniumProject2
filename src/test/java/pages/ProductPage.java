package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    private WebDriver driver;

    @FindBy(id = "group_1")
    private WebElement sizeElement;

    @FindBy(name = "qty")
    private WebElement quantityElement;

    @FindBy(xpath = "//div[@class='add']/button")
    private WebElement addButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckoutElement;

    @FindBy(className = "regular-price")
    private WebElement regularPriceElement;

    @FindBy(xpath = "//*[@class='current-price']/*[@itemprop='price']")
    private WebElement currentPriceElement;



    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSize (String size){
        Select selectSize = new Select(sizeElement);
        selectSize.selectByVisibleText(size);
    }

    public void setQuantity(String quantity){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quantityElement.clear();
        quantityElement.sendKeys(quantity);

    }

    public void clickAddButton(){
        addButton.click();
    }

    public void setProceedToCheckout(){
        proceedToCheckoutElement.click();
    }

    public void checkRabat(){
        double regularPrice = Double.parseDouble(regularPriceElement.getText().substring(1, 6));
        double currentPrice = Double.parseDouble(currentPriceElement.getText().substring(1, 6));
        double calculatedPrice = regularPrice * 0.8;

        Assert.assertEquals(calculatedPrice, currentPrice, .2);

    }

}
