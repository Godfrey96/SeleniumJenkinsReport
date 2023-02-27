package extentmanager;

import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    static String sDefaultPath = System.getProperty("user.dir");

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent(){
        htmlReporter = new ExtentHtmlReporter(sDefaultPath + "/test-output/ExtentReport/" +" MyReport_ " + BaseClass.getCurrentTime() + ".html");

        htmlReporter.loadXMLConfig(sDefaultPath + "/extent-config.xml");
//        htmlReporter.config().setDocumentTitle("Automation Test Report");
//        htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
//        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName","OrangeHRM");
        extent.setSystemInfo("Tester","Mogau");
        extent.setSystemInfo("OS","Win10");
        extent.setSystemInfo("Browser","Chrome");

    }

    public static void endReport(){
        extent.flush();
    }

}
