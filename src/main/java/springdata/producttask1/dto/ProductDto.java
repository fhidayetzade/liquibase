package springdata.producttask1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springdata.producttask1.enums.CategoryEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private String name;
    private Integer price;
    private String description;
    private CategoryEnum categoryEnum;
    private Long productDetailsId;

}
