package co.simplon.xss_vulnerabilities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AnswerCreate(
        @NotBlank @Size(max = 10) String firstname,
        @NotBlank @Size(max = 1000) String answer
) {
}
