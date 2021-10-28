package ua.goit.hw8Spring.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "producer")
@ToString(exclude = "producer")
public class Product implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Long price;

    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;

    @Override
    public Long getId() {
        return null;
    }
}
