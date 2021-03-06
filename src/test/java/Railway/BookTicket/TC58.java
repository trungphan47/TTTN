package Railway.BookTicket;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC58 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "Verify that user can book tickets with a total number of tickets has no more than 10", dataProvider = "data-provider")

    public void TC58(String departStation, String arriveStation, String seatType, String ticketAmount) throws InterruptedException {
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.goToRegisterPage();
        String username = Utilities.getEmailRandom();
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        String pid = Utilities.getPidRandom();
        registerPage.register(username, password, confirmPassword, pid);

        System.out.println("Step 1:  Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with a valid account ");
        homePage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Step 3: Click on \"Book ticket\" tab");
        homePage.goToBookTicketPage();

        System.out.println("Step 4:  Book ticket");
        String departDate = Utilities.getDepartDate(8);
        bookTicketPage.bookTicket(departDate, departStation, arriveStation, seatType, ticketAmount);

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "User cannot book ticket");

        String actualDepartDate = bookTicketPage.getDataBookedTicketSuccessfully("4");
        String expectedDepartDate = departDate;
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart date doesn't match");

        String actualDepartStation = bookTicketPage.getDataBookedTicketSuccessfully("1");
        String expectedDepartStation = departStation;
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart station doesn't match");

        String actualArriveStation = bookTicketPage.getDataBookedTicketSuccessfully("2");
        String expectedArriveStation = arriveStation;
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive station doesn't match");

        String actualSeatType = bookTicketPage.getDataBookedTicketSuccessfully("3");
        String expectedSeatType = seatType;
        Assert.assertEquals(actualSeatType, expectedSeatType, "Seat type doesn't match");

        String actualTicketAmount = bookTicketPage.getDataBookedTicketSuccessfully("7");
        String expectedTicketAmount = ticketAmount;
        Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket amount doesn't match");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC58 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC58.get("departStation").getAsString();
        String arriveStation = dataTC58.get("arriveStation").getAsString();
        String seatType = dataTC58.get("seatType").getAsString();
        String ticketAmount = dataTC58.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
