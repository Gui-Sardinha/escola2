package Escola2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Escola2.entities.Endereco;
import Escola2.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.get();
	}
	
	public Endereco insert(Endereco obj) {
		return repository.save(obj);
	}
	
	public Endereco update(Long id, Endereco obj) {
		Endereco entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	private void updateDate(Endereco entity, Endereco obj) {
		entity.setNomeRua(obj.getNomeRua());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		entity.setCep(obj.getCep());
	}

}
