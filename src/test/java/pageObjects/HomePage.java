package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

	 WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='/request-an-appointment']//div[@class='icon-card__content']")
	WebElement bookAnAppointment;

	public void clickBookAnAppointment() {
		bookAnAppointment.click();
	}
	
	@FindBy(xpath = "//a[@href='/online-payments']//div[@class='icon-card__content']")
	WebElement howToPayForYourTreatment;

	public void clickHowToPayForYourTreatment() {
		howToPayForYourTreatment.click();
	}

}
