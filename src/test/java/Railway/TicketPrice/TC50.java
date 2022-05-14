package Railway.TicketPrice;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.*;
import Railway.TestBase;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC50 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    RegisterPage registerPage = new RegisterPage();
    String email = Utilities.getEmailRandom();
    String password = Utilities.getPasswordRandom();
    String pid = Utilities.getPidRandom();

    @Test(description = "Verify that user can view any train price ", dataProvider = "data-provider")

    public void TC50(String departStation, String arriveStation) {
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
        ticketPricePage.clickBtnCheckPrice("19");
        String actualTableTitle = ticketPricePage.getDataEachRowInTicketPriceTable("1");
        String expectedTableTiltle = "Ticket price from " + departStation + " to " + arriveStation;
        Assert.assertEquals(actualTableTitle, expectedTableTiltle, "Display Ticket Error" );
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC50 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC50.get("departStation").getAsString();
        String arriveStation = dataTC50.get("arriveStation").getAsString();

        Object[][] object = new Object[][]{
                {departStation, arriveStation}
        };
        return object;
    }
}
