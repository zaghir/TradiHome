package com.zaghir.metier;

import java.util.List;

import com.zaghir.entites.TypePersonne;

public interface TypePersonneMetier {
	
	public TypePersonne saveTypePersonne(TypePersonne tp);
	public List<TypePersonne> getAllTypeClient();
	public Long deleteTypePersonne (Long id);
	public TypePersonne updateTypePersonne(TypePersonne tp) ;
	public TypePersonne findByOne(Long id) ;
	

}
