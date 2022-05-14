package Railway.Timetable;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.TimetablePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC48 extends TestBase {
    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC48 - Verify that \"book ticket\" link can navigate to Book Ticket tab if logged in ")

    public void TC47() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 2: Go to Timetable");
        homePage.goToTimeTablePage();

        System.out.println("Step 3: Click on \"book ticket\" link of any train");
        System.out.println("Step 4: Observe tab is navigated ");
        timetablePage.clickLinkBookTicket("Sài Gòn", "Phan Thiết");
        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Book ticket";
        Assert.assertEquals(actualMsg, expectedMsg, "Cannot navigate to Book Ticket page");
    }
}
