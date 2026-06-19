package Freelance.com.projectSetup;

import java.io.File;

/**
 * Configuration constants.
 * Resolves credentials from system properties or environment variables.
 * Falls back to safe defaults to avoid CI static initializer failures.
 */
public class VARIABLES {

	public static final String BASE_DIR = System.getProperty("data.dir",
			System.getenv().getOrDefault("BSB_DATA_DIR", "D:\\Freelancing\\BSB\\BSB\\Data\\MEMARI-I\\MEMARI-I"));

	public static final String EXCEL_FILE_PATH = BASE_DIR + File.separator + "MEMARI - I.xlsx";

	public static final String VOTER_FILE_PATH = BASE_DIR + File.separator + "Voter Image";

	public static final String AADHAR_FILE_PATH = BASE_DIR + File.separator + "Aadhar Image";

	public static final String PARCHA_FILE_PATH = BASE_DIR + File.separator + "Parcha Image";

	public static final String BANK_FILE_PATH = BASE_DIR + File.separator + "Bank Image";

	public static final String SIGN_IN_PAGE_URL = "https://banglashasyabima.wb.gov.in/";

	public static final String NEW_REGISTRATION_URL = "https://insurance.banglashasyabima.net/insurance_applications/new";

	public static final String SHEET_NAME = "Sheet1";

	// Credentials: resolve from system properties first, then environment variables.
	// Default credentials provided by user (used when system props/env are not set)
	private static final String DEFAULT_EMAIL = "sagnik12roy";
	private static final String DEFAULT_PASSWORD = "password123";

	public static final String EMAIL = resolveCredential("bsb.email", "BSB_EMAIL", DEFAULT_EMAIL);
	public static final String PASSWORD = resolveCredential("bsb.password", "BSB_PASSWORD", DEFAULT_PASSWORD);

	private static String resolveCredential(String sysProp, String envVar, String fallback) {
		String v = System.getProperty(sysProp);
		if (v != null && !v.isBlank()) {
			return v;
		}
		v = System.getenv(envVar);
		if (v != null && !v.isBlank()) {
			return v;
		}
		// Return fallback (empty) to avoid ExceptionInInitializerError in CI.
		return fallback;
	}

}
