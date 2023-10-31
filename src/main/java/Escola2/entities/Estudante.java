package Escola2.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_estudante")
public class Estudante extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long matricula;
	private Double media;
	
	public Estudante() {
	}
	
	
	public Estudante(Long matricula, Double media) {
		this.matricula = matricula;
		this.media = media;
	}


	public Long getMatricula() {
		return matricula;
	}


	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}


	public Double getMedia() {
		return media;
	}


	public void setMedia(Double media) {
		this.media = media;
	}


	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		return Objects.equals(matricula, other.matricula);
	}


	
	
	

}
