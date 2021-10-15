package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OnlinePaymentsPage {

	WebDriver driver;

	public OnlinePaymentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='HCAaccountNumber']")
	WebElement hcaAccountNumber;

	public void enterHcaAccountNumber() {
		hcaAccountNumber.sendKeys("T1234567/1");
	}

	@FindBy(xpath = "//div[@id=\"ui-id-5\"]")
	WebElement titleDrpDwn;

	public void clickTitleDrpDwn() {
		titleDrpDwn.click();
	}

	@FindBy(id = "title")
	WebElement title;

	public void selectTitle() {
		Select titleDrp = new Select(title);
		titleDrp.selectByIndex(2);
	}

	@FindBy(id = "fname")
	WebElement firstName;

	public void enterFirstName() {
		firstName.sendKeys("Yemi");

	}

	@FindBy(id = "lname")
	WebElement surName;

	public void enterSurName() {
		surName.sendKeys("Olukoya");

	}

}
