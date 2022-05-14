package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    //Locators
    private final By lblForgotPassword = By.xpath("//legend[contains(text(),'Password Reset Instructions Form')]");

    private final By emailAddressTxt = By.xpath("//input[@id='email']");

    private final By sendInstructionsBtn = By.xpath("//*[@id=\"content\"]/form/fieldset/p[2]/input");

    private final By lblEmailDoesnotExit = By.xpath("//*[@id=\"content\"]/form/fieldset/p[2]");

    private final By lblInvalidEmailReset = By.xpath("//*[@id=\"content\"]/form/fieldset/ol/li/label[2]");

    //Elements
    public WebElement getLblForgotPassword() {return Constant.WEBDRIVER.findElement(lblForgotPassword);}

    public WebElement getEmailAddressTxt() {return Constant.WEBDRIVER.findElement(emailAddressTxt);}

    public WebElement getSendInstructionsBtn() {return Constant.WEBDRIVER.findElement(sendInstructionsBtn);}

    public WebElement getLblEmailDoesnotExit() {return Constant.WEBDRIVER.findElement(lblEmailDoesnotExit);}

    public WebElement getInvalidEmailResetLbl() {return Constant.WEBDRIVER.findElement(lblInvalidEmailReset);}

    //Methods
    public String getForgotPasswordTitle() {return this.getLblForgotPassword().getText();}

    public String getEmailDoesnotExit() {return this.getLblEmailDoesnotExit().getText();}

    public String getInvalidEmailResetMess() {return this.getInvalidEmailResetLbl().getText();}

    public void forgotPassword (String email) {
        this.getEmailAddressTxt().sendKeys(email);
        this.getSendInstructionsBtn().submit();
    }
}
