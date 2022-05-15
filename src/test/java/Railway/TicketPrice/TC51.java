package Railway.TicketPrice;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.*;
import Railway.TestBase;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC51 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();
    String email = Utilities.getEmailRandom();
    String password = Utilities.getPasswordRandom();
    String pid = Utilities.getPidRandom();

    @Test(description = "Verify that \"book ticket\" link can navigate to Book Ticket tab", dataProvider = "data-provider")

    public void TC51(String departStation, String arriveStation, float hsPrice) {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with a valid account");
        homePage.goToRegisterPage();
        registerPage.register(email, password, password, pid);

        homePage.goToLoginPage();
        loginPage.login(email, password);

        System.out.println("Step 3:  Click on \"Ticket price\" tab\n");
        homePage.goToTicketPricePage();

        System.out.println("Step 4:  Click \"Check Price\" in section \"Trains depart from Đà\n" + "Nẵng\" " +
                "for checking price Đà Nẵng to Huế");
        ticketPricePage.clickBtnCheckPrice(departStation, arriveStation);

        System.out.println("Step 5: On Ticket price page, click \"Book ticket\" with Hard\n" + "seat");
        ticketPricePage.clickBtnBookTicketInTicketPricePage("2");

        System.out.println("Step 6: . Click \"Book ticket\" with default information");
        bookTicketPage.clickBtnBookTicket();

        float expectPrice = hsPrice;
        float actualPrice = Float.parseFloat(bookTicketPage.getDataBookedTicketSuccessfully("8"));
        Assert.assertEquals(actualPrice, expectPrice, "Ticket price display incorrectly");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject TC50 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = TC50.get("departStation").getAsString();
        String arriveStation = TC50.get("arriveStation").getAsString();
        float hsPrice = TC50.get("HS").getAsFloat();

        Object[][] object = new Object[][]{
                {departStation, arriveStation, hsPrice}
        };
        return object;
    }
}

