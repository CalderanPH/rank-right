package br.paulocalderan.rankright.domain.evaluation.controller;

import br.paulocalderan.rankright.domain.evaluation.Evaluation;
import br.paulocalderan.rankright.domain.evaluation.dto.request.EvaluationCreateRequest;
import br.paulocalderan.rankright.domain.evaluation.dto.response.EvaluationResponse;
import br.paulocalderan.rankright.domain.evaluation.service.EvaluationService;
import br.paulocalderan.rankright.exception.ApiException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static br.paulocalderan.rankright.util.MessageConstants.REGISTERED_FORM;

@RestController
@RequestMapping("/evaluation")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EvaluationCreateRequest evaluationCreateRequest) {
        try {
            Evaluation evaluation = evaluationService.create(evaluationCreateRequest);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(evaluation.getId())
                    .toUri();
            return ResponseEntity.created(location).body(REGISTERED_FORM);
        } catch (ApiException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public List<EvaluationResponse> findAll() {
        return evaluationService.findAll();
    }

}
