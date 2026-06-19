package Freelance.com.projectSetup;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VARIABLESTest {

    @Test
    public void constantsShouldBeNonEmpty() {
        Assert.assertNotNull(VARIABLES.BASE_DIR, "BASE_DIR should not be null");
        Assert.assertFalse(VARIABLES.BASE_DIR.isBlank(), "BASE_DIR should not be blank");
        Assert.assertNotNull(VARIABLES.EXCEL_FILE_PATH);
        Assert.assertNotNull(VARIABLES.VOTER_FILE_PATH);
        Assert.assertNotNull(VARIABLES.EMAIL);
        Assert.assertTrue(VARIABLES.EMAIL.contains("@"), "EMAIL should contain @");
    }
}
