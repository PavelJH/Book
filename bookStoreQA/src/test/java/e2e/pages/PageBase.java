package e2e.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void selectOption(String optionName, WebElement selectElement) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(optionName);
    }

    public void checkNotExistingOption(String expectedNameOption, WebElement selectElement) {
        Select select = new Select(selectElement);
        for (WebElement option : select.getOptions()) {
            Assert.assertNotEquals(option.getText(), expectedNameOption);
        }
    }

    public void fillField(WebElement field) {
        click(field);
        field.clear();
        field.sendKeys();
    }

    public void checkItemText(WebElement element, String expectedText, String err) {
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, err);
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickAlertOkButton() {
        driver.switchTo().alert().accept();
    }

    public void takeAndCompareScreenshot(String actualScreenshotName, WebElement element) throws IOException {
        String referenceImageFilePath = "reference/" + actualScreenshotName + ".png";
        String tmpFilePath = "reference/tmp" + actualScreenshotName + ".png";
        File tmp;
        if (element == null) {
            tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        } else {
            tmp = element.getScreenshotAs(OutputType.FILE);
        }
        Files.copy(tmp.toPath(), new File(tmpFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);

        File referenceImageFile = new File(referenceImageFilePath);
        if (!referenceImageFile.exists()) {
            throw new RuntimeException("Reference image file does not exist: " + referenceImageFilePath);
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        double maxDiffPercent = 0.01 * screenWidth * screenHeight;

        //ProcessBuilder pb = new ProcessBuilder("compare", "-metric", "AE", referenceImageFilePath, tmpFilePath, "null:");
        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\ImageMagick\\compare.exe", "-metric", "AE", referenceImageFilePath, tmpFilePath, "null:");
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        double difference = 0;
        while ((line = reader.readLine()) != null) {
            difference = Integer.parseInt(line.trim());
        }
        reader.close();
        process.destroy();

        if (difference > maxDiffPercent) {
            throw new RuntimeException("Screenshots are different");
        }

        Files.deleteIfExists(new File(tmpFilePath).toPath());
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }


}
