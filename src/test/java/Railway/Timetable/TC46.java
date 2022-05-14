package Railway.Timetable;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.*;
import Railway.TestBase;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC46 extends TestBase {
    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(description = "Verify that \"check price\" link can navigate to Ticket Price tab ", dataProvider = "data-provider")

    public void TC46(String departStation, String arriveStation, String seatType, String ticketPrice) {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Timetable\" tab");
        homePage.goToTimeTablePage();

        System.out.println("Step 3:  Click on any \"Check Price\" button ");
        String expectedTableTitle = "Ticket price from " + departStation + " to " + arriveStation;

        timetablePage.clickLinkCheckPrice(departStation, arriveStation);
        String actualTableTitle = ticketPricePage.getDataEachRowInTicketPriceTable("1");
        Assert.assertEquals(actualTableTitle, expectedTableTitle, "Title Book Ticket notification table displays incorrectly");

        String actualTitleTicketPricePage = homePage.getNamePagesTitle();
        String expectedTitleTicketPricePage = "Ticket Price";
        Assert.assertEquals(actualTitleTicketPricePage, expectedTitleTicketPricePage, "Title Book Ticket page displays incorrectly");

        String actualSeatTypes = ticketPricePage.getDataEachRowInTicketPriceTable("2");
        String expectedSeatTypes = String.valueOf(seatType);
        Assert.assertEquals(actualSeatTypes, expectedSeatTypes, "Seat type displays incorrectly");

        String actualPriceTicket = ticketPricePage.getDataEachRowInTicketPriceTable("3");
        String expectedPriceSeat = String.valueOf(ticketPrice);
        Assert.assertEquals(actualPriceTicket, expectedPriceSeat, "Ticket price displays incorrectly");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC46 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC46.get("departStation").getAsString();
        String arriveStation = dataTC46.get("arriveStation").getAsString();
        String seatType = dataTC46.get("seatType").getAsString();
        String ticketPrice = dataTC46.get("ticketPrice").getAsString();

        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketPrice}
        };
        return object;
    }
}
