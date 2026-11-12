package com.smartlibrary.dto;

import jakarta.validation.constraints.NotNull;

public record PrestamoRequest(
        @NotNull Long estudianteId,
        @NotNull Long libroId
) {
}
