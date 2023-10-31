package Escola2.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Escola2.entities.Endereco;

public class EnderecoDTO {
	
	private Long id;
	private String nomeRua;
	private String estado;
	private String cidade;
	private Integer cep;
	
	private List<EstudanteDTO> estudantes = new ArrayList<>();
	

	private List<ProfessorDTO> professores = new ArrayList<>();
	
	
	public EnderecoDTO() {
	}


	public EnderecoDTO(Long id, String nomeRua, String estado, String cidade, Integer cep) {
		this.id = id;
		this.nomeRua = nomeRua;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
	}
	
	public EnderecoDTO(Endereco endereco) {
		id = endereco.getId();
		nomeRua = endereco.getNomeRua();
		estado = endereco.getEstado();
		cidade = endereco.getEstado();
		cep = endereco.getCep();
		estudantes = endereco.getEstudantes().stream().map(EstudanteDTO::new).collect(Collectors.toList());
		professores = endereco.getProfessores().stream().map(ProfessorDTO::new).collect(Collectors.toList());
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


	public void setProfessores(ProfessorDTO professor) {
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
		EnderecoDTO other = (EnderecoDTO) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "EnderecoDTO [id=" + id + ", nomeRua=" + nomeRua + ", estado=" + estado + ", cidade=" + cidade + ", cep="
				+ cep + "]";
	}
	
	
	

}
