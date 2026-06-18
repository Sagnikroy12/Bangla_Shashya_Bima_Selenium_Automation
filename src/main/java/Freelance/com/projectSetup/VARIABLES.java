package Freelance.com.projectSetup;

import java.io.File;

public class VARIABLES {

	public static final String BASE_DIR = System.getProperty("data.dir",
			"D:\\Freelancing\\BSB\\BSB\\Data\\MEMARI-I\\MEMARI-I");

	public static final String EXCEL_FILE_PATH = BASE_DIR + File.separator + "MEMARI - I.xlsx";

	public static final String VOTER_FILE_PATH = BASE_DIR + File.separator + "Voter Image";

	public static final String AADHAR_FILE_PATH = BASE_DIR + File.separator + "Aadhar Image";

	public static final String PARCHA_FILE_PATH = BASE_DIR + File.separator + "Parcha Image";

	public static final String BANK_FILE_PATH = BASE_DIR + File.separator + "Bank Image";

	public static final String SIGN_IN_PAGE_URL = "https://banglashasyabima.wb.gov.in/";

	public static final String NEW_REGISTRATION_URL = "https://insurance.banglashasyabima.net/insurance_applications/new";

	public static final String EMAIL = "debarotimukherjee100@gmail.com";

	public static final String PASSWORD = "123456789";

	public static final String SHEET_NAME = "Sheet1";

}
