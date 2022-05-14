package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    //Locators
    private final By txtCurrentPassword = By.id("currentPassword");

    private final By txtNewPassword = By.id("newPassword");

    private final By txtConfirmPassword = By.id("confirmPassword");

    private final By btnChangePassword = By.xpath("//input[@title='Change password']");

    private final By getChangePasswordMess = By.xpath("//*[@id=\"ChangePW\"]/fieldset/p[1]");

    private final By lblInvalidCurrentPass = By.xpath("//*[@id=\"ChangePW\"]/fieldset/ol/li[1]/label[2]");

    private final By lblInvalidNewPass = By.xpath("//label[contains(text(),'Invalid new password.')]");

    private final By lblInvalidConfirmPass = By.xpath("//*[@id=\"ChangePW\"]/fieldset/ol/li[3]/label[2]");


    //Elements
    public WebElement getTxtCurrentPassword() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    public WebElement getTxtNewPassword() {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    public WebElement getChangePasswordMess() {return Constant.WEBDRIVER.findElement(getChangePasswordMess);}

    public WebElement getLblInvalidCurrentPass() {return Constant.WEBDRIVER.findElement(lblInvalidCurrentPass);}

    public WebElement getLblInvalidNewPass() {return Constant.WEBDRIVER.findElement(lblInvalidNewPass);}

    public WebElement getlblInvalidConfirmPass() {return Constant.WEBDRIVER.findElement(lblInvalidConfirmPass);}


    //Methods

    public String getInvalidCurrentPassMess() {return this.getLblInvalidCurrentPass().getText(); }

    public String getInvalidNewPassMess() {return this.getLblInvalidNewPass().getText();}

    public String getInvalidConfirmPass() {return this.getlblInvalidConfirmPass().getText();}

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().submit();
    }

    public String changePasswordMess() {return this.getChangePasswordMess().getText();}
}
