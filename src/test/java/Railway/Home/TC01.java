package Railway.Home;

import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {
    HomePage homePage = new HomePage();

    @Test(description = "TC001 - Verify that user can navigate to Home page")

    public void TC01() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        System.out.println("Step 2: Go to Homepage");
        homePage.open();
        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Welcome to Safe Railway";
        Assert.assertEquals(actualMsg, expectedMsg, "Homepage is not displayed as expected");
    }
}
