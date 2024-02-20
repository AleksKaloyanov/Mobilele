package Mobilele.demo.repository;

import Mobilele.demo.model.dto.ModelDto;
import Mobilele.demo.model.entity.BrandEntity;
import Mobilele.demo.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    List<ModelDto> findAllByBrandId(Long id);
}
