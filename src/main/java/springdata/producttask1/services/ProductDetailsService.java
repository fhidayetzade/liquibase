package springdata.producttask1.services;

import org.springframework.stereotype.Service;
import springdata.producttask1.model.Product_Details;

@Service
public interface ProductDetailsService {

    public Product_Details getProductDetails(Integer productDetailsId);
}
