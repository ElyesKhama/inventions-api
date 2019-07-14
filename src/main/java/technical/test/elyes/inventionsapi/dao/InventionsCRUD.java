package technical.test.elyes.inventionsapi.dao;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import technical.test.elyes.inventionsapi.model.Invention;

public class InventionsCRUD {

	static ArrayList<Invention> listInventions = buildListInvention();

	public static ArrayList<Invention> getInventions() {

		return listInventions;
	}

	public static Invention getInventionById(int id) {

		Invention inv = null;

		for (int i = 0; i < listInventions.size(); i++) {
			inv = listInventions.get(i);
			if (inv.getId() == id)
				return inv;
		}

		return null;
	}

	public static void postInvention(Invention inv) {
		listInventions.add(inv);
		// sort the list by date
		listInventions.sort(new SortByDate());
	}

	public static void deleteInventionById(int id) {

		for (int i = 0; i < listInventions.size(); i++) {
			Invention inv = listInventions.get(i);
			if (inv.getId() == id)
				listInventions.remove(i);
		}
		
	}

	public static ArrayList<Invention> buildListInvention() {
		ArrayList<Invention> inventionsList = new ArrayList<Invention>();

		JSONArray jsonArray = ReadJSON.ReadJSONFile();

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject obj = (JSONObject) jsonArray.get(i);
			Invention invention = new Invention();
			invention.setId(i);
			invention.setDate((long) obj.get("date"));
			invention.setInventor((String) obj.get("inventor"));
			invention.setName((String) obj.get("name"));
			invention.setOrigine((String) obj.get("origine"));
			invention.setSite((String) obj.get("site"));
			invention.setTags((ArrayList<String>) obj.get("tags"));

			inventionsList.add(invention);
		}

		// sort the list by date
		inventionsList.sort(new SortByDate());

		return inventionsList;
	}

}
