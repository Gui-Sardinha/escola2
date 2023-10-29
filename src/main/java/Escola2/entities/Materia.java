package Escola2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_materia")
public class Materia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "materias")
	private List<Estudante> estudantes = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "materias")
	private List<Professor> professores = new ArrayList<>();
	
	public Materia() {
	}


	public Materia(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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
	public List<Estudante> getEstudantes() {
		return estudantes;
	}


	public void setEstudantes(Estudante estudante) {
		estudantes.add(estudante);
	}

	
	@JsonIgnore
	public List<Professor> getProfessor() {
		return professores;
	}


	public void setProfessor(Professor professor) {
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
		Materia other = (Materia) obj;
		return Objects.equals(id, other.id);
	}

}
