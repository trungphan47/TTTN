package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class MyTicketPage {

    //Locators
    private final By lblInformTheNumberOfTicketsBooked = By.xpath("//div[@id='content']//li[1]");

    private final By btnCancel = By.xpath("//tbody/tr[count(//th[text()='Operation']/preceding-sibling::th)-8]//input[@value='Cancel']");

    private final By lblTitle = By.xpath("//h1");

    private final By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");

    private final By lblNoResultFoundErrorMessage = By.xpath("//div[@align='center']//div[@class='error message']");

    private final By dropDownStatus = By.xpath("//select[@name='FilterStatus']");

    private final By txtDepartDate = By.name("FilterDpDate");

    private final By lblMalformedDateErrorMessage = By.xpath("//div[@class='Filter']//div[@class='error message']");

    private final By dropDownArriveStation = By.xpath("//select[@name='FilterArStation']");

    private final By dropDownDepartStation = By.xpath("//select[@name='FilterDpStation']");

    //Elements

    public WebElement getLblTitle() {
        return Constant.WEBDRIVER.findElement(lblTitle);
    }

    public WebElement getLblInformTheNumberOfTicketsBooked() {
        return Constant.WEBDRIVER.findElement(lblInformTheNumberOfTicketsBooked);
    }

    public WebElement getBtnCancel() {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }

    public WebElement getBtnApplyFilter() {
        return Constant.WEBDRIVER.findElement(btnApplyFilter);
    }

    public WebElement getLblNoResultFoundErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblNoResultFoundErrorMessage);
    }

    public Select getDropDownStatus() {
        Select status = new Select(Utilities.waitForElement(10, dropDownStatus));
        return status;
    }

    public WebElement getTxtDepartDate() {
        return Constant.WEBDRIVER.findElement(txtDepartDate);
    }

    public WebElement getLblMalformedDateErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblMalformedDateErrorMessage);
    }

    public Select getDropDownArriveStation() {
        Select arriveStation = new Select(Utilities.waitForElement(10, dropDownArriveStation));
        return arriveStation;
    }

    public Select getDropDownDepartStation() {
        Select departStation = new Select(Utilities.waitForElement(10, dropDownDepartStation));
        return departStation;
    }

    //Methods
    public String getLabelTitle() {
        return getLblTitle().getText();
    }

    public String getLblInformTheNumberOfTicketsBookedMsg() {
        return this.getLblInformTheNumberOfTicketsBooked().getText();
    }

    public void cancelTicket() {
        Utilities.scrollPage(getBtnCancel());
        this.getBtnCancel().click();
    }

    public boolean isBtnCancelDisappear() {
        try {
            getBtnCancel();
            return false;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean isBtnApplyFilterDisappear() {
        try {
            getBtnApplyFilter();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLblNoResultFoundErrorMessage() {
        try {
            getLblNoResultFoundErrorMessage();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLblMalformedDateErrorMessage() {
        try {
            getLblMalformedDateErrorMessage();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void selectDropDownStatus(String option) {
        getDropDownStatus().selectByVisibleText(option);
    }

    public void selectDropDownArriveStation(String option) {
        getDropDownArriveStation().selectByVisibleText(option);
    }

    public void selectDropDownDepartStation(String option) {
        getDropDownDepartStation().selectByVisibleText(option);
    }

    public void clickApplyFilterButton() {
        getBtnApplyFilter().click();
    }


    public void enterDepartDate(String departDate) {
        getTxtDepartDate().sendKeys(departDate);
    }

    public void acceptAlert() {
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
    }

}
