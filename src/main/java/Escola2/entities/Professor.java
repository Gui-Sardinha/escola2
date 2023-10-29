package Escola2.entities;

import java.io.Serializable;

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

}
