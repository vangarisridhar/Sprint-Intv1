package testngPackage;

import static org.testng.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import com.epam.tat.module4.Calculator;
import com.relevantcodes.extentreports.LogStatus;

public class AppTest

{
	private static Logger logger = LogManager.getLogger(AppTest.class);
	Calculator calculator = new Calculator();
	GenerateExtentReport reports = new GenerateExtentReport();

	@BeforeTest
	void beforeTest() {
		reports.startReport();
		System.out.println("Executed @BeforeTest");
		logger.info(" @BeforeTest operation Executed");
	}

	@Test(dataProvider = "excelDataProvider", dataProviderClass = ExcelDataProvider.class)
	void additionTest(String s1, String s2, String result) throws NumberFormatException {

		try {
			assertEquals(Double.parseDouble(result), calculator.sum((Double.parseDouble(s1)), (Double.parseDouble(s2))),
					"Addition Result is not as Expected");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "Addition Test Passed");
			logger.info(" @additionTest Successful");
		} catch (Exception e) {

			GenerateExtentReport.extTest.log(LogStatus.FAIL, "Addition Result is not as Expected");
			logger.info(" @additionTest Failed");
		}
	}

	@Test(groups = { "StandardCalculator" })
	void subtractionTest() {

		try {
			assertEquals(50, calculator.sub(100, 50), "Subtraction Result is not same as Expected value");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "Subtraction Test Passed");
			logger.info(" @subtractionTest Passed");
		} catch (AssertionError e) {

			GenerateExtentReport.extTest.log(LogStatus.FAIL, "Subtraction Test Failed" + e.getMessage());
			logger.info(" @subtractionTest Failed");
		}
	}

	@Test(dataProvider = "excelDataProvider", dataProviderClass = ExcelDataProvider.class)
	void divisionTest(String s1, String s2, String result) {

		try {

			assertEquals(Double.parseDouble(result), calculator.div((Double.parseDouble(s1)), (Double.parseDouble(s2))),
					"Divison operation result is not same as Expected Value");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "Division Test PASSED");
			logger.info(" @DivisionTest Passed");

		} catch (AssertionError e) {

			GenerateExtentReport.extTest.log(LogStatus.FAIL, "Division Test FAILED" + e.getMessage());
			logger.info(" @DivisionTest Failed");
		}

	}

	@Test(groups = { "ScientificCalculator" })

	void sinTest() {
		try {
			double valueRadians = Math.toRadians(30);
			assertEquals(0.49999999999999994, calculator.sin(valueRadians), "Sine of input is  Calculated Incorrectly");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "Sine Test PASSED");
			logger.info(" @sineTest Passed");
		} catch (AssertionError e) {

			GenerateExtentReport.extTest.log(LogStatus.FAIL, "Sine Test FAILED" + e.getMessage());
			logger.info(" @sineTest Failed");
		}
	}

	@Test(groups = { "ScientificCalculator" })
	void cosTest() {
		double result;
		double valueRadians = Math.toRadians(60);

		try {
			result = calculator.cos(valueRadians);
			assertEquals(0.5000000000000001, result, "Cosine of Input is not matching with the Expected Value");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "Cosine Test PASSED");
			logger.info(" @CosineTest Passed");

		} catch (AssertionError e) {

			GenerateExtentReport.extTest.log(LogStatus.FAIL, "Cosine Test FAILED" + e.getMessage());
			logger.info(" @CosineTest Failed");
		}
	}

	@Test(groups = { "ScientificCalculator", "StandardCalculator" })
	void squareRootTest() {
		try {
			assertEquals(4, calculator.sqrt(16), "SquareRoot of Input is different from Expected Value");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "SquareRoot Test PASSED");
			logger.info(" @SquareRootTest Passed");

		} catch (AssertionError e) {
			GenerateExtentReport.extTest.log(LogStatus.FAIL, "SquareRoot Test FAILED" + e.getMessage());
			logger.info(" @SquareRootTest Failed");
		}
	}

	@Test(dependsOnGroups = { "StandardCalculator" })
	void isNegativeTest() {
		try {
			assertEquals(true, calculator.isNegative(-5),
					"The input supplied to isNegative() is a not a Negative Value");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "IsNegative Test PASSED");
			logger.info(" @isNegativeTest Passed");
		} catch (AssertionError e) {

			GenerateExtentReport.extTest.log(LogStatus.FAIL, "IsNegative Test FAILED" + e.getMessage());
			logger.info(" @isNegativeTest Failed");

		}
	}

	@Test(groups = { "ScientificCalculator", "StandardCalculator" })
	void powerTest() {
		try {
			assertEquals(32, calculator.pow(2, 5),
					"Expected value doesnot match with Actual value for powerOf calculation");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "Power Test PASSED");
			logger.info(" @PowerTest Passed");
		} catch (AssertionError e) {
			GenerateExtentReport.extTest.log(LogStatus.FAIL, "Power Test FAILED" + e.getMessage());
			logger.info(" @PowerTest Failed");
		}
	}

	@Test(groups = { "ScientificCalculator" })
	void tangetTest() {
		try {
			double valueRadians = Math.toRadians(45);
			assertEquals(1, calculator.tg(valueRadians),
					"Expected value doesnot match with Actual value for Tangent calculation");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "Tangent Test PASSED");
			logger.info(" @TangentTest Passed");
		} catch (AssertionError e) {
			GenerateExtentReport.extTest.log(LogStatus.FAIL, "tangent Test FAILED" + e.getMessage());
			logger.info(" @TangentTest Failed");
		}
	}

	@Test(groups = { "StandardCalculator" })
	void isPositiveTest() {
		try {
			assertEquals(true, calculator.isPositive(5),
					"The input supplied to isPositive() is a not a Positive Value");
			GenerateExtentReport.extTest.log(LogStatus.PASS, "IsPositive Test PASSED");
			logger.info(" @isPositiveTest Passed");
		} catch (AssertionError e) {
			GenerateExtentReport.extTest.log(LogStatus.FAIL, "isPositive Test FAILED" + e.getMessage());
			logger.info(" @TangentTest Failed");

		}
	}

	@AfterTest
	void afterTest() {
		reports.endtesting();
		System.out.println("Executed @AfterTest");
		logger.info("Executed @AfterTest");
	}
}
