package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import up.Main;

public class GoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseJson() {

		String to = "[{\"_id\":375670,\"key\":null,\"name\":\"Kladno\",\"fullName\":\"Kladno, Czech Republic\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Czech Republic\",\"geo_position\":{\"latitude\":50.14734,\"longitude\":14.10285},\"locationId\":7834,\"inEurope\":true,\"countryCode\":\"CZ\",\"coreCountry\":false,\"distance\":null}]";
		String from = "Kladno,location,375670,50.14734,14.10285" + System.getProperty("line.separator");

		assertEquals("equals", from,  Main.parseJson(to));
	
	}

}
