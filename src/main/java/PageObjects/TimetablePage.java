package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {

    //Locator
    String lnkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";

    //Element
    public WebElement getLinkCheckPrice(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkCheckPrice, depart, arrive)));
    }

    //Methods
    public void clickLinkCheckPrice(String depart, String arrive) {
        Utilities.scrollPage(getLinkCheckPrice(depart, arrive));
        this.getLinkCheckPrice(depart, arrive).click();
    }
}
