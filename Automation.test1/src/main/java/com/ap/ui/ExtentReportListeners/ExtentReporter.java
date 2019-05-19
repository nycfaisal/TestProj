package com.ap.ui.ExtentReportListeners;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ExtentReporter implements IReporter 
{
	private ExtentReports extent;
//we are creating function with 3 parameter in which it will data from xmlsuite and Isuite class to direcotry folder/file mentioned
	//outputdirectory is for pass/failed
public void generateReport(List<XmlSuite>xmlSuites, List<ISuite>suites, String outputDirectory)
{
	//saving as string  value. file seperator not needed but helpful to distinguish, extent.html file should look like html file. true is for when you  recieve any report then generate  report 
	extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);
	
	for (ISuite suite : suites)//map obtain a key to unique value(cannot be duplicate)then it will map it to one location, that once location is basically the extent report. map is java interface
	{
		Map<String, ISuiteResult>result = suite.getResults();//value recieved from result and sharing to extent report. map is ensuring its a unique value and not a duplicate
	
	
	for (ISuiteResult r : result.values())
	{
		ITestContext context = r.getTestContext();//why all things must be value and context?
		
		buildTestNodes(context.getPassedTests(), LogStatus.PASS);
		buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
		buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
	}
	
	
}
	extent.flush();//assume exectuion completed, and take the result and added to html report
	extent.close();//close the report for me.
	
}

public void buildTestNodes(IResultMap tests, LogStatus status)//how it is private constructor?
{
	ExtentTest test;//calling extentest and naming it test
	
	if (tests.size()>0)
	{
		for (ITestResult result: tests.getAllResults())
		{
			test = extent.startTest(result.getMethod().getMethodName());
			
			test.setStartedTime(getTime(result.getStartMillis()));//gives you duration time and tells you how long it took the test
			test.setEndedTime(getTime(result.getEndMillis()));
			
			for(String group : result.getMethod().getGroups())test.assignCategory(group);//assigning all the results and placing it group
			
			if(result.getThrowable() !=null)// log all the errors. null is empty string
			{
				test.log(status,  result.getThrowable());
		} else {
			test.log(status, "Test" + status.toString().toLowerCase() + "ed");
		}
			
			extent.endTest(test);
		}
	
}
}
	
	private Date getTime(long millis)
	{
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(millis);
		return calender.getTime();
	}
	
	
	
	
	
	
	
}