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
@Table(name = "tb_endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeRua;
	private String estado;
	private String cidade;
	private Integer cep;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "enderecos")
	private List<Estudante> estudantes = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "enderecos")
	private List<Professor> professores = new ArrayList<>();
	
	public Endereco() {
	}


	public Endereco(Long id, String nomeRua, String estado, String cidade, Integer cep) {
		super();
		this.id = id;
		this.nomeRua = nomeRua;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeRua() {
		return nomeRua;
	}


	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public Integer getCep() {
		return cep;
	}


	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	@JsonIgnore
	public List<Estudante> getEstudantes() {
		return estudantes;
	}


	public void setEstudantes(Estudante estudante) {
		estudantes.add(estudante);
	}

	@JsonIgnore
	public List<Professor> getProfessores() {
		return professores;
	}


	public void setProfessores(Professor professore) {
		professores.add(professore);
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
