package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions

(

		features = "@target/rerun.txt",
		// features = { "/Users/yemioluv/eclipse-workspace/HCA_Healthcare/features" },

		glue = {"stepDefinitions"}, dryRun = false
		//tags = "@sanity and @regression"
		// tags="@sanity and not @regression"
		// tags="smoke"
		//plugin = { "pretty", "html:reports/myreport.html", "rerun:target/rerun.txt" // To capture failures}
				

		

)

public class FailureRun {

}
