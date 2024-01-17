package br.paulocalderan.rankright.domain.evaluation.controller;

import br.paulocalderan.rankright.domain.evaluation.Evaluation;
import br.paulocalderan.rankright.domain.evaluation.dto.request.EvaluationCreateRequest;
import br.paulocalderan.rankright.domain.evaluation.dto.response.EvaluationResponse;
import br.paulocalderan.rankright.domain.evaluation.service.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/evaluation")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<Evaluation> create(@Valid @RequestBody EvaluationCreateRequest evaluationCreateRequest) {
        Evaluation evaluation = evaluationService.create(evaluationCreateRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(evaluation.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/findAll")
    public List<EvaluationResponse> findAll() {
        return evaluationService.findAll();
    }

}
