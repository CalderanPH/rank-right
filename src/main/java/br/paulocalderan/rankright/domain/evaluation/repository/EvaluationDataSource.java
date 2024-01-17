package br.paulocalderan.rankright.domain.evaluation.repository;

import br.paulocalderan.rankright.domain.evaluation.Evaluation;

import java.util.List;
import java.util.Optional;

public interface EvaluationDataSource {

    Evaluation save(Evaluation evaluation);

    Optional<Evaluation> findByEmail(String email);

    List<Evaluation> findAll();
}
