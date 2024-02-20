package Mobilele.demo.service.impl;

import Mobilele.demo.model.dto.BrandDTO;
import Mobilele.demo.model.dto.ModelDto;
import Mobilele.demo.model.entity.ModelEntity;
import Mobilele.demo.repository.BrandRepository;
import Mobilele.demo.repository.ModelRepository;
import Mobilele.demo.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(ModelRepository modelRepository,
                            BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(brand -> new BrandDTO(
                        brand.getBrand(),
                        modelRepository.findAllByBrandId(brand.getId()).stream()
                                .map(model -> new ModelDto(model.id(), model.name()))
                                .sorted(Comparator.comparing(ModelDto::name))
                                .collect(Collectors.toList())
                ))
                .sorted(Comparator.comparing(BrandDTO::name))
                .collect(Collectors.toList());

    }
}
