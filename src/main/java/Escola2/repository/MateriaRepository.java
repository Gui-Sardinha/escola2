package Escola2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Escola2.entities.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long>{
	
	//@Query("SELECT obj FROM Materia           obj JOIN FETCH obj.Professor    WHERE obj IN : materias")
	//List<Materia> findMateriaEstudantes(List<Materia> materias);

}
