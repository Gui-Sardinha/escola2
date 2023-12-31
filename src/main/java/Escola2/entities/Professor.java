package Escola2.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Double salario;

	public Professor() {
	}

	public Professor(Double salario) {
		this.salario = salario;
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
		Professor other = (Professor) obj;
		return Objects.equals(salario, other.salario);
	}

	@Override
	public String toString() {
		return "Professor [" + "nome: " + this.getNome()   + " salario=" + salario + "]";
	}
	
	

}
