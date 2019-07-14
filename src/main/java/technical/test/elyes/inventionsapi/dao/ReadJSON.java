package technical.test.elyes.inventionsapi.dao;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

//Utility class to read the JSON stored in resources
public class ReadJSON {
	final static String FILE_LOCATION = "src/main/resources/static/inventions.json";

	public static JSONArray ReadJSONFile() {
		org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
		JSONArray jsonArray = null;

		try {
			Object obj = parser.parse(new FileReader(FILE_LOCATION));

			jsonArray = (JSONArray) obj;

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return jsonArray;

	}
}
