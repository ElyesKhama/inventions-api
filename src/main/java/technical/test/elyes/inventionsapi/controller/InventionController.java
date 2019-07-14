package technical.test.elyes.inventionsapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import technical.test.elyes.inventionsapi.dao.InventionsCRUD;
import technical.test.elyes.inventionsapi.model.Invention;

@RestController()
public class InventionController {

	// GET /inventions : Return all inventions
	@RequestMapping(value = "/inventions", method = RequestMethod.GET)
	@ResponseBody
	public List<Invention> getInventions() {
		return InventionsCRUD.getInventions();
	}

	@RequestMapping(value = "/inventions/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Invention getInventionById(@PathVariable("id") int id) {
		return InventionsCRUD.getInventionById(id);
	}

	@RequestMapping(value = "/inventions", method = RequestMethod.POST)
	@ResponseBody
	public String postInvention(@Valid @RequestBody Invention inv) {
		InventionsCRUD.postInvention(inv);
		return null;
	}

}
