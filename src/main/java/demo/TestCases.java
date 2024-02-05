package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case SearchAmazon: testCase01");

        // Navigate to google https://www.google.com/
        SearchAmazon sa = new SearchAmazon(driver);
        if (sa.searchForAmazon())
            System.out.println("Testcase passed");
        else
            System.out.println("Testcase failed");

        System.out.println("end Test case SearchAmazon: testCase01");

    }

    public void testCase02() {
        System.out.println("Start Test case CountHyperlinks: testCase02");

        // Navigate to google https://www.google.com/
        CountHyperlinks ch = new CountHyperlinks(driver);
        System.out.println("Number of links found are: " + ch.searchForHyperlinks());

        System.out.println("end Test case CountHyperlinks: testCase02");

    }

    public void testCase05() throws InterruptedException {
        System.out.println("Start Test case CountImageUrls: testCase05");

        // Navigate to google https://www.google.com/
        ImageUrls iu = new ImageUrls(driver);
        System.out.println("Number of links found are: " + iu.searchForImageUrls());

        System.out.println("end Test case CountImageUrls: testCase05");

    }


    public void testCase07() throws InterruptedException {
        System.out.println("Start Test case NestedFramesText: testCase02");

        NestedFramesText nft= new NestedFramesText(driver);
        nft.searchForNestedFramesText();

      //  System.out.println("Texts found on the page are: "+);




        System.out.println("End Test case NestedFramesText: testCase02");

    }

}
