package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

public class ImdbRating {

    ChromeDriver driver;

    public ImdbRating(ChromeDriver driver) {
        this.driver = driver;

    }

    public void searchForImdRating() {

        try {
            //Navigate to url "https://www.imdb.com/chart/top/"
            driver.get("https://www.imdb.com/chart/top/");

          Thread.sleep(15000);
          //find the total number of elements matching the xpath //div[@class = 'ipc-metadata-list-summary-item__tc'] and get the count
          List<WebElement> movielist= driver.findElements(By.xpath("//div[@class = 'ipc-metadata-list-summary-item__tc']"));
          System.out.println("Total movies in the table are : "+movielist.size());
            //Using Select class find the dropdown element using the id "sort-by-selector"
            Select dropdown = new Select(driver.findElement(By.id("sort-by-selector")));
            //select the dropdown list by using the function selectbyVisibleText with text as "IMDb rating"
            dropdown.selectByVisibleText("IMDb rating");
            Thread.sleep(3000);
            //to retrieve the highest rated movie name find the element using the xpath "(//h3[@class='ipc-title__text'])[2]" and getText function
             System.out.println("Highest rated movie name is: "+driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]")).getText());
           //usig the select class select the option by visible text "Number of ratings"
             dropdown.selectByVisibleText("Number of ratings");
             Thread.sleep(3000);
             //Print the movie which has most user ratings by finding the element using xpath "(//h3[@class='ipc-title__text'])[2]" and getText function
             System.out.println("Movie which has the most user ratings is: "+driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]")).getText());
            //using the select class select the option by visible text  "Release date"
             dropdown.selectByVisibleText("Release date");
             //scroll the webpage to 3500 pixels down
               JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3500)", "");

        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,3500)", "");
        Thread.sleep(10000);
        //scroll the webpage to the last listed movie using xpath (//h3[@class='ipc-title__text'])[251]
        WebElement element = driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[251]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            //print the most recent movie in the list using the findelement by xpath //h3[@class='ipc-title__text'])[2] and getText function
             System.out.println("most recent movie on the list is: "+driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[2]")).getText());
             //pirnt the oldest movie in th list using the findelement by xpath //h3[@class='ipc-title__text'])[251] and getText function
             System.out.println("oldest movie on the list is: "+driver.findElement(By.xpath("(//h3[@class='ipc-title__text'])[251]")).getText());
            } catch (Exception e) {
            System.out.println("Exception occured while testing testcase 08" + e);

        }

    }

}
