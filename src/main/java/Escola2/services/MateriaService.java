package Escola2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Escola2.entities.Materia;
import Escola2.repository.MateriaRepository;

@Service
public class MateriaService {
	
	@Autowired
	private MateriaRepository repository;
	
	public List<Materia> findAll(){
		return repository.findAll();
	}
	
	public Materia findById(Long id) {
		Optional<Materia> obj = repository.findById(id);
		return obj.get();
	}
	
	public Materia insert(Materia obj) {
		return repository.save(obj);
	}
	
	public Materia update(Long id, Materia obj) {
		Materia entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Materia entity, Materia obj) {
		entity.setNome(obj.getNome());
		
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
