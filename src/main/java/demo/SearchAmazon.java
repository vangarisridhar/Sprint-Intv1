package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchAmazon {

    ChromeDriver driver;

    public SearchAmazon(ChromeDriver driver) {
        this.driver = driver;

    }

    public boolean searchForAmazon() {
        boolean status = false;

        try {
            driver.get("https://www.google.com/");
            // Click on the Search Box Using Locator "Name" //textarea[@name='q']
            driver.findElement(By.name("q")).click();
            // Type the amazon word in Search box Using Locator "Name" //textarea[@name='q']
            driver.findElement(By.name("q")).sendKeys("amazon");
            // Click on Google Search Button Using Locator "XPath" (//input[@value='Google
            // Search'])[1]
            driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();
            // Check if Amazon.in is displayed Using Locator "XPath"
            // //span[contains(text(),'Amazon.in')]
            status = driver.findElement(By.xpath("//span[contains(text(),'Amazon.in')]")).isDisplayed();

        } catch (Exception e) {
            status = false;

        }

        return status;
    }

}
