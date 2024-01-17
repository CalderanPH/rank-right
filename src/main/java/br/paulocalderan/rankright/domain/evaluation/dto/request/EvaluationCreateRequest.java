package br.paulocalderan.rankright.domain.evaluation.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationCreateRequest {

    @NotEmpty
    private String email;

    @NotNull(message = "Favor informar a nota de avaliação")
    private Integer rating;

    @NotEmpty(message = "Favor preencher o campo de observação")
    private String observations;

    private String contactInfo;
}
