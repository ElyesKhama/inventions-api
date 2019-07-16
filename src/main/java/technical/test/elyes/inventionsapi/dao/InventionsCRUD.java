package technical.test.elyes.inventionsapi.dao;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import technical.test.elyes.inventionsapi.model.Invention;

public class InventionsCRUD {

	/*
	 * Load the inventionList from the JSON when building the class (cause no
	 * persistance needed)
	 */

	static ArrayList<Invention> listInventions = buildListInventions();
	static int lastId;

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
		inv.setId(lastId++);
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

	public static void putInvention(ArrayList<Invention> listInv) {
		listInventions = listInv;
	}

	public static ArrayList<Invention> getInventionsByTag(String tag) {
		ArrayList<Invention> listInv = new ArrayList<Invention>();

		for (int i = 0; i < listInventions.size(); i++) {
			Invention inv = listInventions.get(i);
			if (inv.getTags() != null) {
				if (inv.getTags().contains(tag)) {
					listInv.add(inv);
				}
			}
		}

		return listInv;
	}

	public static Invention getInventionWithCommonPoints(Invention inv) {
		int counter = 0;
		int counterTmp = 0;
		Invention inventionReturn = null;

		for (int i = 0; i < listInventions.size(); i++) {
			Invention invloop = listInventions.get(i);
			if (invloop.getTags() != null && invloop.getName() != inv.getName()) {
				counterTmp = getNumberOfCommonTags(invloop, inv);
				if (counterTmp > counter) {
					inventionReturn = invloop;
					counter = counterTmp;
				}
			}
		}

		return inventionReturn;
	}

	public static int getNumberOfCommonTags(Invention inv1, Invention inv2) {
		int counter = 0;

		ArrayList<String> listTags1 = inv1.getTags();
		ArrayList<String> listTags2 = inv2.getTags();

		for (int i = 0; i < listTags1.size(); i++) {
			if (listTags2.contains(listTags1.get(i))) {
				counter++;
			}
		}

		return counter;
	}

	public static ArrayList<Invention> buildListInventions() {
		ArrayList<Invention> inventionsList = new ArrayList<Invention>();

		JSONArray jsonArray = ReadJSON.ReadJSONFile();

		int i;
		for (i = 0; i < jsonArray.size(); i++) {
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

		// store the number of inventions
		lastId = i;

		// sort the list by date
		inventionsList.sort(new SortByDate());

		return inventionsList;
	}

}
