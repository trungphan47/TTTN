package Railway.TicketPrice;

import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC49 extends TestBase {
    HomePage homePage = new HomePage();

    @Test(description = "TC49 - Verify that user can navigate to the Ticket price tab")

    public void TC49() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Ticket Price page");
        homePage.goToTicketPricePage();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Train ticket pricing list";
        Assert.assertEquals(actualMsg, expectedMsg, "Ticket price page is not displayed as expected");
    }
}
