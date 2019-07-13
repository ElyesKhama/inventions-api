package technical.test.elyes.inventionsapi.model;

import java.util.ArrayList;

public class Invention {

	private long id;
	private int date;
	private String name;
	private String inventor;
	private String origine;
	private String site;
	private ArrayList<String> tags;

	public Invention(long id, int date, String name, String inventor, String origine, String site,
			ArrayList<String> tags) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.inventor = inventor;
		this.origine = origine;
		this.site = site;
		this.tags = tags;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInventor() {
		return inventor;
	}

	public void setInventor(String inventor) {
		this.inventor = inventor;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

}
