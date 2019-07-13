package technical.test.elyes.inventionsapi.dao;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

public class ReadJSON {

	public static JSONArray ReadJSONFile() {
		org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
		JSONArray jsonArray = null;

		try {
			Object obj = parser.parse(new FileReader("src/main/resources/static/inventions.json"));

			jsonArray = (JSONArray) obj;

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonArray;

	}
}
