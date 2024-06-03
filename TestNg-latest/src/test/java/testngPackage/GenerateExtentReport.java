package testngPackage;

import java.io.File;

import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public  class GenerateExtentReport {
	
	static ExtentReports report;
	static ExtentTest extTest;
	
	public void startReport() {
		
		 report = new ExtentReports(System.getProperty("user.dir") + "/test-output/CalculatorExtentReport" + ".html",true);
		 report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		 System.out.println("createReport()");
		 extTest = report.startTest("Starting the Calcultor Test Suite");
	}
//	
//	  public ExtentReports getReport() {
//	       // System.out.println("report contents are:"+report);
//	        return report;
//
//	    }
//
//	    public ExtentTest getTest() {
//	       
//	        return extTest;
//
//	    }

	    @AfterSuite
	    public void endtesting() {


	        // TODO - End the test
	        report.endTest(extTest);
	        report.flush();


	    }

}
