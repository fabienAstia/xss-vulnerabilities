package co.simplon.xss_vulnerabilities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InstructionView(
        @NotBlank @Size(max = 50) String name
) {
}
