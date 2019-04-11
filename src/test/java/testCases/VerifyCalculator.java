package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pageObjects.HomePage;

public class VerifyCalculator  extends BaseTest{

	HomePage home ;
	
	@Parameters({ "userDataFile" })
	@BeforeTest
	public void init(String userDataFile) throws JsonParseException, JsonMappingException, IOException {
		try {
			super.setup(userDataFile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		home = new HomePage(driver, userDataFile);
	}

	@Test(priority=0)
	public void testCalculation() throws Exception {		
	home.verifyHomePageElements();
	home.caculateTip();	
	}
	
	@Test(priority=1)
	public void testLengthyBillAmount() throws Exception {		
	home.verifyTextBoxWithLengthyInput();
	}
	@Test(priority=2)
	public void testNegativeBillAmount() throws Exception {		
	home.verifyTextBoxWithNegativeBillAmount();
	}
	
	@Test(priority=2)
	public void testSpecialCharsBillAmount() throws Exception {		
	home.verifyTextBoxWithSpecialChars();
	}
	
	
}
