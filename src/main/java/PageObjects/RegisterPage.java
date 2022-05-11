package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    //Locators
    private final By txtEmail = By.id("email");

    private final By txtPassword = By.id("password");

    private final By txtConfirmPassword = By.id("confirmPassword");

    private final By txtPID = By.id("pid");

    private final By btnRegister = By.xpath("//input[@title='Register']");

    private final By lblErrorExitEmail = By.xpath("//p[@class='message error']");

    private final By lblErrorDoNoMatchPassword = By.xpath("//label[contains(text(),'The two passwords do not match')]");

    private final By lblErrorInvalidEmailLength = By.xpath("//li[@class='email']//label[2]");

    private final By lblErrorInvalidPasswordLength = By.xpath("//li[@class='password']//label[2]");

    private final By lblErrorInvalidConfirmPasswordLength = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/ol/li[3]/label[2]");

    private final By lblErrorInvalidPIDLength = By.xpath("//li[@class='pid-number']//label[2]");

    private final By lblErrorRegisterForm = By.xpath("//p[@class='message error']");

    private final By lblRegisterSuccess = By.xpath("//div[@id='content']//p");

    //Elements
    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    public WebElement getLblErrorExitEmail() {
        return Constant.WEBDRIVER.findElement(lblErrorExitEmail);
    }

    public WebElement getLblErorDoNotMatchPass() {return Constant.WEBDRIVER.findElement(lblErrorDoNoMatchPassword); }

    public WebElement getLblErrorInvalidEmailLength(){
        return Constant.WEBDRIVER.findElement(lblErrorInvalidEmailLength);
    }

    public WebElement getLblErrorInvalidPasswordLength() {
        return Constant.WEBDRIVER.findElement(lblErrorInvalidPasswordLength);
    }

    public WebElement getLblErrorInvalidConfirmPassLength(){
        return Constant.WEBDRIVER.findElement(lblErrorInvalidConfirmPasswordLength);
    }

    public WebElement getLblErrorInvalidPIDLength() {
        return Constant.WEBDRIVER.findElement(lblErrorInvalidPIDLength);
    }

    public WebElement getLblErrorRegisterForm() {
        return Constant.WEBDRIVER.findElement(lblErrorRegisterForm);
    }

    public WebElement getLblRegisterSuccess() {
        return Constant.WEBDRIVER.findElement(lblRegisterSuccess);
    }

    //Method
    public void register(String email, String password, String confirmPassword, String pid) {
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPID().sendKeys(pid);
        this.getBtnRegister().submit();
    }

    public String getErrorEmailMessage() {
        return this.getLblErrorExitEmail().getText();
    }

    public String getErrorDoNotMatchPass() {return this.getLblErorDoNotMatchPass().getText(); }

    public String getErrorInvalidEmailLengthMessage() { return this.getLblErrorInvalidEmailLength().getText();}

    public String getErrorInvalidPasswordLengthMessage() {
        return this.getLblErrorInvalidPasswordLength().getText();
    }

    public String getErrorInvalidConfirmPass(){
        return this.getLblErrorInvalidConfirmPassLength().getText();
    }
    public String getErrorInvalidPidLengthMessage() {
        return this.getLblErrorInvalidPIDLength().getText();
    }

    public String getErrorRegisterAccountFail() {
        return this.getLblErrorRegisterForm().getText();
    }

    public String getRegisterSuccessMessage() {
        return this.getLblRegisterSuccess().getText();
    }
}
