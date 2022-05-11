package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutPage extends GeneralPage {

    private final By tabLogout = By.xpath("//a[@href='/Account/Logout']//span");

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    public void goToLogOutPage() {
        this.getTabLogout().click();
    }
}
