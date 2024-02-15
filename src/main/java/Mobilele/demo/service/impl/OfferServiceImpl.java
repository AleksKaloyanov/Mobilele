package Mobilele.demo.service.impl;

import Mobilele.demo.model.dto.CreateOfferDTO;
import Mobilele.demo.repository.OfferRepository;
import Mobilele.demo.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
        throw new UnsupportedOperationException("Coming soon!");
    }
}
