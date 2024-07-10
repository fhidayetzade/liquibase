package springdata.producttask1.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.producttask1.model.Product_Details;
import springdata.producttask1.repositories.ProductDetailsRepository;
import springdata.producttask1.services.ProductDetailsService;
import springdata.producttask1.services.ProductService;

@Service
@RequiredArgsConstructor
public class ProductDetailsServiceImpl implements ProductDetailsService {

    private final ProductDetailsRepository productDetailsRepository;


    @Override
    public Product_Details getProductDetails(Integer productDetailsId) {
        return productDetailsRepository.findById(productDetailsId).orElseThrow(() ->
                new IllegalArgumentException("productDetails with productDetailsId: " + productDetailsId + " could not be found"));
    }
}
