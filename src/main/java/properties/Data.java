package properties;


import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import enums.DriverType;

public class Data {
	
	private Data() {
		
	}

	static ObjectMapper mapper = new ObjectMapper();

	static ObjectReader reader = mapper.readerFor(Data.class);


	public String getAppPath() {
		return getAppPath;
	}


	public DriverType getDeviceType() {
		return deviceType;
	}
	
	public String billAmount() {
		return billAmount;
	}
	
	public String tipPercentage() {
		return tipPercentage;
	}
	public String enterLengthyBillAmount() {
		return lengthyBillAmount;
	}
	public String enterNegativeBillAmount() {
		return negativeBillAmount;
	}
	public String enterBillAmountWithSpce() {
		return billAmountWithSpace;
	}
	public String enterBillAmountWithSpecialChars() {
		return billAmountWithSpecialChars;
	}
		
	@JsonProperty("appPath")
	String getAppPath;

	
	@JsonProperty("deviceType")
	DriverType deviceType;
	
	@JsonProperty("tipPercentage")
	String tipPercentage;
	
	@JsonProperty("billAmount")
	String billAmount;
	
	@JsonProperty("lengthyBillAmount")
	String lengthyBillAmount;
	
	@JsonProperty("negativeBillAmount")
	String negativeBillAmount;
	
	@JsonProperty("billAmountWithSpace")
	String billAmountWithSpace;
	
	@JsonProperty("billAmountWithSpecialChars")
	String billAmountWithSpecialChars;

	public static Data get(String fileName) throws JsonParseException, JsonMappingException, IOException {
		return reader.readValue(new File(fileName));
	}

}
