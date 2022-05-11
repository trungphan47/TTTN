package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By lblNamePages = By.xpath("//h1[@align='center']");

    private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']//span");

    private final By tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']//span");

    private final By tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']//span");

    private final By tabFAQ = By.xpath("//span[contains(text(),'FAQ')]");////a[@href='/Page/FAQ.cshtml']//span

    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']//span");

    private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']//span");

    private final By tabTicketPrice = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']//span");

    private final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']//span");

    private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']//span");

    private final By lblWelcomeMessage = By.xpath("//div[@class='account']//strong");

    private final By lblMessageErrorCommon = By.xpath("//p[@class='message error']");

    private final By lblValidationError = By.xpath("//label[@class='validation-error']");

    //Elements
    public WebElement getLblNamePages() {
        return Constant.WEBDRIVER.findElement(lblNamePages);
    }

    public WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    public WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    public WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    public WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    public WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    public WebElement getTabFAQ() { return Constant.WEBDRIVER.findElement(tabFAQ);}

    public WebElement getTabContact() {return Constant.WEBDRIVER.findElement(tabContact);}

    public WebElement getTabTicketPrice() {
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    public WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    public WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    public WebElement getLblMessageErrorCommon() {
        return Constant.WEBDRIVER.findElement(lblMessageErrorCommon);
    }

    ;

    public WebElement getLblValidationError() {
        return Constant.WEBDRIVER.findElement(lblValidationError);
    }

    //Methods
    public String getNamePagesTitle() {
        return this.getLblNamePages().getText();
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void goToLoginPage() {
        this.getTabLogin().click();
    }

    public void goToRegisterPage() {
        this.getTabRegister().click();
    }

    public void goToChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void goToFAQPage() {this.getTabFAQ().click();}

    public void goToContactTab() {this.getTabContact().click();}

    public void goToTimeTablePage() {
        this.getTabTimeTable().click();
    }

    public void goToBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void goToTicketPricePage() {
        this.getTabTicketPrice().click();
    }

    public void goToMyTicketPage() {
        this.getTabMyTicket().click();
    }

    public String getTitleErrorMessageCommonInForms() {
        return this.getLblMessageErrorCommon().getText();
    }

    public String getTileValidationError() {
        return this.getLblValidationError().getText();
    }
}
