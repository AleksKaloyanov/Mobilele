package Mobilele.demo.model.entity;

import Mobilele.demo.model.enums.ModelCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private ModelCategory category;

    @ManyToOne
    private BrandEntity brand;

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public ModelEntity setCategory(ModelCategory category) {
        this.category = category;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }
}
