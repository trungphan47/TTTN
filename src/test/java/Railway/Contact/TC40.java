package Railway.Contact;

import PageObjects.ContactPage;
import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC40 extends TestBase {
    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();

    @Test(description = "TC40 - Verify that contact infor displays")

    public void TC40() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to contact tab");
        homePage.goToContactTab();

        System.out.println(contactPage.contactInfo());
        String expectedContactInfo = "Seatcode: 404\n" +
                "Phone: 012650.888.79\n" +
                "Skype: vietthanhle.lg\n" +
                "Email: thanh.viet.le@logigear.com";

        String actualMsg = contactPage.contactInfo();
        String expectedMsg = expectedContactInfo;
        Assert.assertEquals(actualMsg, expectedMsg, "There was a problem with your login and/or errors exist in your form.");
    }
}
