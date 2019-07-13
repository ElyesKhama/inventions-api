package technical.test.elyes.inventionsapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import technical.test.elyes.inventionsapi.dao.InventionsCRUD;
import technical.test.elyes.inventionsapi.model.Invention;

@RestController("/inventions")
public class InventionController {

	//GET /inventions : Return all inventions
	@GetMapping()
	public List<Invention> getInventions() {
		return InventionsCRUD.getInventions();
	}
	
}
