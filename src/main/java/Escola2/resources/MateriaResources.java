package Escola2.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Escola2.dto.MateriaDTO;
import Escola2.services.MateriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/materias")
public class MateriaResources {
	
	@Autowired
	private MateriaService service;
	
	@GetMapping
	public ResponseEntity<List<MateriaDTO>> findAll(){
		List<MateriaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
//	@GetMapping
//	public ResponseEntity<Page<MateriaDTO>> findAll(
//			@RequestParam(value = "page", defaultValue = "0") Integer page,
//			@RequestParam(value = "size", defaultValue = "10") Integer size
//			) {
//		
//		PageRequest pageRequest = PageRequest.of(page, size);
//		Page<MateriaDTO> list = service.find(pageRequest);
//		return ResponseEntity.ok(list);
//	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MateriaDTO> findById(@PathVariable Long id){
		MateriaDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<MateriaDTO> insert(@RequestBody @Valid MateriaDTO obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MateriaDTO> update(@PathVariable Long id, @RequestBody MateriaDTO obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
