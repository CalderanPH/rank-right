package br.paulocalderan.rankright.domain.evaluation.dto.response;

import br.paulocalderan.rankright.domain.evaluation.Evaluation;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record EvaluationResponse(String email, Integer rating, String observations, String contactInfo) {

    public EvaluationResponse(Evaluation evaluation) {
        this(evaluation.getEmail(), evaluation.getRating(), evaluation.getObservations(), evaluation.getContactInfo());
    }
}
