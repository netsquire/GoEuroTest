package up;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import airport.info.AirportInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
 
public class Main {
	static String entry = "http://api.goeuro.com/api/v2/position/suggest/en/";
	static String fileName = "airport_info.csv";
	private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = System.getProperty("line.separator");

	
	public static void main(String[] args) {
		String airport =  "KLADNO"; //  args[0];
		// "MOSCOW", "KLADNO", "POZNAN"

	  try {
		URL url = new URL(entry + airport);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		String line = "";
		String jsonResponse = "";
		while ((line = reader.readLine()) != null) {
			jsonResponse += line;
		}
		connection.disconnect();
		String parsedJson = Main.parseJson(jsonResponse);		
		FileWriter writer = new FileWriter(fileName);
		writer.append(parsedJson).flush();
	    writer.close();
	  } catch (IOException e ) { 
		  System.out.println("Something wrong, check Connection... \n");
		  e.printStackTrace();  
		  } 
	  System.out.println(" - done.");
	}
	
	public static String parseJson(String json) {	
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
	    AirportInfo list[] = new AirportInfo[0];
	    list = (AirportInfo[]) gson.fromJson(json, list.getClass());
	    System.out.print( "Number of airports: " + list.length );	    
	    StringBuffer writer = new StringBuffer();
	    
		for( AirportInfo jsone : list) {
		    	writer.append(jsone.getName());
		    	writer.append(COMMA_DELIMITER);
		    	writer.append(jsone.getType());
		    	writer.append(COMMA_DELIMITER);
		    	writer.append(jsone.get_id());
		    	writer.append(COMMA_DELIMITER);
		    	writer.append(jsone.getGeoPosition().getLatitude());
		    	writer.append(COMMA_DELIMITER);
		    	writer.append(jsone.getGeoPosition().getLongitude());
		    	writer.append(NEW_LINE_SEPARATOR);

		    	}
		return writer.toString();
	   }
	    
	}
