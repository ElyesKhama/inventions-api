package technical.test.elyes.inventionsapi.controller;

import java.util.ArrayList;
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

	// GET /inventions --> Return all inventions
	@RequestMapping(value = "/inventions", method = RequestMethod.GET)
	@ResponseBody
	public List<Invention> getInventions() {
		return InventionsCRUD.getInventions();
	}

	//GET /inventions/:id --> Return invention with specific id
	@RequestMapping(value = "/inventions/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Invention getInventionById(@PathVariable("id") int id) {
		return InventionsCRUD.getInventionById(id);
	}

	//POST /inventions --> Add an invention
	@RequestMapping(value = "/inventions", method = RequestMethod.POST)
	@ResponseBody
	public String postInvention(@Valid @RequestBody Invention inv) {
		InventionsCRUD.postInvention(inv);
		return null;
	}

	//DELETE /inventions/:id --> Delete a specific invention
	@RequestMapping(value = "/inventions/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteInvention(@PathVariable("id") int id) {
		InventionsCRUD.deleteInventionById(id);
		return null;
	}

	//PUT /inventions/init --> Replace current inventions list
	@RequestMapping(value = "/inventions/init", method = RequestMethod.PUT)
	@ResponseBody
	public String putInvention(@Valid @RequestBody ArrayList<Invention> listInv) {
		InventionsCRUD.putInvention(listInv);
		return null;
	}

	// GET /inventions/tag/:tag --> Get all inventions containing a specific tag
	@RequestMapping(value = "/inventions/tag/{tag}", method = RequestMethod.GET)
	public List<Invention> getInventionsByTag(@PathVariable("tag") String tag) {
		return InventionsCRUD.getInventionsByTag(tag);
	}

	//GET /inventions/:id/discovery --> Get the invention with most common points (tags)
	@RequestMapping(value = "/inventions/{id}/discovery", method = RequestMethod.GET)
	public Invention getInventionWithCommonPoints(@PathVariable("id") int id) {
		Invention invention = InventionsCRUD.getInventionById(id);
		if(invention.getTags() != null) {
			return InventionsCRUD.getInventionWithCommonPoints(invention);
		}
		
		return null;
	}
}
