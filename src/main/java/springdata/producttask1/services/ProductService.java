package springdata.producttask1.services;

import springdata.producttask1.CategoryCount;
import springdata.producttask1.dto.ProductDto;
import springdata.producttask1.model.Product;

import java.util.List;

public interface ProductService {
    void insertProduct(ProductDto productDto);
    List<ProductDto> getProducts(Integer priceMin , Integer priceMax);

    List<CategoryCount> getCategoryCounts();

    public Product getProduct(Integer productId);

    public Product addProductDetailsToProduct(Integer productId, Integer productDetailsId);

    public Product removeProductDetailsFromProduct(Integer productId);



}
