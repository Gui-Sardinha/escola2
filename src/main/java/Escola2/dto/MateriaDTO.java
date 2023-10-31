package Escola2.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Escola2.entities.Materia;

public class MateriaDTO {
	
	private Long id;
	private String nome;
	
	private List<EstudanteDTO> estudantes = new ArrayList<>();
	
	private List<ProfessorDTO> professores = new ArrayList<>();
	
	public MateriaDTO() {
	}

	public MateriaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public MateriaDTO(Materia materia) {
		id = materia.getId();
		nome = materia.getNome();
		estudantes = materia.getEstudantes().stream().map(EstudanteDTO::new).collect(Collectors.toList());;
		professores = materia.getProfessor().stream().map(ProfessorDTO::new).collect(Collectors.toList());;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonIgnore
	public List<EstudanteDTO> getEstudantes() {
		return estudantes;
	}
	
	public void setEstudantes(EstudanteDTO estudante) {
		estudantes.add(estudante);
	}
	
	@JsonIgnore
	public List<ProfessorDTO> getProfessores() {
		return professores;
	}
	
	public void setProfessores (ProfessorDTO professor) {
		professores.add(professor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MateriaDTO other = (MateriaDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MateriaDTO [id=" + id + ", nome=" + nome + ", estudantes=" + estudantes + ", professores=" + professores
				+ "]";
	}
	
	
	
	
	
	
}
