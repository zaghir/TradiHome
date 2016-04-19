package com.zaghir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaghir.entites.TypePersonne;
import com.zaghir.metier.TypePersonneMetier;

@RestController
public class TypePersonneRestService {
	@Autowired
	private TypePersonneMetier typePersonneMetier;

	@RequestMapping(value = "/typePersonnes", method = RequestMethod.POST)
	@ResponseBody
	public TypePersonne saveTypePersonne(@RequestBody TypePersonne tp) {
		return typePersonneMetier.saveTypePersonne(tp);
	}

	@RequestMapping(value = "/typePersonnes", method = RequestMethod.GET)
	@ResponseBody
	public List<TypePersonne> getAllTypeClient() {
		return typePersonneMetier.getAllTypeClient();
	}

	@RequestMapping(value = "/typePersonnes", method = RequestMethod.DELETE)
	public Long deleteTypePersonne(@RequestParam Long id) {		
		return typePersonneMetier.deleteTypePersonne(id); // http://localhost:8080/typePersonnes?id=3 
	}
	
	@RequestMapping(value = "/typePersonnes", method = RequestMethod.PUT)
	public TypePersonne updateTypePersonne(@RequestBody TypePersonne tp) {
		return typePersonneMetier.updateTypePersonne(tp);
	}
	
	@RequestMapping(value = "/typePersonnes/{id}", method = RequestMethod.GET)
	public TypePersonne findByOne(@PathVariable("id")  Long id) {
		return typePersonneMetier.findByOne(id); //Long.parseLong(id)   //  http://localhost:8080/typePersonnes/3
	}
	
}
