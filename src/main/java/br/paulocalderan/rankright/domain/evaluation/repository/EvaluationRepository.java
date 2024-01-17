package br.paulocalderan.rankright.domain.evaluation.repository;

import br.paulocalderan.rankright.domain.evaluation.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EvaluationRepository extends JpaRepository<Evaluation, UUID> {

    Optional<Evaluation> findByEmail(String email);
}
