package Mobilele.demo.repository;

import Mobilele.demo.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

//    @Query("SELECT b FROM BrandEntity b " +
//            "JOIN FETCH b.models")
// ^ Not a good solution when there is paging ^

//    use a NamedEntityGraph
    @EntityGraph(
            value = "brandWithModels",
            attributePaths = "models"
    )
    @Query("SELECT b FROM BrandEntity b")
    List<BrandEntity> getAllBrands();
}
