package Escola2.dto;

import java.util.Objects;
import java.util.stream.Stream;

import Escola2.entities.Estudante;
import Escola2.entities.Materia;
import Escola2.entities.Pessoa;
import Escola2.entities.Professor;

public class EstudanteDTO extends Pessoa{

	private Long matricula;
	private Double media;
	
	
	public EstudanteDTO() {
	}


	public EstudanteDTO(Long matricula, Double media) {
		this.matricula = matricula;
		this.media = media;
	}


	public EstudanteDTO(Estudante estudante) {
		id = estudante.getId();
		nome = estudante.getNome();
		numeroTelefone =estudante.getNumeroTelefone();
		email = estudante.getEmail();
		materias = estudante.getListaDeMateria();
		enderecos = estudante.getEnderecos();
		matricula = estudante.getMatricula();
		media = estudante.getMedia();
	}

    public EstudanteDTO(Professor professor) {
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(matricula);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstudanteDTO other = (EstudanteDTO) obj;
		return Objects.equals(matricula, other.matricula);
	}


	@Override
	public String toString() {
		return "EstudanteDTO [matricula=" + matricula + ", media=" + media + "]";
	}


}

