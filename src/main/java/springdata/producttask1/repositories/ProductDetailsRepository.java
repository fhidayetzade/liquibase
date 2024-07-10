package springdata.producttask1.repositories;

import org.springframework.data.repository.CrudRepository;
import springdata.producttask1.model.Product_Details;

public interface ProductDetailsRepository extends CrudRepository<Product_Details,Integer> {
}
