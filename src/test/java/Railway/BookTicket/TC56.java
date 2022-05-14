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

public class TC56 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "Verify that user can not book 11th ticket onwards ", dataProvider = "data-provider")

    public void TC56(String departStation, String arriveStation, String seatType, String ticketAmount) throws InterruptedException {
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
        bookTicketPage.bookTicketMultipleTimes(departDate, departStation, arriveStation, seatType, ticketAmount, 2);
        String actualMessage = bookTicketPage.getNoMoreBookTicketMessage();
        String expectedMessage = "You have booked 10 tickets. You can book no more.";
        Assert.assertEquals(actualMessage, expectedMessage, "Error book ticket function" );
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC56 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC56.get("departStation").getAsString();
        String arriveStation = dataTC56.get("arriveStation").getAsString();
        String seatType = dataTC56.get("seatType").getAsString();
        String ticketAmount = dataTC56.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}

