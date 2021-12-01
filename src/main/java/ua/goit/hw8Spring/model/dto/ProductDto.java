package ua.goit.hw8Spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.goit.hw8Spring.model.BaseEntity;
import ua.goit.hw8Spring.model.Producer;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements BaseEntity<Long> {

    private Long id;

    private String name;

    private Long price;

    private Producer producer;

    @Override
    public Long getId() {
        return id;
    }
}
