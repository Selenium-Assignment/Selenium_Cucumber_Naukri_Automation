package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_page {

    WebDriver ldriver;
    public  Landing_page(WebDriver rdriver){
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }


    private  @FindBy(xpath = "//div[@class= 'nI-gNb-log-reg']//descendant::a[1]")
    WebElement LoginButton1;

    public void ClickOnloginButton(){
        LoginButton1.click();
    }

    private @FindBy(xpath="//div[@class= 'nI-gNb-log-reg']//descendant::a[2]")
    WebElement RegisterButton;
    public void clickOnRegisterButton() {
        RegisterButton.click();
    }

    private @FindBy(xpath = "//input[@placeholder= 'Enter your active Email ID / Username']")
    WebElement usernameinputField;

    public void username(String usernameValue){
        usernameinputField.click();
        usernameinputField.sendKeys(usernameValue);

    }

    private @FindBy(xpath = "//input[@placeholder= 'Enter your password']")
    WebElement passwordinputField;

    public void password(String passwordValue){

        passwordinputField.click();
        passwordinputField.sendKeys(passwordValue);
    }

    private @FindBy(xpath ="//button[@type='submit']")
    WebElement form_LoginButton;

    public void  AccountLoginButton(){
        form_LoginButton.click();
    }
    public WebElement otpbuttonelement(){
        return form_LoginButton;
    }

    private @FindBy(xpath = "//button[contains(@class,'otpButton')]")
    WebElement useOTPtoLoginButton;
    public void useOTPtoLogin(){
        useOTPtoLoginButton.click();
    }

    private @FindBy(xpath = "//input[(@type='tel')]")
    WebElement mobileNoinputField;

    public void MobileNumber(int Number){
        mobileNoinputField.sendKeys(Integer.toString(Number));

    }

    private @FindBy(xpath = "//button[contains(text(),'Get OTP')]")
    WebElement getOTPbutton;



}



