package br.paulocalderan.rankright.domain.evaluation.service;

import br.paulocalderan.rankright.domain.evaluation.Evaluation;
import br.paulocalderan.rankright.domain.evaluation.assembler.EvaluationAssembler;
import br.paulocalderan.rankright.domain.evaluation.dto.request.EvaluationCreateRequest;
import br.paulocalderan.rankright.domain.evaluation.dto.response.EvaluationResponse;
import br.paulocalderan.rankright.domain.evaluation.repository.EvaluationDataSource;
import br.paulocalderan.rankright.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.paulocalderan.rankright.exception.ExceptionConstants.EMAIL_ALREADY_REGISTERED;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationDataSource evaluationDataSource;

    public Evaluation create(EvaluationCreateRequest evaluationCreateRequest) {
        String email = evaluationCreateRequest.getEmail();

        if (isEmailAlreadyRegistered(email)) {
            throw new ApiException(EMAIL_ALREADY_REGISTERED);
        }

        Evaluation evaluation = EvaluationAssembler.toEntity(evaluationCreateRequest);
        return evaluationDataSource.save(evaluation);
    }

    public boolean isEmailAlreadyRegistered(String email) {
        Optional<Evaluation> existingEvaluation = evaluationDataSource.findByEmail(email);
        return existingEvaluation.isPresent();
    }

    public List<EvaluationResponse> findAll() {
        List<Evaluation> evaluations = evaluationDataSource.findAll();
        return EvaluationAssembler.toListResponseModel(evaluations);
    }
}
