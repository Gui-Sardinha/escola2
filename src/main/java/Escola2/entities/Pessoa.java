package Escola2.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String nome;
	protected Integer numeroTelefone;
	protected String email;
	
	
	@ManyToMany
	@JoinColumn(name = "materia_id", referencedColumnName = "id")
	protected List<Materia> materias = new ArrayList<>();
	
	
	@ManyToMany
	@JoinColumn (name = "endereco_id", referencedColumnName = "id")
	protected List<Endereco> enderecos = new ArrayList<>();

	public Pessoa() {
	}

	public Pessoa(Long id,String nome ,Integer numeroTelefone, String email) {
		this.id = id;
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
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

	public Integer getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(Integer numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public List<Materia> getListaDeMateria() {
		return materias;
	}

	public void inscricaoMateria(Materia materia) {
		materias.add(materia);
	}
	
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco endereco) {
		enderecos.add(endereco);
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
