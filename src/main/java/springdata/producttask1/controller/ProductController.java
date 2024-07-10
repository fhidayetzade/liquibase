package springdata.producttask1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.producttask1.CategoryCount;
import springdata.producttask1.dto.ProductDto;
import springdata.producttask1.services.impl.ProductServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    public void add(@RequestBody ProductDto productDto){
        productService.insertProduct(productDto);
    }

    @GetMapping
    public List<ProductDto> getProducts(Integer priceMin, Integer priceMax) {
        return productService.getProducts(priceMin, priceMax);
    }

    @GetMapping("/counts")
    public List<CategoryCount> getCategoryCounts() {
        return productService.getCategoryCounts();
    }

}
