package utils;

import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {

    /**
     * takescreenshots
     */
    public static void takeScreenShot(){
        takeScreenShot("screenshot");
    }

    /**
     * It is used to take a screenshot of the page.
     * @param fileName filename of the screenshot
     */
    public static void takeScreenShot(String fileName) {
        fileName += "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String filePath = "test-output/screenshots/" + fileName + ".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(sourceFile,destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * java sleep
     * @param millis milliseconds
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
