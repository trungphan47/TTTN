package Common;

import Common.Constant;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utilities {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static String getProjectPathDataJson() {
        return System.getProperty("user.dir") + "/src/main/java/DataObjects/data.json";
    }

    public static void scrollPage(WebElement element) {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static WebElement waitForElement(int times, By locator) {
        @Deprecated
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, times);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String getEmailRandom() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 2) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + System.currentTimeMillis() + "@gmail.com";
    }

    public static String conditionalEmailRandom(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length() - 9) + "@t.c";
        return email;
    }

    public static String conditionalPasswordRandom(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String password = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        password = temp.substring(0, temp.length() - 9);
        return password;
    }

    public static String conditionalPIDRandom(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
        String pid = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        pid = temp.substring(0, temp.length() - 9);
        return pid;
    }

    public static String getPidRandom() {
        String pid = "1234567890";
        StringBuilder pidRnd = new StringBuilder();
        Random rnd = new Random();
        while (pidRnd.length() < 20) {
            int index = (int) (rnd.nextFloat() * pid.length());
            pidRnd.append(pid.charAt(index));
        }
        String pidStr = pidRnd.toString();
        return pidStr;
    }

    public static String getPasswordRandom() {
        String password = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder passwordRnd = new StringBuilder();
        Random rnd = new Random();
        while (passwordRnd.length() < 21) {
            int index = (int) (rnd.nextFloat() * password.length());
            passwordRnd.append(password.charAt(index));
        }
        String passwordStr = passwordRnd.toString();
        return passwordStr;
    }

    public static String getDepartDate(int dateAmount) {
        LocalDate currentDate = LocalDate.now();
        LocalDate date = currentDate.plusDays(dateAmount);
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofPattern("MM/dd/yyyy");
        String temp = date.format(dateFormatter);
        String[] temp1 = temp.split("/");
        int getMonth = Integer.parseInt(temp1[0]);
        int getDay = Integer.parseInt(temp1[1]);
        int getYear = Integer.parseInt(temp1[2]);
        String departDate = getMonth + "/" + getDay + "/" + getYear;
        return departDate;
    }

}
