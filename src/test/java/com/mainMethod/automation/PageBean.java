package com.mainMethod.automation;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Freelance.com.projectSetup.VARIABLES;

public class PageBean {

	private static final Duration DEFAULT_WAIT = Duration.ofSeconds(15);
	private static final Duration POLLING_INTERVAL = Duration.ofMillis(200);

	private final WebDriver driver;
	private final WebDriverWait wait;

	private final By email = By.id("inputUserName");
	private final By passWord = By.id("inputPassword");
	private final By seasonDropdown = By.id("insurance_user_season");
	private final By sessionDropdown = By.id("user_session");
	private final By checkbox = By.xpath("//input[@type='checkbox']");
	private final By generateOtp = By.id("generate_otp");
	private final By loginButton = By.xpath("//button[@class=\"btn btn-group btn-default btn-animated btn_login\"]");
	private final By otp = By.id("otp");
	private final By listToGo = By.xpath("//*[@id= 'navbar-collapse-1']/div[2]/ul/li[3]/a");
	private final By list = By.xpath("//*[@id=\"navbar-collapse-1\"]/div[2]/ul/li[3]/ul/li[1]/a");
	private final By voterCardNumber = By.id("insure_voter_id");
	private final By searchButton = By.id("insur_search");
	private final By already_existing_crop = By.xpath("//tbody[@id='tbodycrop']/tr/td[2]");
	private final By already_existing_gram_panchayat = By.xpath("//tbody[@id='tbodycrop']/tr/td[5]");
	private final By aadharCardNumber = By.id("insure_aadhar_no");
	private final By applicationSource = By.id("insure_app_type");
	private final By nameAsPerEpic = By.id("insure_name");
	private final By fatherOrHusbandName = By.id("insure_f_name");
	private final By relationWithFarmerDropDown = By.id("insure_f_relation");
	private final By ageDropDown = By.id("insure_age");
	private final By genderDropDown = By.id("insure_gender");
	private final By casteDropDown = By.id("insure_caste");
	private final By mobileNumber = By.id("insure_mobile_no");
	private final By farmerCategoryDropDown = By.id("insure_f_category");
	private final By voterIDUpload = By.id("insure_id_proof");
	private final By aadharIDUpload = By.id("insure_aadhar_doc");
	private final By farmersResidentialAddressDistrictDropDown = By.id("f_district");
	private final By farmersResidentialAddressblockDropDown = By.id("block_id");
	private final By farmersResidentialAddressgramPanchayatDropDown = By.id("gp_id");
	private final By farmersResidentialAddressvillageDropDown = By.id("vill_id");
	private final By pinCode = By.id("pin_code");
	private final By cropDetailsDistrictDropDown = By.id("insurance_farmer_insurance_applications_attributes_0_district_id");
	private final By cropDetailsBlockDropDown = By.id("insurance_farmer_insurance_applications_attributes_0_block_id");
	private final By cropDetailsCropDropDown = By.id("insurance_farmer_insurance_applications_attributes_0_crop_id");
	private final By cropDetailsGramPanchayatInitial = By.id("insurance_farmer_insurance_applications_attributes_0_gram_panchayat_id");
	private final By cropDetailsGramPanchayatFinal = By.id("insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_gram_panchayat_id");
	private final By cropDetailsMouzaDropDown = By.id("insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_mouza_id");
	private final By cropDetailskhaitanNumber = By.id("insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_khatian_no");
	private final By cropDetailsPlotNumber = By.id("insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_plot_no");
	private final By cropDetailsAreaInAcre = By.id("insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_inc_land_in_acer");
	private final By cropDetailsNatureOfFarmerDropDown = By.id("insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_nature_of_farmer");
	private final By cropDetailsParchaUpload = By.id("insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_parcha_document");
	private final By landDocumentProofUpload = By.id("insurance_farmer_insurance_applications_attributes_0_land_document");
	private final By bankDetailsAccountHolderName = By.id("insurance_farmer_insurance_applications_attributes_0_account_holder_name");
	private final By bankDetailsAccountNumber = By.id("insurance_farmer_insurance_applications_attributes_0_account_number");
	private final By accountTypeDropDown = By.id("insurance_farmer_insurance_applications_attributes_0_account_type");
	private final By ifsCode = By.id("insurance_farmer_insurance_applications_attributes_0_account_ifsc");
	private final By bankName = By.id("insurance_farmer_insurance_applications_attributes_0_bank_name");
	private final By bankDocumentProofUpload = By.id("insurance_farmer_insurance_applications_attributes_0_bank_document");
	private final By submitButton = By.id("before_insure_submit");

	public PageBean(WebDriver driver) {
		this.driver = driver;
		this.wait = (WebDriverWait) new WebDriverWait(driver, DEFAULT_WAIT)
			.pollingEvery(POLLING_INTERVAL)
			.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
	}

	private WebElement find(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	private WebElement findClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	private void click(By locator) {
		findClickable(locator).click();
	}

	private void sendKeys(By locator, String text) {
		WebElement element = findClickable(locator);
		element.clear();
		element.sendKeys(text);
	}

	private Select select(By locator) {
		return new Select(findClickable(locator));
	}

	private void selectByIndex(By locator, int index) {
		select(locator).selectByIndex(index);
	}

	private void selectByValue(By locator, String value) {
		select(locator).selectByValue(value);
	}

	private void selectByVisibleText(By locator, String text) {
		select(locator).selectByVisibleText(text);
	}

	private void waitForOptions(By locator) {
		wait.until(driver -> select(locator).getOptions().size() > 1);
	}

	private boolean isSelected(By locator) {
		try {
			return find(locator).isSelected();
		} catch (RuntimeException e) {
			return false;
		}
	}

	private String getValue(By locator) {
		try {
			String value = find(locator).getAttribute("value");
			return value == null ? "" : value;
		} catch (RuntimeException e) {
			return "";
		}
	}

	private void uploadFile(By locator, String directory, String fileName) {
		try {
			File file = new File(directory, fileName + ".jpg");
			if (!file.exists()) {
				throw new FileNotFoundException("File not found at: " + file.getAbsolutePath());
			}
			find(locator).sendKeys(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			System.err.println("Error: File was not found: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Error uploading file: " + e.getMessage());
		}
	}

	public void gotoPage() {
		Actions action = new Actions(driver);
		action.moveToElement(find(listToGo)).perform();
		click(list);
	}

	public void login(String username, String password, int seasonIndex, int sessionIndex) {
		sendKeys(email, username);
		sendKeys(passWord, password);
		selectByIndex(seasonDropdown, seasonIndex);
		waitForOptions(sessionDropdown);
		selectByIndex(sessionDropdown, sessionIndex);
		click(generateOtp);
		wait.until(ExpectedConditions.visibilityOfElementLocated(otp));
		if (!isSelected(checkbox)) {
			click(checkbox);
		}
		click(loginButton);
	}

	public void searchPerson(String voterCard) {
		for (int attempt = 0; attempt < 2; attempt++) {
			if (isSelected(checkbox)) {
				click(checkbox);
			}
			sendKeys(voterCardNumber, voterCard);
			click(searchButton);
		}
	}

	public boolean logicToSkip(String crop, String gramPanchayat) {
		try {
			return find(already_existing_crop).isDisplayed()
				&& find(already_existing_gram_panchayat).isDisplayed()
				&& find(already_existing_crop).getText().equals(crop)
				&& find(already_existing_gram_panchayat).getText().equals(gramPanchayat);
		} catch (RuntimeException e) {
			return false;
		}
	}

	public void dataEntry(String aadharCard) {
		if (getValue(aadharCardNumber).isBlank()) {
			sendKeys(aadharCardNumber, aadharCard);
		}
		selectByIndex(applicationSource, 1);
	}

	public void farmerDetails(String name, String fatherHusbandName, String relationWithFarmer, String age,
			String gender, String caste, String mobileNum, String farmerCategory, String epicIDImage,
			String aadharImg) {
		sendKeys(nameAsPerEpic, name);
		sendKeys(fatherOrHusbandName, fatherHusbandName);
		selectByValue(relationWithFarmerDropDown, relationWithFarmer);
		selectByValue(ageDropDown, age);
		selectByValue(genderDropDown, gender);
		selectByValue(casteDropDown, caste);
		sendKeys(mobileNumber, mobileNum);
		selectByValue(farmerCategoryDropDown, farmerCategory);
		uploadFile(voterIDUpload, VARIABLES.VOTER_FILE_PATH, epicIDImage);
		uploadFile(aadharIDUpload, VARIABLES.AADHAR_FILE_PATH, aadharImg);
	}

	public void farmerResidentialAddress(String district, String block, String gramPanchayat, String village,
			String pin) {
		selectByVisibleText(farmersResidentialAddressDistrictDropDown, district);
		waitForOptions(farmersResidentialAddressblockDropDown);
		selectByVisibleText(farmersResidentialAddressblockDropDown, block);
		waitForOptions(farmersResidentialAddressgramPanchayatDropDown);
		selectByVisibleText(farmersResidentialAddressgramPanchayatDropDown, gramPanchayat);
		waitForOptions(farmersResidentialAddressvillageDropDown);
		selectByVisibleText(farmersResidentialAddressvillageDropDown, village);
		sendKeys(pinCode, pin);
	}

	public void cropDetailsEntry(String district, String block, String crop, String gpInitial, String mouza,
			String khatianNumber, String plotNumber, String areaInAcre1, String natureOfFarmer, String parchaImg) {
		selectByVisibleText(cropDetailsDistrictDropDown, district);
		waitForOptions(cropDetailsBlockDropDown);
		selectByVisibleText(cropDetailsBlockDropDown, block);
		waitForOptions(cropDetailsCropDropDown);
		selectByVisibleText(cropDetailsCropDropDown, crop);

		if (find(cropDetailsGramPanchayatInitial).isEnabled()) {
			waitForOptions(cropDetailsGramPanchayatInitial);
			selectByVisibleText(cropDetailsGramPanchayatInitial, gpInitial);
		}

		if (find(cropDetailsGramPanchayatFinal).isEnabled()) {
			waitForOptions(cropDetailsGramPanchayatFinal);
			selectByVisibleText(cropDetailsGramPanchayatFinal, gpInitial);
		}

		waitForOptions(cropDetailsMouzaDropDown);
		selectByVisibleText(cropDetailsMouzaDropDown, mouza);
		sendKeys(cropDetailskhaitanNumber, khatianNumber);
		sendKeys(cropDetailsPlotNumber, plotNumber);
		sendKeys(cropDetailsAreaInAcre, areaInAcre1);

		double area = Double.parseDouble(areaInAcre1);
		if (area >= 1) {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

		waitForOptions(cropDetailsNatureOfFarmerDropDown);
		selectByVisibleText(cropDetailsNatureOfFarmerDropDown, natureOfFarmer);
		uploadFile(cropDetailsParchaUpload, VARIABLES.PARCHA_FILE_PATH, parchaImg);
		uploadFile(landDocumentProofUpload, VARIABLES.PARCHA_FILE_PATH, parchaImg);
	}

	public void bankDetailsEntry(String name, String accountNumber, String accountType, String ifscCode) {
		sendKeys(bankDetailsAccountHolderName, name);
		sendKeys(bankDetailsAccountNumber, accountNumber);
		selectByValue(accountTypeDropDown, accountType);
		sendKeys(ifsCode, ifscCode);
		click(bankName);
		uploadFile(bankDocumentProofUpload, VARIABLES.BANK_FILE_PATH, accountNumber);
	}

	public void submitForm() {
		click(submitButton);
	}
}
