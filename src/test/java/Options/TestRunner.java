package Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",plugin ={"pretty",
        "html:target/cucumber-reports/html-report.html",
        "json:target/cucumber-reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},glue= {"stepDefinitions"})
public class TestRunner {

    @BeforeClass
    public static void setUp() {
        // Ensure the cucumber-reports directory is created
        File reportDir = new File("target/cucumber-reports");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

    }

}
