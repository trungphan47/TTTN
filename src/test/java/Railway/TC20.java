package Railway;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC20 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(description = "\"Manage ticket\" displays remaining available\n" + "number of booking",
            dataProvider = "data-provider")

    public void FTTC502(String departStation, String arriveStation, String seatType, String ticketAmount) throws InterruptedException {
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.goToRegisterPage();
        String username = Utilities.getEmailRandom();
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        String pid = Utilities.getPidRandom();
        registerPage.register(username, password, confirmPassword, pid);
        homePage.open();

        System.out.println("Step 2: Login with a valid account");
        homePage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Step 3:  Book 4 tickets with different Depart Dates");
        homePage.goToBookTicketPage();
        bookTicketPage.bookTicket(
                Utilities.getDepartDate(4), departStation, arriveStation, seatType, ticketAmount);
        homePage.goToBookTicketPage();
        bookTicketPage.bookTicket(
                Utilities.getDepartDate(5), departStation, arriveStation, seatType, ticketAmount);
        homePage.goToBookTicketPage();
        bookTicketPage.bookTicket(
                Utilities.getDepartDate(6), departStation, arriveStation, seatType, ticketAmount);
        homePage.goToBookTicketPage();
        bookTicketPage.bookTicket(
                Utilities.getDepartDate(7), departStation, arriveStation, seatType, ticketAmount);

        System.out.println("Step 4:  Click on \"My ticket\" tab");
        homePage.goToMyTicketPage();
        String expectedMsg = "You currently book 4 tickets, you can book 6 more.";
        String actualMsg = myTicketPage.getLblInformTheNumberOfTicketsBookedMsg();
        Assert.assertEquals(actualMsg, expectedMsg, "A notification message displays incorrectly");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTTC502 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTTC502.get("departStation").getAsString();
        String arriveStation = dataTTC502.get("arriveStation").getAsString();
        String seatType = dataTTC502.get("seatType").getAsString();
        String ticketAmount = dataTTC502.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
