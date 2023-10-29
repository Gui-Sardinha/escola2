package Escola2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Escola2.entities.Professor;
import Escola2.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
	public List<Professor> findAll(){
		return repository.findAll();
	}
	
	public Professor findById(Long id) {
		Optional<Professor> obj = repository.findById(id);
		return obj.get();
	}
	
	public Professor insert(Professor obj) {
		return repository.save(obj);
	}
	
	public Professor update(Long id, Professor obj) {
		Professor entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Professor entity, Professor obj) {
		entity.setNome(obj.getNome());
		entity.setNumeroTelefone(obj.getNumeroTelefone());
		entity.setEmail(obj.getEmail());
		entity.setSalario(obj.getSalario());
		
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	

}
