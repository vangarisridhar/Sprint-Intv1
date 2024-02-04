package demo;

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
       System.out.println("Number of links found are: "+ ch.searchForHyperlinks());
        

        System.out.println("end Test case CountHyperlinks: testCase02");

    }

}
