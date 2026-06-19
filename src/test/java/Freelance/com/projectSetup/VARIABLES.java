package Freelance.com.projectSetup;

import java.io.File;

public class VARIABLES {

	/**
	 * Base directory for all test data files.
	 * Resolution order:
	 *   1. -Ddata.dir JVM system property
	 *   2. BSB_DATA_DIR environment variable
	 *   3. Local developer fallback
	 */
	public static final String BASE_DIR = resolveBaseDir();

	private static String resolveBaseDir() {
		String sysProp = System.getProperty("data.dir");
		if (sysProp != null && !sysProp.isBlank()) return sysProp;

		String envVar = System.getenv("BSB_DATA_DIR");
		if (envVar != null && !envVar.isBlank()) return envVar;

		return "D:\\Freelancing\\BSB\\BSB\\Data\\MEMARI-I\\MEMARI-I";
	}

	public static final String EXCEL_FILE_PATH = BASE_DIR + File.separator + "MEMARI - I.xlsx";

	public static final String VOTER_FILE_PATH  = BASE_DIR + File.separator + "Voter Image";
	public static final String AADHAR_FILE_PATH = BASE_DIR + File.separator + "Aadhar Image";
	public static final String PARCHA_FILE_PATH = BASE_DIR + File.separator + "Parcha Image";
	public static final String BANK_FILE_PATH   = BASE_DIR + File.separator + "Bank Image";

	public static final String SIGN_IN_PAGE_URL     = "https://banglashasyabima.wb.gov.in/";
	public static final String NEW_REGISTRATION_URL = "https://insurance.banglashasyabima.net/insurance_applications/new";

	/**
	 * Credentials resolution order:
	 *   1. -Dbsb.email / -Dbsb.password JVM system properties
	 *   2. BSB_EMAIL / BSB_PASSWORD environment variables
	 */
	public static final String EMAIL    = resolveCredential("bsb.email",    "BSB_EMAIL");
	public static final String PASSWORD = resolveCredential("bsb.password", "BSB_PASSWORD");

	private static String resolveCredential(String sysPropKey, String envVarKey) {
		String sysProp = System.getProperty(sysPropKey);
		if (sysProp != null && !sysProp.isBlank()) return sysProp;

		String envVar = System.getenv(envVarKey);
		if (envVar != null && !envVar.isBlank()) return envVar;

		throw new IllegalStateException(
			"Missing credential. Provide -" + sysPropKey + " or set the " + envVarKey + " environment variable.");
	}

	public static final String SHEET_NAME = "Sheet1";
}
