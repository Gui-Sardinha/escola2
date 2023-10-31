package Escola2.dto;

import java.util.Objects;

import Escola2.entities.Pessoa;
import Escola2.entities.Professor;

public class ProfessorDTO extends Pessoa{
	
	private Double salario;

	public ProfessorDTO() {
	}

	public ProfessorDTO(Double salario) {
		this.salario = salario;
	}
	
	public ProfessorDTO(Professor professor) {
		id = professor.getId();
		nome = professor.getNome();
		numeroTelefone = professor.getNumeroTelefone();
		email = professor.getEmail();
		materias = professor.getListaDeMateria();
		enderecos = professor.getEnderecos();
		salario = professor.getSalario();
	}
	

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(salario);
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
		ProfessorDTO other = (ProfessorDTO) obj;
		return Objects.equals(salario, other.salario);
	}

	@Override
	public String toString() {
		return "ProfessorDTO [salario=" + salario + "]";
	}
}
