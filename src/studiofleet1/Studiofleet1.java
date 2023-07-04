package studiofleet1;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Studiofleet1 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\studiofleet1\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Navigate to the signup page
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        // Scenario 1: Valid signup
        testValidSignup(driver);

        // Scenario 2: Invalid email format
        testInvalidEmailFormat(driver);

        // Scenario 3: Passwords don't match
        testPasswordsMismatch(driver);

        // Scenario 4: Required fields not filled
        testRequiredFieldsNotFilled(driver);

        // Close the browser
        driver.quit();
    }

    private static void testValidSignup(WebDriver driver) {
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Doe");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("example@example.com");

        WebElement telephoneInput = driver.findElement(By.id("input-telephone"));
        telephoneInput.sendKeys("1234567890");

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("secretpassword");

        WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
        confirmPasswordInput.sendKeys("secretpassword");

        WebElement agreeCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
        agreeCheckbox.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        // Add assertion or verification steps for successful signup

        // Capture a screenshot
        captureScreenshot(driver, "valid_signup");
    }

    private static void testInvalidEmailFormat(WebDriver driver) {
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Doe");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("invalidemail");

        WebElement telephoneInput = driver.findElement(By.id("input-telephone"));
        telephoneInput.sendKeys("1234567890");

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("secretpassword");

        WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
        confirmPasswordInput.sendKeys("secretpassword");

        WebElement agreeCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
        agreeCheckbox.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        // Add assertion or verification steps for email format validation error

        // Capture a screenshot
        captureScreenshot(driver, "invalid_email_format");
    }

    private static void testPasswordsMismatch(WebDriver driver) {
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Doe");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("example@example.com");

        WebElement telephoneInput = driver.findElement(By.id("input-telephone"));
        telephoneInput.sendKeys("1234567890");

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("secretpassword");

        WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
        confirmPasswordInput.sendKeys("mismatchedpassword");

        WebElement agreeCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
        agreeCheckbox.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        // Add assertion or verification steps for password mismatch validation error

        // Capture a screenshot
        captureScreenshot(driver, "passwords_mismatch");
    }

    private static void testRequiredFieldsNotFilled(WebDriver driver) {
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        // Add assertion or verification steps for required field validation errors

        // Capture a screenshot
        captureScreenshot(driver, "required_fields_not_filled");
    }

    private static void captureScreenshot(WebDriver driver, String scenarioName) {
        // Take screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new Date().toString().replace(":", "_").replace(" ", "_");

        // Define the path where the screenshot will be saved
        String screenshotPath = "C:\\Users\\Admin\\eclipse-workspace\\studiofleet1\\screenshot" + scenarioName + "_" + timestamp + ".png";

        try {
            // Save the screenshot to the specified path
            FileHandler.copy(screenshotFile, new File(screenshotPath));
            System.out.println("Screenshot captured: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}