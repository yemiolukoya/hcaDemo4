package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		// features = { "/Users/yemioluv/eclipse-workspace/HCA_Healthcare/features" },
		// features = "@target/rerun.txt",

		
		// How To Pay For Your Treatment Feature
		features = { "/Users/yemioluv/eclipse-workspace/HCA_HealthCare_3/features/HowToPayForYourTreatment.feature" },
		
		
		// Book An appointment feature
		 //features = {"/Users/yemioluv/eclipse-workspace/HCA_Healthcare/features/BookAnAppointment.feature"},

		glue = "stepDefinitions", dryRun = false,
		// tags="@sanity and @regression",
		// tags="@sanity and not @regression"
		// tags="smoke"
		plugin = { "pretty", // "html:reports/myreport.html",
				"rerun:target/rerun.txt", // To capture failures
				"json:target/json/file.json",
		// "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

		}, monochrome = true

)

public class TestRun {

}
