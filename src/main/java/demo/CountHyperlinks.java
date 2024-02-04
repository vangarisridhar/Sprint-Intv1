package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountHyperlinks {
    ChromeDriver driver;

    public CountHyperlinks(ChromeDriver driver) {
        this.driver = driver;

    }

    public int searchForHyperlinks() {
int count =0;
        try {
            // Navigate to URL https://in.bookmyshow.com/explore/home/chennai
            driver.get("https://in.bookmyshow.com/explore/home/chennai");
            // Find all the hyperlinks using tag name Using Locator "Tag Name" "a"
            List<WebElement> list = driver.findElements(By.tagName("a"));
            // Count the number of weblelements found for the tagname
            count = list.size();
            return count;

        } catch (Exception e) {

            System.out.println("Test case searchForHyperlinks Failed" + e);
            return count;
        }

    }
}
