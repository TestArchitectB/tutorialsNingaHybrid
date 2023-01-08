package com.tutorialsNinja.listners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReport {
	
	public static ExtentReports generateExtentReports() {
		
		ExtentReports extentReports=new ExtentReports();
		File extentReporterFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReporterFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Automation Test Results");
		sparkReporter.config().setDocumentTitle("TutorialsNinja Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		extentReports.attachReporter(sparkReporter);
		Properties prop=new Properties();
		File file=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutorialsNinja\\config\\config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentReports.setSystemInfo("Application url:",prop.getProperty("url"));
		extentReports.setSystemInfo("Operation System ",System.getProperty("os.name"));
		extentReports.setSystemInfo("java version",System.getProperty("java.version"));
		
		return extentReports;
	
	}

}
