package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //Locators
    String lblDataRows = "//*[@id=\"content\"]/div/div/table/tbody/tr[%s]";

    String btnCheckPrice = "//tbody/tr[%s]/td[2]/a[1]";

    String btnBookTicketInTicketPricePage = "//tbody/tr[%s]/td[3]/a[1]";

    //Elements
    public WebElement getLblDataRows(String line) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lblDataRows, line)));
    }

    public WebElement getbtnCheckPrice(String line) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCheckPrice, line)));
    }

    public WebElement getBtnBookTicketInTicketPricePage(String line) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnBookTicketInTicketPricePage, line)));
    }

    //Methods
    public String getDataEachRowInTicketPriceTable(String line) {
        return this.getLblDataRows(line).getText();
    }

    public void clickBtnCheckPrice(String line) {
        Utilities.scrollPage(getbtnCheckPrice(line));
        this.getbtnCheckPrice(line).click();
    }

    public void clickBtnBookTicketInTicketPricePage(String line) {
        Utilities.scrollPage(getBtnBookTicketInTicketPricePage(line));
        this.getBtnBookTicketInTicketPricePage(line).click();
    }
}
