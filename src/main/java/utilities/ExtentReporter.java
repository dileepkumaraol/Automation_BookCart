package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
		static ExtentReports extentReport;
		
		public static ExtentReports getExtentReport() {
			
			String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
			reporter.config().setReportName("Book Automation Reports");
			reporter.config().setDocumentTitle("Test Report");
			
			extentReport = new ExtentReports();
			extentReport.attachReporter(reporter);
			extentReport.setSystemInfo("Operating System","Windows 10");
			extentReport.setSystemInfo("Tested By","Dileep Kumar R");
			
			return extentReport;
	}

}
