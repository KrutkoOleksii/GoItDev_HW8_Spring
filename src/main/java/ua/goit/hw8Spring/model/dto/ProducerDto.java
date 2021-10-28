package ua.goit.hw8Spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.goit.hw8Spring.model.BaseEntity;
import ua.goit.hw8Spring.model.Product;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProducerDto implements BaseEntity<Long> {

    private Long id;

    private String name;

    private Set<Product> products;

    @Override
    public Long getId() {
        return id;
    }

}
