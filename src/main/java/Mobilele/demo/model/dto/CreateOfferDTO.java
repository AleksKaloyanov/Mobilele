package Mobilele.demo.model.dto;

import Mobilele.demo.model.enums.EngineEnum;
import Mobilele.demo.model.enums.TransmissionEnum;
import Mobilele.demo.model.validation.YearNotInTheFuture;
import jakarta.validation.constraints.*;

import java.util.Objects;

public record CreateOfferDTO(
        @NotEmpty @Size(min = 5, max = 512) String description,
        @Positive @NotNull Long modelId,
        @NotNull EngineEnum engine,
        @NotNull TransmissionEnum transmission,
        @NotNull String imageUrl,
        @Positive @NotNull Integer mileage,
        @Positive @NotNull Integer price,
        @YearNotInTheFuture(message = "The year should not be in the future!")
        @NotNull(message = "Year must be provided!")
        @Min(1930) Integer year
) {

    public static CreateOfferDTO empty() {
        return new CreateOfferDTO(null, null, null, null, null, null, null, null);
    }
}
