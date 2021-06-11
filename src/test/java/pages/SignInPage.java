package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    @FindBy(name = "email")
    private WebElement emailElement;

    @FindBy(name = "password")
    private WebElement passwordElement;

    @FindBy(id = "submit-login")
    private WebElement submit;

    @FindBy(xpath = "//div[@class='user-info']//span")
    private WebElement nameUser;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn(String email, String password){
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        submit.click();
    }

    public String getNameUser(){
        return nameUser.getText();
    }






}