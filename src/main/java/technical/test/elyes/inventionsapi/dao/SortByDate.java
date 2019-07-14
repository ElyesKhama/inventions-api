package technical.test.elyes.inventionsapi.dao;

import java.util.Comparator;

import technical.test.elyes.inventionsapi.model.Invention;

public class SortByDate implements Comparator<Invention> {

	@Override
	public int compare(Invention o1, Invention o2) {

		int ret = (int) (o1.getDate() - o2.getDate());

		if (ret == 0) {
			ret = o1.getName().compareTo(o2.getName());
		}
		
		return ret;
	}

}
