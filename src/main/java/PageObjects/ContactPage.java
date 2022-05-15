package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {
    //Locator
    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");

    private static final By contactInfo=By.xpath("//div[@class='contact']//p");

    //Element
    public WebElement getTabContact () {return Constant.WEBDRIVER.findElement(tabContact);}

    public WebElement getcontactInfo(){ return Constant.WEBDRIVER.findElement(contactInfo);}

    //Method
    public void gotoContactPage(){
        this.getTabContact().click();
    }

    public String contactInfo() { return getcontactInfo().getText();}
}
