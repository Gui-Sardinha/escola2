package Escola2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Escola2.dto.ProfessorDTO;
import Escola2.entities.Professor;
import Escola2.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
	public List<ProfessorDTO> findAll(){
		List<Professor> obj = repository.findAll();
		
		List<ProfessorDTO> dto = obj.stream().map(ProfessorDTO::new).collect(Collectors.toList());
		return dto;
	}
	
	public ProfessorDTO findById(Long id) {
		Professor obj = repository.findById(id).get();
		ProfessorDTO dto = new ProfessorDTO(obj);
		return dto;
	}
	
	public ProfessorDTO insert(ProfessorDTO obj) {
		Professor entity = new Professor();
		entity.setNome(obj.getNome());
		entity.setNumeroTelefone(obj.getNumeroTelefone());
		entity.setEmail(obj.getEmail());
		obj.getEnderecos().forEach(endereco -> entity.setEnderecos(endereco));
		obj.getListaDeMateria().forEach(mateteria -> entity.inscricaoMateria(mateteria));
		entity.setSalario(obj.getSalario());
		repository.save(entity);
		
		obj = findById(entity.getId());
		
		return obj;
	}
	
	public ProfessorDTO update(Long id, ProfessorDTO obj) {
		Professor entity = repository.getReferenceById(id);
		updateData(entity, obj);
		repository.save(entity);
		
		return findById(entity.getId());
	}
	
	private void updateData(Professor entity, ProfessorDTO obj) {
		entity.setNome(obj.getNome());
		entity.setNumeroTelefone(obj.getNumeroTelefone());
		entity.setEmail(obj.getEmail());
		entity.setSalario(obj.getSalario());
		
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	

}
