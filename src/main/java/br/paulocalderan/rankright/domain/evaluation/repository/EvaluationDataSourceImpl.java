package br.paulocalderan.rankright.domain.evaluation.repository;

import br.paulocalderan.rankright.domain.evaluation.Evaluation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EvaluationDataSourceImpl implements EvaluationDataSource {

    private final EvaluationRepository evaluationRepository;

    @Override
    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Optional<Evaluation> findByEmail(String email) {
        return evaluationRepository.findByEmail(email);
    }

    @Override
    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }
}
