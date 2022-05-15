package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //Locators
    String lblDataRows = "//*[@id=\"content\"]/div/div/table/tbody/tr[%s]";

    String btnBookTicketInTicketPricePage = "//tbody/tr[%s]/td[3]/a[1]";

    String btnCheckPrice = "//li[contains(text(),'%s to %s')]//..//..//a";

    //Elements
    public WebElement getLblDataRows(String line) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lblDataRows, line)));
    }

    public WebElement getbtnCheckPrice(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCheckPrice, departStation, arriveStation)));
    }

    public WebElement getBtnBookTicketInTicketPricePage(String line) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnBookTicketInTicketPricePage, line)));
    }

    //Methods
    public String getDataEachRowInTicketPriceTable(String line) {
        return this.getLblDataRows(line).getText();
    }

    public void clickBtnCheckPrice (String departStation, String arriveStation) {
        Utilities.scrollPage(getbtnCheckPrice(departStation, arriveStation));
        this.getbtnCheckPrice(departStation, arriveStation).click();
    }

    public void clickBtnBookTicketInTicketPricePage(String line) {
        Utilities.scrollPage(getBtnBookTicketInTicketPricePage(line));
        this.getBtnBookTicketInTicketPricePage(line).click();
    }
}
