package Mobilele.demo.model.dto;

import Mobilele.demo.model.enums.EngineEnum;
import Mobilele.demo.model.enums.TransmissionEnum;

public record CreateOfferDTO(
        String description,
        Long modelId,
        EngineEnum engine,
        TransmissionEnum transmission,
        String imageUrl,
        Integer mileage,
        Integer price,
        Integer year
) {
}
