package Escola2.config;

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
		
		Materia materia = new Materia(null, "Geografia");
		
		materias.save(materia);
		
		Endereco endereco = new Endereco (null, "Rua da quinta", "Sao paulo", "Sao paulo", 5478921);
		
		
		Estudante estudante = new Estudante();
		
		estudante.setNumeroTelefone(24557785);
		estudante.setNome("Marcio");
		estudante.setEmail("marcio@gmail");
		estudante.setMatricula(123445353L);
		estudante.inscricaoMateria(materia);
		estudante.setEnderecos(endereco);
		
		Professor professor = new Professor();
		
		professor.setNome("Monica");
		professor.setNumeroTelefone(145215151);
		professor.setEmail("monica@gmail.com");
		professor.inscricaoMateria(materia);
		professor.setSalario(6000.0);
		professor.setEnderecos(endereco);
		
		
		
		endereco.setEstudantes(estudante);
		endereco.setProfessores(professor);
		
		
		
		enderecos.save(endereco);
		professores.save(professor);
		estudantes.save(estudante);
		
		
		
		
		
		
		
		
		
	}

}
