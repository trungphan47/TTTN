package Railway.Timetable;

import PageObjects.HomePage;
import PageObjects.TimetablePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC47 extends TestBase {
    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();

    @Test(description = "TC47 - Verify that \"book ticket\" link cannot navigate to Book Ticket tab\n" +
            "if not logged in yet")

    public void TC47() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Timetable");
        homePage.goToTimeTablePage();

        System.out.println("Step 3: Click on \"book ticket\" link of any train");
        System.out.println("Step 4: Observe tab is navigated ");
        timetablePage.clickLinkBookTicket("Sài Gòn", "Phan Thiết");
        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Login Page";
        Assert.assertEquals(actualMsg, expectedMsg, "Cannot navigate to Login page");
    }
}
