package technical.test.elyes.inventionsapi.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//Utility class to read the JSON stored in resources
public class ReadJSON {

	final static String FILE_LOCATION = "src/main/resources/static/inventions.json";

	public static JSONArray ReadJSONFile() {
		org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
		JSONArray jsonArray = null;

		try {			
			InputStream in = ReadJSON.class.getResourceAsStream("/static/inventions.json");
			Object obj = parser.parse(new InputStreamReader(in));
			jsonArray = (JSONArray) obj;

			System.out.println(jsonArray.toString());
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return jsonArray;

	}
}
