package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    //Locators
    private final By ddlDepartDate = By.xpath("//select[@name='Date']");

    private final By ddlDepartStation = By.xpath("//select[@name='DepartStation']");

    private final By ddlArriveStation = By.xpath("//select[@name='ArriveStation']");

    private final By ddlSeatType = By.xpath("//select[@name='SeatType']");

    private final By ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");

    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");

    private final By messageNoMoreBookTicket = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[5]/label[2]");

    String dgdBookTicketSuccessfully = "//tbody/tr[@class='OddRow']/td[count(//th[text()='Depart Station']/preceding-sibling::th)+'%s']";

    //Elements
    public Select getDdlDepartDate() {
        Select departDate = new Select(Utilities.waitForElement(10, ddlDepartDate));
        return departDate;
    }

    public Select getDdlDepartStation() {
        Select departStation = new Select(Utilities.waitForElement(10, ddlDepartStation));
        return departStation;
    }

    public Select getDdlArriveStation() {
        Select arriveStation = new Select(Utilities.waitForElement(10, ddlArriveStation));
        return arriveStation;
    }

    public Select getDdlSeatType() {
        Select seatType = new Select(Utilities.waitForElement(10, ddlSeatType));
        return seatType;
    }

    public Select getDdlTicketAmount() {
        Select ticketAmount = new Select(Utilities.waitForElement(10, ddlTicketAmount));
        return ticketAmount;
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    public WebElement getMessageNoMoreBookTicket() {
        return Constant.WEBDRIVER.findElement(messageNoMoreBookTicket);
    }

    public WebElement getDgdBookTicketSuccessfully(String no) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dgdBookTicketSuccessfully, no)));
    }

    //Methods
    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) throws InterruptedException {
        getDdlDepartDate().selectByVisibleText(departDate);
        getDdlDepartStation().selectByVisibleText(departStation);
        Thread.sleep(1000);
        getDdlArriveStation().selectByVisibleText(arriveStation);
        getDdlSeatType().selectByVisibleText(seatType);
        getDdlTicketAmount().selectByVisibleText(ticketAmount);
        getBtnBookTicket().submit();
    }

    public String getNoMoreBookTicketMessage() {
        return this.getMessageNoMoreBookTicket().getText();
    }

    public String getDataBookedTicketSuccessfully(String no) {
        return this.getDgdBookTicketSuccessfully(no).getText();
    }

    public void bookTicketMultipleTimes(String departDate, String departStation, String arriveStation,
                                        String seatType, String ticketAmount, int times) {
        for (int i = 0; i < times; i++) {
            HomePage homePage = new HomePage();
            homePage.goToBookTicketPage();

            getDdlDepartDate().selectByVisibleText(departDate);
            getDdlDepartStation().selectByVisibleText(departStation);
            getDdlArriveStation();
            getDdlArriveStation().selectByVisibleText(arriveStation);
            getDdlSeatType().selectByVisibleText(seatType);
            getDdlTicketAmount().selectByVisibleText(ticketAmount);
            getBtnBookTicket().submit();
        }
    }

    public void clickBtnBookTicket() {
        Utilities.scrollPage(getBtnBookTicket());
        this.getBtnBookTicket().submit();
    }

    public void clickBtnBookTicketMutilpleTime(int time) {
        for (int i = 0; i < time; i++) {
            HomePage homePage = new HomePage();
            homePage.goToBookTicketPage();
            Utilities.scrollPage(getBtnBookTicket());
            getBtnBookTicket().submit();
        }
    }

    public void clickBtnBookTicketMutilpleTime(int time, String departDate) {
        for (int i = 0; i < time; i++) {
            HomePage homePage = new HomePage();
            homePage.goToBookTicketPage();
            getDdlDepartDate().selectByVisibleText(departDate);
            Utilities.scrollPage(getBtnBookTicket());
            getBtnBookTicket().submit();

        }
    }
}
