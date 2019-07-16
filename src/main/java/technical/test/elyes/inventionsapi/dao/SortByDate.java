package technical.test.elyes.inventionsapi.dao;

import java.util.Comparator;

import technical.test.elyes.inventionsapi.model.Invention;

//Utility Class to sort the inventions list by date then by name
public class SortByDate implements Comparator<Invention> {

	@Override
	public int compare(Invention o1, Invention o2) {

		//compare date
		int ret = (int) (o1.getDate() - o2.getDate());

		//if same date then compare name
		if (ret == 0) {
			ret = o1.getName().compareTo(o2.getName());
		}
		
		return ret;
	}

}
