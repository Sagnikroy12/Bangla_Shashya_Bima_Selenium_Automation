package com.mainMethod.automation;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Freelance.com.projectSetup.ExcelUtility;
import Freelance.com.projectSetup.VARIABLES;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainRunnerClass {

	private WebDriver driver;
	static WebDriverWait wait;
	private PageBean pom;

	@BeforeSuite
	public void beforeSuite() {

		System.out.println("Enter 1 for Chrome");
		System.out.println("Enter 2 for Mozilla Firefox");

		Scanner sc = new Scanner(System.in);
		int browserChoice = sc.nextInt();

		switch (browserChoice) {
		case 1:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case 2:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}

		pom = new PageBean(driver);
		boolean pageOpened = false;
		int i = 0, retries = 5;
		try {
			driver.get(VARIABLES.SIGN_IN_PAGE_URL);
			pageOpened = true;
		} catch (NoSuchElementException e) {
			while (!pageOpened && i < retries) {
				try {
					driver.navigate().refresh();
					i++;
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
					break;
				}
			}
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		boolean loginExecuted = false, gotoExecuted = false;

		try {
			pom.login(VARIABLES.EMAIL, VARIABLES.PASSWORD, 2, 2);
			loginExecuted = true;
			// Open new tab and navigate
			openNewTab();
			driver.get(VARIABLES.NEW_REGISTRATION_URL);
			gotoExecuted = true;
		} catch (NoSuchElementException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("Error");

			int retryAttempts = 3, retryCount = 0;
			while (retryCount < retryAttempts && (!loginExecuted || !gotoExecuted)) {
				try {
					if (isErrorPage(driver)) {
						System.out.println("Error page detected, retrying....");
						driver.navigate().refresh();
						retryCount++;
						Thread.sleep(2000);
					} else {
						if (!loginExecuted) {
							pom.login(VARIABLES.EMAIL, VARIABLES.PASSWORD, 2, 2);
							loginExecuted = true;
						}
						if (!gotoExecuted) {
							openNewTab();
							driver.get(VARIABLES.NEW_REGISTRATION_URL);
							gotoExecuted = true;
						}
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
					break;
				}
			}
		} finally {
			sc.close();
		}
	}

	private boolean isErrorPage(WebDriver driver) {
		try {
			WebElement errorElement = driver
					.findElement(By.xpath("//h1[contains(text(),'We're sorry, but something went wrong.')]"));
			if (errorElement.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException e) {
		}
		return false;
	}

	private void openNewTab() {
		((JavascriptExecutor) driver).executeScript("window.open('about:blank', '_blank');");
		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	@DataProvider(name = "excelData")
	public void testMainMethod() throws InterruptedException {
		Object[][] data = ExcelUtility.getExcelData();
		for (Object[] row : data) {
			runTests(driver, row);
		}
	}

	@Test(dataProviderClass = ExcelUtility.class, dataProvider = "excelData")
	public void runTests(WebDriver driver, Object[] data) throws InterruptedException {

		String FarmrName = (String) data[3];
		String FathrHusName = (String) data[4];
		String EpicID = (String) data[5];
		String AadharNo = (String) data[6];
		String Age = (String) data[8];
		String Gender = (String) data[9];
		String Caste = (String) data[10];
		String MobNo = (String) data[11];
		String Crop = (String) data[12];
		String District = (String) data[13];
		String Block = (String) data[14];
		String GP = (String) data[15];
		String Mouza1 = (String) data[16];
		String KhatianNo1 = (String) data[18];
		String PlotNo1 = (String) data[19];
		String AreaInsur1 = (String) data[20];
		String NatureFarmr1 = (String) data[21];
		String IFSCode = (String) data[22];
		String AccNo = (String) data[23];
		String Vill = (String) data[24];
		String Pin = (String) data[25];
		String AccType = (String) data[26];
		String Relation = (String) data[27];
		String EpicIDImg = (String) data[29];
		String ParchaImg = (String) data[30];

		boolean error = true;
		while (error) {
			try {
				if (driver.findElement(By.xpath("//h4[contains(text(),'BAJAJ ALLIANZ GIC LTD.')]")).isDisplayed()) {
					error = false;
					break;
				} else {
					driver.navigate().refresh();
					Thread.sleep(5000);
				}
			} catch (NoSuchElementException e) {
				error = true;
			}
		}

		pom.searchPerson(EpicID);
		if (pom.logicToSkip(Crop, GP)) {
			throw new SkipException("Consumer already exists. Skipping test.");
		}
		pom.dataEntry(AadharNo);
		pom.farmerDetails(FarmrName, FathrHusName, Relation, Age, Gender, Caste, MobNo, NatureFarmr1, EpicIDImg,
				AadharNo);
		pom.farmerResidentialAddress(District, Block, GP, Vill, Pin);
		pom.cropDetailsEntry(District, Block, Crop, GP, Mouza1, KhatianNo1, PlotNo1, AreaInsur1, NatureFarmr1,
				ParchaImg);
		pom.bankDetailsEntry(FarmrName, AccNo, AccType, IFSCode);
		pom.submitForm();
	}

	@AfterMethod
	public void pageRefresh() {
		driver.navigate().refresh();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}
