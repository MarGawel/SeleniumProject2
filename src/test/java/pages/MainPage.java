package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(name = "s")
    private WebElement search;

    @FindBy(xpath = "//div[@class='products row']/article//a")
    private WebElement product;

    @FindBy(id = "history-link")
    private WebElement orderHistoryElement;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSearch(String searchItem){
        search.sendKeys(searchItem);
        search.sendKeys(Keys.ENTER);
    }

    public void getProduct(){
        product.click();
    }

    public void setOrderHistoryElement(){
        orderHistoryElement.click();
    }
}
