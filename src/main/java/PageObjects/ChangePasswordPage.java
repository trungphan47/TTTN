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

    //Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().submit();
    }
}
