package Mobilele.demo.service.impl;

import Mobilele.demo.model.dto.BrandDTO;
import Mobilele.demo.model.dto.ModelDto;
import Mobilele.demo.model.entity.ModelEntity;
import Mobilele.demo.repository.ModelRepository;
import Mobilele.demo.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        Map<String, BrandDTO> brands = new HashMap<>();

        for (ModelEntity model : modelRepository.findAll()) {
            if (!brands.containsKey(model.getBrand().getBrand())) {
                brands.put(model.getBrand().getBrand(),
                        new BrandDTO(model.getBrand().getBrand(),
                                new ArrayList<>()));
            }

            brands.get(model.getBrand().getBrand()).models().add(
                    new ModelDto(model.getId(), model.getName()));
        }

        return brands.values().stream().toList();
    }
}
