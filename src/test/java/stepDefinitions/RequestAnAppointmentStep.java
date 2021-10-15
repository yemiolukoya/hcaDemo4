package stepDefinitions;

import java.time.Duration;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.OnlinePaymentsPage;
import pageObjects.RequestAnAppointmentPage;

public class RequestAnAppointmentStep {

	WebDriver driver;

	HomePage hp;
	RequestAnAppointmentPage rap;
	OnlinePaymentsPage opp;

	Logger logger; // for logging

	ResourceBundle rb; // for reading properties file

	String br;
	Scenario scn;

	@Before
	public void setUp(Scenario s)

	{
		logger = LogManager.getLogger(this.getClass()); // for logging
		rb = ResourceBundle.getBundle("config");
		br = rb.getString("browser");
		this.scn = s;
	}

	@After
	public void tearDown(Scenario s) {

		if (s.isFailed()) {

			TakesScreenshot scrnShot = (TakesScreenshot) driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "failed test");

		}
		// driver.quit();

	}

	@Given("user launch the browser")
	public void user_launch_the_browser() {

		if (br.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

		else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}

	@Given("opens URL {string}")
	public void opens_url(String url) throws InterruptedException {
		driver.get(url);

		// Thread.sleep(5000);

		// create object for home page
		hp = new HomePage(driver);

		// create object for request an appointment page
		rap = new RequestAnAppointmentPage(driver);

	

	}

	@When("user click book an appointment")
	public void user_click_book_an_appointment() throws InterruptedException {
		// create object for Online Payment page
		opp = new OnlinePaymentsPage(driver);
		
		
		// hp.clickBookAnAppointment();
	}

	@When("user choose I am a patient option")
	public void user_choose_i_am_a_patient_option() {
		rap.clickiAmThePatient();
	}

	@When("user fill in patient details")
	public void user_fill_in_patient_details() {
		rap.enterFirstName("test");
		rap.enterSurName("surTest");
		rap.enterEmailAddress(RandomStringUtils.randomAlphabetic(5) + "@hca.co.uk");
		rap.enterPhoneNumber("0789940330");
		rap.enterDob();

	}

	@When("user enter appointment details")
	public void user_enter_appointment_details() {
		rap.enterReasonForAppointment("testing");
	}

	@When("user choose communication Preferences")
	public void user_choose_communication_preferences() {
		rap.clickEmailCommunicationPreferences();
	}

	@When("user click submit button")
	public void user_click_submit_button() {
		rap.clickSubmitBtn();
	}

	@Then("confirm you are not a robot message is displayed")
	public void confirm_you_are_not_a_robot_message_is_displayed() {

		// boolean notArobotErrorMessage = rap.isErrorMessageDisplayed();
		// driver.close();

		// if (notArobotErrorMessage)

		// Assert.assertTrue(true);
		// else

		// Assert.assertTrue(false);

		if (rap.isErrorMessageDisplayed()) {
			Assert.assertTrue(true);
			logger.info("Verification passed");

		}

		else

		{
			Assert.assertTrue(false);
			logger.info("Verification failed");

		}

	}

}
