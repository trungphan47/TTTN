package Railway;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC15 extends TestBase {
    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    LoginPage loginPage = new LoginPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "\"Ticket price\" page displays with ticket details after clicking on \"check price\" link " +
            "in \"Train timetable\" page", dataProvider = "data-provider")

    public void TC15(String departStation, String arriveStation, String seatType, String ticketPrice) {
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.goToRegisterPage();
        String username = Utilities.getEmailRandom();
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        String pid = Utilities.getPidRandom();
        registerPage.register(username, password, confirmPassword, pid);

        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with a valid account");
        homePage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Step 3: Click on \"Timetable\" tab");
        homePage.goToTimeTablePage();

        System.out.println("Step 4:  Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
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
        JsonObject dataTC15 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC15.get("departStation").getAsString();
        String arriveStation = dataTC15.get("arriveStation").getAsString();
        String seatType = dataTC15.get("seatType").getAsString();
        String ticketPrice = dataTC15.get("ticketPrice").getAsString();

        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketPrice}
        };
        return object;
    }
}
