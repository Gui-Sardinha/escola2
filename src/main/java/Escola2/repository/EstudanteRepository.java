package Escola2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Escola2.entities.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
