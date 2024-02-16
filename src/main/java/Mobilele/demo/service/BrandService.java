package Mobilele.demo.service;

import Mobilele.demo.model.dto.BrandDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
    List<BrandDTO> getAllBrands();
}
