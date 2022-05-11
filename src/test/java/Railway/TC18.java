package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.TicketPricePage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC18 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "User can book ticket with known price", dataProvider = "data-provider")

    public void FTTC303(float hsPrice) {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with a valid account");
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 3:  Click on \"Ticket price\" tab\n");
        homePage.goToTicketPricePage();

        System.out.println("Step 4:  Click \"Check Price\" in section \"Trains depart from Đà\n" + "Nẵng\" " +
                "for checking price Đà Nẵng to Huế");
        ticketPricePage.clickBtnCheckPrice("19");

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
        JsonObject FTTC303 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        float hsPrice = FTTC303.get("HS").getAsFloat();

        Object[][] object = new Object[][]{
                {hsPrice}
        };
        return object;
    }
}
