package Railway.Timetable;

import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC42 extends TestBase {
    HomePage homePage = new HomePage();

    @Test(description = "TC42 - Verify that user can navigate to Timetable tab")

    public void TC42() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Timetable page");
        homePage.goToTimeTablePage();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Train Timetable";
        Assert.assertEquals(actualMsg, expectedMsg, "Timetable page is not displayed as expected");
    }
}
