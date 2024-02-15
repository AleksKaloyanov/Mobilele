package Mobilele.demo.service;

import Mobilele.demo.model.dto.CreateOfferDTO;

import java.util.UUID;

public interface OfferService {


    UUID createOffer(CreateOfferDTO createOfferDTO);
}
