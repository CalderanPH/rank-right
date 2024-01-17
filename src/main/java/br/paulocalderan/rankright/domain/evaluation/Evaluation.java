package br.paulocalderan.rankright.domain.evaluation;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_evaluation")
public class Evaluation {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String email;

    private Integer rating;

    private String observations;

    private String contactInfo;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
