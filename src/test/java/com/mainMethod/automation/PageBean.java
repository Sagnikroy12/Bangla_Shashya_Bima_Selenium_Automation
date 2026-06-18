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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Freelance.com.projectSetup.VARIABLES;

public class PageBean {

	private WebDriver driver;
	private WebDriverWait wait;

	public PageBean(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	/*---------------------------------- Login Page ------------------------------------------------*/

	@FindBy(id = "inputUserName")
	private WebElement email;

	@FindBy(id = "inputPassword")
	private WebElement passWord;

	@FindBy(id = "insurance_user_season")
	private WebElement seasonDropdown;

	@FindBy(id = "user_session")
	private WebElement sessionDropdown;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkbox;

	@FindBy(id = "generate_otp")
	private WebElement generateOtp;

	@FindBy(xpath = "//button[@class=\"btn btn-group btn-default btn-animated btn_login\"]")
	private WebElement loginButton;

	@FindBy(id = "otp")
	private WebElement otp;

	@FindBy(xpath = "/html/body/div/div/h1")
	private WebElement errorScreen;

	/*---------------------------------------------- Form page ---------------------------------------*/
	@FindBy(xpath = "//*[@id= 'navbar-collapse-1']/div[2]/ul/li[3]/a")
	private WebElement listToGo;

	@FindBy(xpath = "//*[@id=\"navbar-collapse-1\"]/div[2]/ul/li[3]/ul/li[1]/a")
	private WebElement list;

	/*------------------------------------------- Search section ---------------------------------------*/
	@FindBy(id = "insure_voter_id")
	private WebElement voterCardNumber;

	@FindBy(id = "insur_search")
	private WebElement searchButton;

	@FindBy(xpath = "//tbody[@id='tbodycrop']/tr/td[2]")
	private WebElement already_existing_crop;

	@FindBy(xpath = "//tbody[@id='tbodycrop']/tr/td[5]")
	private WebElement already_existing_gram_panchayat;

	@FindBy(id = "insure_aadhar_no")
	private WebElement aadharCardNumber;

	@FindBy(id = "insure_app_type")
	private WebElement applicationSource;

	/*------------------------------------- Farmer details section ---------------------------------------*/
	@FindBy(id = "insure_name")
	private WebElement nameAsPerEpic;

	@FindBy(id = "insure_f_name")
	private WebElement fatherOrHusbandName;

	@FindBy(id = "insure_f_relation")
	private WebElement relationWithFarmerDropDown;

	@FindBy(id = "insure_age")
	private WebElement ageDropDown;

	@FindBy(id = "insure_gender")
	private WebElement genderDropDown;

	@FindBy(id = "insure_caste")
	private WebElement casteDropDown;

	@FindBy(id = "insure_mobile_no")
	private WebElement mobileNumber;

	@FindBy(id = "insure_f_category")
	private WebElement farmerCategoryDropDown;

	@FindBy(id = "insure_id_proof")
	private WebElement voterIDUpload;

	@FindBy(id = "insure_aadhar_doc")
	private WebElement aadharIDUpload;

	/*-------------------------------- Farmers Residential address section ---------------------------------*/

	@FindBy(id = "f_district")
	private WebElement farmersResidentialAddressDistrictDropDown;

	@FindBy(id = "block_id")
	private WebElement farmersResidentialAddressblockDropDown;

	@FindBy(id = "gp_id")
	private WebElement farmersResidentialAddressgramPanchayatDropDown;

	@FindBy(id = "vill_id")
	private WebElement farmersResidentialAddressvillageDropDown;

	@FindBy(id = "pin_code")
	private WebElement pinCode;

	/*------------------------------------- Crop Details Section --------------------------------------------*/

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_district_id")
	private WebElement cropDetailsDistrictDropDown;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_block_id")
	private WebElement cropDetailsBlockDropDown;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_crop_id")
	private WebElement cropDetailsCropDropDown;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_gram_panchayat_id")
	private WebElement cropDetailsGramPanchayatInitial;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_gram_panchayat_id")
	private WebElement cropDetailsGramPanchayatFinal;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_mouza_id")
	private WebElement cropDetailsMouzaDropDown;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_khatian_no")
	private WebElement cropDetailskhaitanNumber;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_plot_no")
	private WebElement cropDetailsPlotNumber;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_inc_land_in_acer")
	private WebElement cropDetailsAreaInAcre;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_area_insured")
	private WebElement cropDetailsAreaInDecimal;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_nature_of_farmer")
	private WebElement cropDetailsNatureOfFarmerDropDown;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_form18_document")
	private WebElement cropDetailsNonOwnerCultivatorCertificateUpload;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_insurance_lands_attributes_0_parcha_document")
	private WebElement cropDetailsParchaUpload;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_land_document")
	private WebElement landDocumentProofUpload;

	/*--------------------------------- Bank Details Section ---------------------------------------*/
	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_account_holder_name")
	private WebElement bankDetailsAccountHolderName;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_account_number")
	private WebElement bankDetailsAccountNumber;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_account_type")
	private WebElement accountTypeDropDown;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_account_ifsc")
	private WebElement ifsCode;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_bank_name")
	private WebElement bankName;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_branch_name")
	private WebElement branchName;

	@FindBy(id = "insurance_farmer_insurance_applications_attributes_0_bank_document")
	private WebElement bankDocumentProofUpload;

	@FindBy(id = "before_insure_submit")
	private WebElement submitButton;

	/*-------------------------------------------------------------*/
	public void gotoPage() {
		Actions action = new Actions(driver);
		action.moveToElement(listToGo).perform();
		list.click();
	}

	/*-------------------------------------------------------------*/

	public void login(String s1, String s2, int index1, int index2) throws InterruptedException {
		email.sendKeys(s1);
		passWord.sendKeys(s2);

		Select dropdown1 = new Select(seasonDropdown);
		dropdown1.selectByIndex(index1);

		wait.until(driver1 -> {
			Select dropDown2 = new Select(sessionDropdown);
			return dropDown2.getOptions().size() > 1;
		});
		Select dropdown2 = new Select(sessionDropdown);
		dropdown2.selectByIndex(index2);
		Thread.sleep(2000);
		generateOtp.click();
		Thread.sleep(20000);
		if (!checkbox.isSelected()) {
			checkbox.click();
		}

		loginButton.click();

	}

	/*-------------------------------------------- Search section ----------------------------------------*/

	public void searchPerson(String voterCard) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("insure_voter_id")));
		int i = 0;
		while (i < 2) {
			if (checkbox.isSelected()) {
				checkbox.click();
			}
			voterCardNumber.clear(); // Clear the field
			voterCardNumber.sendKeys(voterCard);
			searchButton.click();
			i++;
		}
	}

	/*-------------------------------- Logic to skip ----------------------------------------*/
	public boolean logicToSkip(String crop, String gramPanchayat) {
		try {
			// Wait for the elements to be visible or available
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			if (already_existing_crop.isDisplayed() && already_existing_gram_panchayat.isDisplayed()) {
				if (already_existing_crop.getText().equals(crop)
						&& already_existing_gram_panchayat.getText().equals(gramPanchayat)) {
					return true; // Skip test if consumer exists
				}
			}
		} catch (NoSuchElementException e) {
			// If elements are not found, simply return false and continue with the rest of
			// the test
		} catch (StaleElementReferenceException e) {

		}
		return false; // Return false if the skip condition is not met
	}

	/*-------------------------------------- Aadhar card entry ----------------------------------------*/
	public void dataEntry(String aadharCard) {
		if (aadharCardNumber.getText().equals("")) {
			aadharCardNumber.sendKeys(aadharCard);
		}
		/*---------------------------- Application source DropDown ----------------------------------*/
		wait.until(ExpectedConditions.elementToBeClickable(applicationSource));
		Select dropDown = new Select(applicationSource);
		dropDown.selectByIndex(1);
	}

	/*----------------------------------------- Farmer Details section --------------------------------------*/
	public void farmerDetails(String name, String fatherHusbandName, String relationWithFarmer, String age,
			String gender, String caste, String mobileNum, String farmerCategory, String epicIDImage,
			String aadharImg) {

		wait.until(ExpectedConditions.elementToBeClickable(nameAsPerEpic));
		nameAsPerEpic.sendKeys(name);
		fatherOrHusbandName.sendKeys(fatherHusbandName);
		/*------------------------------- Relation with Farmer DropDown -----------------------------*/
		Select dropdown1 = new Select(relationWithFarmerDropDown);
		dropdown1.selectByValue(relationWithFarmer);
		/*---------------------------------- Age DropDown --------------------------------------------*/
		Select dropDown2 = new Select(ageDropDown);
		dropDown2.selectByValue(age);
		/*---------------------------------- Gender DropDown -----------------------------------------*/
		Select dropDown3 = new Select(genderDropDown);
		dropDown3.selectByValue(gender);

		/*--------------------------------- Caste DropDown -------------------------------------------*/
		Select dropDown4 = new Select(casteDropDown);
		dropDown4.selectByValue(caste);

		mobileNumber.sendKeys(mobileNum);

		/* Farmer Category DropDown */
		Select dropDown5 = new Select(farmerCategoryDropDown);
		dropDown5.selectByValue(farmerCategory);

		try {
			File file1 = new File(VARIABLES.VOTER_FILE_PATH + "\\" + epicIDImage + ".jpg");
			if (!file1.exists()) {
				throw new FileNotFoundException("File not found at: " + file1.getAbsolutePath());
			}
			voterIDUpload.sendKeys(file1.getAbsolutePath());
		} catch (FileNotFoundException e) {
			System.err.println("Error: The specified file was not found.");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("An error occurred during file upload.");
			e.printStackTrace();
		}
		try {
			File file2 = new File(VARIABLES.AADHAR_FILE_PATH + "\\" + aadharImg + ".jpg");
			if (!file2.exists()) {
				throw new FileNotFoundException("File not found at: " + file2.getAbsolutePath());
			}
			aadharIDUpload.sendKeys(file2.getAbsolutePath());
		} catch (FileNotFoundException e) {
			System.err.println("Error: The specified file was not found.");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("An error occurred during file upload.");
			e.printStackTrace();
		}
	}

	/*---------------------------- Farmers Residential address section ---------------------------------*/
	public void farmerResidentialAddress(String district, String block, String gramPanchayat, String village,
			String pin) throws InterruptedException {

		/*-------------------------------- District DropDown -------------------------------------*/
		Select dropDown1 = new Select(farmersResidentialAddressDistrictDropDown);
		dropDown1.selectByVisibleText(district);

		/*-------------------------------- Block DropDown ----------------------------------------*/
		wait.until(driver1 -> {
			Select dropDown2 = new Select(farmersResidentialAddressblockDropDown);
			return dropDown2.getOptions().size() > 1;
		});
		Select dropDown2 = new Select(farmersResidentialAddressblockDropDown);
		dropDown2.selectByVisibleText(block);

		/*-------------------------- Gram Panchayat DropDown Intial ---------------------------------*/
		wait.until(driver1 -> {
			Select dropDown3 = new Select(farmersResidentialAddressgramPanchayatDropDown);
			return dropDown3.getOptions().size() > 1;
		});
		Select dropDown3 = new Select(farmersResidentialAddressgramPanchayatDropDown);
		dropDown3.selectByVisibleText(gramPanchayat);

		/*---------------------------------- Village DropDown -----------------------------------------*/
		wait.until(driver1 -> {
			Select dropDown4 = new Select(farmersResidentialAddressvillageDropDown);
			return dropDown4.getOptions().size() > 1;
		});
		Select dropDown4 = new Select(farmersResidentialAddressvillageDropDown);
		dropDown4.selectByVisibleText(village);

		pinCode.sendKeys(pin);
	}

	/*--------------------------------------- Crop details entry ----------------------------------------*/
	public void cropDetailsEntry(String district, String block, String crop, String gpInitial, String mouza,
			String khatianNumber, String plotNumber, String areaInAcre1, String natureOfFarmer, String parchaImg)
			throws InterruptedException {

		/*----------------------------- District Dropdown ---------------------------------*/
		Select dropDown1 = new Select(cropDetailsDistrictDropDown);
		dropDown1.selectByVisibleText(district);

		/*--------------------------------- Block Dropdown -------------------------------------*/
		wait.until(driver1 -> {
			Select dropDown2 = new Select(cropDetailsBlockDropDown);
			return dropDown2.getOptions().size() > 1;
		});
		Select dropDown2 = new Select(cropDetailsBlockDropDown);
		dropDown2.selectByVisibleText(block);

		/*---------------------------------- Crop Dropdown ------------------------------------------*/
		wait.until(driver1 -> {
			Select dropDown3 = new Select(cropDetailsCropDropDown);
			return dropDown3.getOptions().size() > 1;
		});
		Select dropDown3 = new Select(cropDetailsCropDropDown);
		dropDown3.selectByVisibleText(crop);

		/*-------------------------------- Gram Panchayat Dropdown 1 -----------------------------------*/
		if (cropDetailsGramPanchayatInitial.isEnabled()) {
			wait.until(driver1 -> {
				Select dropDown4 = new Select(cropDetailsGramPanchayatInitial);
				return dropDown4.getOptions().size() > 1;
			});
			Select dropDown4 = new Select(cropDetailsGramPanchayatInitial);
			dropDown4.selectByVisibleText(gpInitial);
		}

		/*-------------------------------- Gram Panchayat Dropdown 2 -----------------------------------*/
		if (cropDetailsGramPanchayatFinal.isEnabled()) {
			wait.until(driver1 -> {
				Select dropDown5 = new Select(cropDetailsGramPanchayatFinal);
				return dropDown5.getOptions().size() > 1;
			});
			Select dropDown5 = new Select(cropDetailsGramPanchayatFinal);
			dropDown5.selectByVisibleText(gpInitial);
		}

		/*-------------------------------------- Mouza Dropdown ------------------------------------------*/
		wait.until(driver1 -> {
			Select dropDown6 = new Select(cropDetailsMouzaDropDown);
			return dropDown6.getOptions().size() > 1;
		});
		Select dropDown6 = new Select(cropDetailsMouzaDropDown);
		dropDown6.selectByVisibleText(mouza);

		cropDetailskhaitanNumber.sendKeys(khatianNumber);

		cropDetailsPlotNumber.sendKeys(plotNumber);

		cropDetailsAreaInAcre.sendKeys(areaInAcre1);

		cropDetailsNatureOfFarmerDropDown.click();
		Double area = Double.parseDouble(areaInAcre1);
		if (area >= 1) {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

		/*--------------------------- Nature of Farmer Dropdown ----------------------------*/
		wait.until(driver1 -> {
			Select dropDown7 = new Select(cropDetailsNatureOfFarmerDropDown);
			return dropDown7.getOptions().size() > 1;
		});
		Select dropDown7 = new Select(cropDetailsNatureOfFarmerDropDown);
		dropDown7.selectByVisibleText(natureOfFarmer);

		/* logic to upload Non Owner Cultivator Certificate and Parcha document */
		try {
			// Verify if the file exists
			File file = new File(VARIABLES.PARCHA_FILE_PATH + "\\" + parchaImg + ".jpg");
			if (!file.exists()) {
				throw new FileNotFoundException("File not found at: " + file.getAbsolutePath());
			}

			// Upload the file if it exists
			cropDetailsParchaUpload.sendKeys(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			System.err.println("Error: The specified file was not found.");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("An error occurred during file upload.");
			e.printStackTrace();
		}

		try {
			// Verify if the file exists
			File file = new File(VARIABLES.PARCHA_FILE_PATH + "\\" + parchaImg + ".jpg");
			if (!file.exists()) {
				throw new FileNotFoundException("File not found at: " + file.getAbsolutePath());
			}

			// Upload the file if it exists
			landDocumentProofUpload.sendKeys(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			System.err.println("Error: The specified file was not found.");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("An error occurred during file upload.");
			e.printStackTrace();
		}

	}

	/*----------------------------------------- Bank details entry ------------------------------------------------*/
	public void bankDetailsEntry(String name, String accountNumber, String accountType, String ifscCode)
			throws InterruptedException {
		bankDetailsAccountHolderName.sendKeys(name);
		bankDetailsAccountNumber.sendKeys(accountNumber);
		Select dropDown1 = new Select(accountTypeDropDown);
		dropDown1.selectByValue(accountType);
		ifsCode.sendKeys(ifscCode);
		bankName.click();

		Thread.sleep(500);
		/*---------------------------------- Logic to upload bank passbook image --------------------------------*/
		bankDocumentProofUpload.sendKeys(VARIABLES.BANK_FILE_PATH + "\\" + accountNumber + ".jpg");
	}

	/*------------------------------------------------ Submit form -----------------------------------------------*/
	public void submitForm() {
		submitButton.click();
	}
}
