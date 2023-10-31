package Escola2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Escola2.dto.MateriaDTO;
import Escola2.entities.Materia;
import Escola2.repository.MateriaRepository;
import jakarta.transaction.Transactional;

@Service
public class MateriaService {
	
	@Autowired
	private MateriaRepository repository;
	
	public List<MateriaDTO> findAll(){
		List<Materia> obj = repository.findAll();
		List<MateriaDTO> dto = obj.stream().map(MateriaDTO::new).collect(Collectors.toList());
		return dto;
	}
	
	//@Transactional
	//public Page<MateriaDTO> find(PageRequest pageRequest) {
	//	Page<Materia> page = repository.findAll(pageRequest);
	//	repository.findMateriaEstudantes(page.stream().collect(Collectors.toList()));
	//	return page.map(x -> new MateriaDTO(x));
	//}
	
	public MateriaDTO findById(Long id) {
		Materia obj = repository.findById(id).get();
		MateriaDTO dto = new MateriaDTO(obj);
		return dto;
	}
	
	public MateriaDTO insert(MateriaDTO obj) {
		Materia entity = new Materia();
		entity.setNome(obj.getNome());
		
		//obj.getEstudantes().forEach(estudanteDTO -> new Estudante());
		//.stream().map().collect(Collectors.toList()).forEach(estudante -> entity.setEstudantes(estudante));		
		//obj.getEstudantes().forEach(estudante -> entity.setEstudante(estudante);
		//obj.getProfessores().forEach(professor -> entity.setProfessor(professor));
		
		repository.save(entity);
		
		obj = findById(entity.getId());
		
		return obj;
	}
	
	public MateriaDTO update(Long id, MateriaDTO obj) {
		Materia entity = repository.getReferenceById(id);
		updateData(entity, obj);
		repository.save(entity);
		return findById(entity.getId());
	}
	
	private void updateData(Materia entity, MateriaDTO obj) {
		entity.setNome(obj.getNome());
		
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
