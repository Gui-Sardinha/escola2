package Escola2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Escola2.dto.EstudanteDTO;
import Escola2.entities.Estudante;
import Escola2.repository.EstudanteRepository;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteRepository repository;
	
	public List<EstudanteDTO> findAll(){
		List<Estudante> obj = repository.findAll();
		List<EstudanteDTO> dto = obj.stream().map(EstudanteDTO::new).collect(Collectors.toList());
		
		return dto;
	}
	
	public EstudanteDTO findById(Long id){
		Estudante obj = repository.findById(id).get();
		EstudanteDTO dto = new EstudanteDTO(obj);
		return dto;
	}
	
	public EstudanteDTO insert(EstudanteDTO obj) {
		Estudante entity = new Estudante();
		entity.setNome(obj.getNome());
		entity.setNumeroTelefone(obj.getNumeroTelefone());
		entity.setEmail(obj.getEmail());
		obj.getEnderecos().forEach(endereco -> entity.setEnderecos(endereco));
		obj.getListaDeMateria().forEach(mateteria -> entity.inscricaoMateria(mateteria));
		entity.setMatricula(obj.getMatricula());
		entity.setMedia(obj.getMedia());
		repository.save(entity);
		
		obj = findById(entity.getId());
		
		return obj;
	}
	
	public EstudanteDTO update(Long id, EstudanteDTO obj) {
		Estudante entity = repository.getReferenceById(id);
		updateData(entity, obj);
		repository.save(entity);
		return findById(entity.getId());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	private void updateData(Estudante entity, EstudanteDTO obj) {
		entity.setNome(obj.getNome());
		entity.setNumeroTelefone(obj.getNumeroTelefone());
		entity.setEmail(obj.getEmail());
		entity.setMatricula(obj.getMatricula());
		
	}

}
