package springdata.producttask1.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import springdata.producttask1.CategoryCount;
import springdata.producttask1.dto.ProductDto;
import springdata.producttask1.model.Product;
import springdata.producttask1.model.Product_Details;
import springdata.producttask1.repositories.ProductRepository;
import springdata.producttask1.services.ProductDetailsService;
import springdata.producttask1.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDetailsService productDetailsService;
    @Override
    public void insertProduct(ProductDto productDto) {
        if(productRepository.existsByName(productDto.getName())){
            throw new RuntimeException("Product name already exists");
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        productRepository.save(product);

    }

    @Override
    public List<ProductDto> getProducts(Integer priceMin , Integer priceMax) {
        List<Product> productList;
        if(priceMin==null && priceMax == null){
            productList = productRepository.findAll();
        }else {
            productList = productRepository.findAllByPriceLessThanEqualAndPriceGreaterThanEqual(priceMin,priceMax);
        }
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            ProductDto productDto = ProductDto.builder()
                    .name(product.getName())
                    .categoryEnum(product.getCategoryEnum())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .build();
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    @Override
    public List<CategoryCount> getCategoryCounts() {
        return productRepository.findCategoryCounts();
    }

    @Override
    public Product getProduct(Integer productId) {
        return productRepository.findById(productId).orElseThrow(() ->
                new IllegalArgumentException(
                        "product with id: " + productId + " could not be found"));
    }

    @Transactional
    @Override
    public Product addProductDetailsToProduct(Integer productId, Integer productDetailsId) {
        Product product = getProduct(productId);
        Product_Details productDetails = productDetailsService.getProductDetails(productDetailsId);
        if (Objects.nonNull(product.getProductDetails())) {
            throw new IllegalArgumentException("zipcode already has a city");
        }
        product.setProductDetails(productDetails);
        return product;
    }



    @Transactional
    @Override
    public Product removeProductDetailsFromProduct(Integer productId){
        Product product = getProduct(productId);
        if (!Objects.nonNull(product.getProductDetails())) {
            throw new IllegalArgumentException("zipcode does not have a city");
        }
        product.setProductDetails(null);
        return product;
    }



}
