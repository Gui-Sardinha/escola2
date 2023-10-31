package Escola2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Escola2.dto.EnderecoDTO;
import Escola2.entities.Endereco;
import Escola2.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<EnderecoDTO> findAll(){
		List<Endereco> obj = repository.findAll();
		List<EnderecoDTO> dto = obj.stream().map(EnderecoDTO::new).collect(Collectors.toList());

		return dto;
	}
	
	
	public EnderecoDTO findById(Long id) {
		Endereco obj = repository.findById(id).get();
		EnderecoDTO dto = new EnderecoDTO(obj);
		return dto;
	}
	
	public EnderecoDTO insert(EnderecoDTO obj) { 
		Endereco entity = new Endereco();
		entity.setNomeRua(obj.getNomeRua());
		entity.setEstado(obj.getEstado());
		entity.setCidade(obj.getCidade());
		entity.setCep(obj.getCep());
		repository.save(entity);
		
		EnderecoDTO obj2 = findById(entity.getId());
	
		return obj2; 
	}
	
	public EnderecoDTO update(Long id, EnderecoDTO obj) {
		Endereco entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		repository.save(entity);		
		return findById(entity.getId());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	private void updateDate(Endereco entity, EnderecoDTO obj) {
		entity.setNomeRua(obj.getNomeRua());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		entity.setCep(obj.getCep());
	}

}
