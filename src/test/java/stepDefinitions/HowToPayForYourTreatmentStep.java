package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.OnlinePaymentsPage;

public class HowToPayForYourTreatmentStep {

	WebDriver driver;
	HomePage hp;
	OnlinePaymentsPage opp;

	@Given("user click on How to pay for your treatment tab")
	public void user_click_on_how_to_pay_for_your_treatment_tab() {
		hp = new HomePage(driver);
		opp = new OnlinePaymentsPage(driver);
		hp.clickHowToPayForYourTreatment();

	}

	@Given("user fill in Patient details")
	public void user_fill_in_patient_details() {

	}

	@Given("user fill in Billing details")
	public void user_fill_in_billing_details() {

	}

	@When("user fill in Payment details")
	public void user_fill_in_payment_details() {

	}

	@When("user click pay securely now")
	public void user_click_pay_securely_now() {

	}

	@Then("user should be navigated to payment page")
	public void user_should_be_navigated_to_payment_page() {

	}

}
