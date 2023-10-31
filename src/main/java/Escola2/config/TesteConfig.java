package Escola2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import Escola2.entities.Endereco;
import Escola2.entities.Estudante;
import Escola2.entities.Materia;
import Escola2.entities.Professor;
import Escola2.repository.EnderecoRepository;
import Escola2.repository.EstudanteRepository;
import Escola2.repository.MateriaRepository;
import Escola2.repository.ProfessorRepository;


@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private EstudanteRepository estudantes;
	
	@Autowired
	private MateriaRepository materias;
	
	@Autowired
	private ProfessorRepository professores;
	
	@Autowired
	private EnderecoRepository enderecos;

	@Override
	public void run(String... args) throws Exception {
		
		Materia materia1 = new Materia(null, "Geografia");
		Materia materia2 = new Materia(null, "Matematica");
		Materia materia3 = new Materia(null, "Fisica");
		Materia materia4 = new Materia(null, "Quimica");
		Materia materia5 = new Materia(null, "Ed.Fisica");
		Materia materia6 = new Materia(null, "Historia");
		
		materias.saveAll(Arrays.asList(materia1,materia2,materia3,materia4,materia5,materia6));
		
		Endereco endereco = new Endereco (null, "Rua da quinta", "Sao paulo", "Sao paulo", 5478921);
		
		
		Estudante estudante = new Estudante();
		
		estudante.setNumeroTelefone(24557785);
		estudante.setNome("Marcio");
		estudante.setEmail("marcio@gmail");
		estudante.setMatricula(123445353L);
		estudante.inscricaoMateria(materia1);
		estudante.inscricaoMateria(materia2);
		estudante.inscricaoMateria(materia3);
		estudante.inscricaoMateria(materia4);
		estudante.inscricaoMateria(materia5);
		estudante.inscricaoMateria(materia6);
		estudante.setEnderecos(endereco);
		
		Professor professor = new Professor();
		
		professor.setNome("Monica");
		professor.setNumeroTelefone(145215151);
		professor.setEmail("monica@gmail.com");
		professor.inscricaoMateria(materia1);
		professor.setSalario(6000.0);
		professor.setEnderecos(endereco);
		
		
		
		endereco.setEstudantes(estudante);
		endereco.setProfessores(professor);
		
		materia1.setProfessor(professor);
		materia1.setEstudantes(estudante);
		
		
		
		
		enderecos.save(endereco);
		professores.save(professor);
		estudantes.save(estudante);
		
		
		
		
		
		
		System.out.println(materia1.getProfessor());
		
		
	}

}
