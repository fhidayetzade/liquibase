package springdata.producttask1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springdata.producttask1.enums.CategoryEnum;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer price;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private CategoryEnum categoryEnum;
    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "fk_product_details")
    private Product_Details productDetails;




}
