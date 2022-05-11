package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends GeneralPage {
    //Locators
    private final By txtUsername = By.id("username");

    private final By txtPassword = By.id("password");

    private final By btnLogin = By.xpath("//input[@title='Login']");

    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    private final By lblErrorUserNameBlanks = By.xpath("//li[@class='username']//label[2]");

    private final By lblErrorPasswordBlanks =  By.xpath("//label[contains(text(),'You must specify a password.')]");

    private final By lblErrorUsernameOrPasswordInvalid = By.xpath("//p[@class='message error LoginForm']");

    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    public WebElement getLblErrorPasswordBlanksMessage(){
        return Constant.WEBDRIVER.findElement(lblErrorPasswordBlanks);
    }

    public WebElement getLblErrorUserNameBlanksMessage() {
        return Constant.WEBDRIVER.findElement(lblErrorUserNameBlanks);
    }

    public WebElement getLblErrorUsernameOrPasswordMessage() {
        return Constant.WEBDRIVER.findElement(lblErrorUsernameOrPasswordInvalid);
    }

    //Methods
    public void login(String username, String password){
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        Utilities.scrollPage(getBtnLogin());
        this.getBtnLogin().click();
    }

    public String getErrorLoginInvalidUsernameOrPassword() {
        return this.getLblLoginErrorMsg().getText();
    }

    public void multipleLoginWithInvalidPassword(int times){
        LoginPage loginPage = new LoginPage();
        for (int index = 0; index <= times; index++) {
            getTxtUsername().clear();
            loginPage.login(Constant.USERNAME, "123456778898");
        }
    }

    public String getErrorUseNameBlanksMessage() {
        return this.getLblErrorUserNameBlanksMessage().getText();
    }

    public String getErrorPasswordBlanksMessage() {return this.getLblErrorPasswordBlanksMessage().getText(); }

    public String getErrorPasswordMessage() {
        return this.getLblErrorUsernameOrPasswordMessage().getText();
    }

}
