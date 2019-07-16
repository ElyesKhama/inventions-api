package technical.test.elyes.inventionsapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import technical.test.elyes.inventionsapi.dao.InventionsCRUD;
import technical.test.elyes.inventionsapi.exception.WrongPostBodyException;
import technical.test.elyes.inventionsapi.model.Invention;

@RestController()
public class InventionController {

	// GET /inventions --> Return all inventions
	@RequestMapping(value = "/inventions", method = RequestMethod.GET)
	@ResponseBody
	public List<Invention> getInventions() {
		return InventionsCRUD.getInventions();
	}

	// GET /inventions/:id --> Return invention with specific id
	@RequestMapping(value = "/inventions/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Invention getInventionById(@PathVariable("id") int id) {
		return InventionsCRUD.getInventionById(id);
	}

	// POST /inventions --> Add an invention
	@RequestMapping(value = "/inventions", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED) // 201
	public ArrayList<Invention> postInvention(@Valid @RequestBody Invention inv) {
		// Ensure that the body contains at a name
		if (inv.getName() == null)
			throw new WrongPostBodyException();
		InventionsCRUD.postInvention(inv);
		return InventionsCRUD.getInventions();
	}

	// DELETE /inventions/:id --> Delete a specific invention
	@RequestMapping(value = "/inventions/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ArrayList<Invention> deleteInvention(@PathVariable("id") int id) {
		InventionsCRUD.deleteInventionById(id);
		return InventionsCRUD.getInventions();
	}

	// PUT /inventions/init --> Replace current inventions list
	@RequestMapping(value = "/inventions/init", method = RequestMethod.PUT)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED) // 201
	public ArrayList<Invention> putInvention(@Valid @RequestBody ArrayList<Invention> listInv) {
		InventionsCRUD.putInvention(listInv);
		return InventionsCRUD.getInventions();
	}

	// GET /inventions/tag/:tag --> Get all inventions containing a specific tag
	@RequestMapping(value = "/inventions/tag/{tag}", method = RequestMethod.GET)
	public List<Invention> getInventionsByTag(@PathVariable("tag") String tag) {
		return InventionsCRUD.getInventionsByTag(tag);
	}

	// GET /inventions/:id/discovery --> Get the invention with most common points
	// (tags)
	@RequestMapping(value = "/inventions/{id}/discovery", method = RequestMethod.GET)
	public Invention getInventionWithCommonPoints(@PathVariable("id") int id) {
		Invention invention = InventionsCRUD.getInventionById(id);
		if (invention == null)
			return null;
		if (invention.getTags() != null) {
			return InventionsCRUD.getInventionWithCommonPoints(invention);
		}

		return null;
	}
}
