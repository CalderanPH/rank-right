package br.paulocalderan.rankright.domain.evaluation.assembler;

import br.paulocalderan.rankright.domain.evaluation.Evaluation;
import br.paulocalderan.rankright.domain.evaluation.dto.request.EvaluationCreateRequest;
import br.paulocalderan.rankright.domain.evaluation.dto.response.EvaluationResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EvaluationAssembler {
    public static Evaluation toEntity(EvaluationCreateRequest request) {
        return Evaluation.builder()
                .email(request.getEmail())
                .rating(request.getRating())
                .observations(request.getObservations())
                .contactInfo(request.getContactInfo())
                .build();
    }

    public static List<EvaluationResponse> toListResponseModel(List<Evaluation> evaluations) {
        return evaluations.stream()
                .map(EvaluationResponse::new)
                .toList();
    }
}
