package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

	public class extentReports implements ITestListener {
		public ExtentSparkReporter sparkReporter;
		public ExtentReports report;
		public ExtentTest test;

		String reportName;

		public void onStart(ITestContext testContext) {
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			reportName = "TestNG_ExtentReport"+timeStamp+".html";

			String filepath = System.getProperty("user.dir") + "/reports/";
			sparkReporter = new ExtentSparkReporter(filepath + reportName);// specify location of the report

			sparkReporter.config().setDocumentTitle("Zig Wheels "); // Title of report
			sparkReporter.config().setReportName("Search for bikes"); // name of the report
			sparkReporter.config().setTheme(Theme.STANDARD);

			report = new ExtentReports();
			report.attachReporter(sparkReporter);
			report.setSystemInfo("Application", "Zig Wheels");
			report.setSystemInfo("Module", "Search for bikes");
			report.setSystemInfo("Sub Module", "upcoming bikes and used cars");
			report.setSystemInfo("Operating System", System.getProperty("os.name"));
			report.setSystemInfo("User Name", System.getProperty("user.name"));
			String browser = testContext.getCurrentXmlTest().getParameter("browser");
			report.setSystemInfo("Browser", browser);
			
			List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty()) {
			report.setSystemInfo("Groups", includedGroups.toString());
		}
		}

		public void onTestSuccess(ITestResult result) {
			test = report.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, "Test Passed");
		}

		public void onTestFailure(ITestResult result) {
			test = report.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL, "Test Failed");
			test.log(Status.FAIL, result.getThrowable().getMessage());

			
		}

		public void onTestSkipped(ITestResult result) {
			test = report.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, "Test Skipped");
			test.log(Status.SKIP, result.getThrowable().getMessage());
		}

		public void onFinish(ITestContext testContext) {
			report.flush();

			
		}
	}


