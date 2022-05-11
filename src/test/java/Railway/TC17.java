package Railway;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC17 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can't book more than 10 tickets", dataProvider = "data-provider")

    public void TC17(String departStation, String arriveStation, String seatType, String ticketAmount) {
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

        System.out.println("Step 2: Login with a valid account ");
        homePage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Step 3: Click on \"Book ticket\" tab");
        homePage.goToBookTicketPage();

        System.out.println("Step 4: Book 10 tickets");
        String departDate = Utilities.getDepartDate(11);
        bookTicketPage.bookTicketMultipleTimes(departDate, departStation, arriveStation, seatType, ticketAmount, 2);

        System.out.println("Step 5: Click on \"Book ticket\" tab again");
        homePage.goToBookTicketPage();

        System.out.println("Step 6: Book one more ticket");
        bookTicketPage.bookTicketMultipleTimes(departDate, departStation, arriveStation, seatType, ticketAmount, 1);

        String actualMsg1 = homePage.getTitleErrorMessageCommonInForms();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error message doesn't display correctly");

        String actualMsg2 = homePage.getTileValidationError();
        String expectedMsg2 = "You have booked 10 tickets. You can book no more.";
        Assert.assertEquals(actualMsg2, expectedMsg2, "Error message doesn't display correctly");
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
