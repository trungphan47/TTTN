package Railway.MyTicket;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.*;
import Railway.TestBase;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC63 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can cancel a ticket", dataProvider = "data-provider")

    public void TC61(String departStation, String arriveStation, String seatType, String ticketAmount) throws InterruptedException {
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

        System.out.println("Step 3: Book a ticket");
        String departDate = Utilities.getDepartDate(10);
        bookTicketPage.bookTicketMultipleTimes(departDate, departStation, arriveStation, seatType, ticketAmount, 1);

        System.out.println("Step 4: Click on \"My ticket\" tab");
        homePage.goToMyTicketPage();

        System.out.println("Step 5: Click on \"Cancel\" button of ticket which user want to cancel.");
        String getOnClickHanding = myTicketPage.getBtnCancel().getAttribute("onclick");
        myTicketPage.cancelTicket();

        System.out.println("Step 6: Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.acceptAlert();

        System.out.println("Step 7: Verify that the ticket has been canceled");
        Assert.assertTrue((myTicketPage.isBtnCancelDisappear() == true)
                        || ((myTicketPage.isBtnCancelDisappear() == false) &&
                        (getOnClickHanding != myTicketPage.getBtnCancel().getAttribute("onclick"))),
                "Cancel button is not disappear");

        System.out.println("Step 4: Click on \"My ticket\" tab");
        homePage.goToBookTicketPage();

        System.out.println("Step 3: Book a ticket");
        bookTicketPage.bookTicket("","","","","");

        System.out.println("Step 4: Click on \"My ticket\" tab");
        homePage.goToMyTicketPage();

        System.out.println("Step 5: Verify Filter bar Display");
        Assert.assertTrue(myTicketPage.isBtnApplyFilterDisappear(),"Apply Filter is not display");
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
