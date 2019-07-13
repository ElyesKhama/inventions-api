package technical.test.elyes.inventionsapi.dao;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import technical.test.elyes.inventionsapi.model.Invention;

public class InventionsCRUD {
	
	public static ArrayList<Invention> getInventions(){
		JSONArray jsonArray = ReadJSON.ReadJSONFile();
		return jsonArray;
	}
}
