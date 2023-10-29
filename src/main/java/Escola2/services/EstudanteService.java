package Escola2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Escola2.entities.Estudante;
import Escola2.repository.EstudanteRepository;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteRepository repository;
	
	public List<Estudante> findAll(){
		return repository.findAll();
	}
	
	public Estudante findById(Long id){
		Optional<Estudante> obj = repository.findById(id);
		return obj.get();
	}
	
	public Estudante insert(Estudante obj) {
		return repository.save(obj);
	}
	
	public Estudante update(Long id, Estudante obj) {
		Estudante entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	private void updateData(Estudante entity, Estudante obj) {
		entity.setNome(obj.getNome());
		entity.setNumeroTelefone(obj.getNumeroTelefone());
		entity.setEmail(obj.getEmail());
		entity.setMatricula(obj.getMatricula());
		
	}

}
