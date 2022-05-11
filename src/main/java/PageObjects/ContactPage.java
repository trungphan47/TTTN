package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {
    //Locator
    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");


    private final By seatCode = By.xpath("/html/body/div[1]/div[2]/div/p[1]");

    private final By phone = By.xpath("//*[@id=\"content\"]/div/p[2]");

    private final By skype = By.xpath("//*[@id=\"content\"]/div/p[3]");

    private final By email = By.cssSelector("#content > div > p > a");

    //Element
    public WebElement getTabContact () {return Constant.WEBDRIVER.findElement(tabContact);}

    public WebElement getSeatCodeText() {return Constant.WEBDRIVER.findElement(seatCode);}

    public WebElement getPhoneText() {return Constant.WEBDRIVER.findElement(phone);}

    public WebElement getSkypeText() {return Constant.WEBDRIVER.findElement(skype);}

    public WebElement getEmailText() {return Constant.WEBDRIVER.findElement(email);}

    //Method
    public void gotoContactPage(){
        this.getTabContact().click();
    }

    public String getSeatCode() { return this.getSeatCodeText().getText();}

    public String getPhone() {return this.getPhoneText().getText();}

    public String getSkype() {return this.getSkypeText().getText();}

    public String getEmail() {return this.getEmailText().getText();}

}
