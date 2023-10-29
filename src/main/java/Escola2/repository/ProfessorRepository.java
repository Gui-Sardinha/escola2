package Escola2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Escola2.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
