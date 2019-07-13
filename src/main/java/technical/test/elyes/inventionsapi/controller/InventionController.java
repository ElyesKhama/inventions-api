package technical.test.elyes.inventionsapi.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import technical.test.elyes.inventionsapi.dao.InventionsCRUD;
import technical.test.elyes.inventionsapi.model.Invention;

@RestController()
public class InventionController {

	// GET /inventions : Return all inventions
	@RequestMapping(value = "/inventions", method = RequestMethod.GET)
	public List<Invention> getInventions() {
		return InventionsCRUD.getInventions();
	}

	@RequestMapping(value = "/inventions/{id}", method = RequestMethod.GET)
	public Invention getInventionById(@PathVariable("id") int id) {
		return InventionsCRUD.getInventionById(id);
	}

}
