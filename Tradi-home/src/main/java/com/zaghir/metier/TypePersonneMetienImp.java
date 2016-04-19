package com.zaghir.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaghir.dao.TypePersonneRepository;
import com.zaghir.entites.TypePersonne;

@Service
public class TypePersonneMetienImp implements TypePersonneMetier{
	@Autowired
	private TypePersonneRepository typePersonneRepository ;

	public TypePersonne saveTypePersonne(TypePersonne tp) {
		return typePersonneRepository.save(tp);
	}

	public List<TypePersonne> getAllTypeClient() {
		return typePersonneRepository.findAll();
	}

	@Override
	public Long deleteTypePersonne(Long id) {
		 typePersonneRepository.delete(id);
		return id ;
	}

	@Override
	public TypePersonne updateTypePersonne(TypePersonne tp) {
		return typePersonneRepository.save(tp);
	}

	@Override
	public TypePersonne findByOne(Long id) {
		return typePersonneRepository.findOne(id);
	}
	
	

}
