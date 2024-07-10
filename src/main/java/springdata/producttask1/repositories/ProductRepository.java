package springdata.producttask1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdata.producttask1.CategoryCount;
import springdata.producttask1.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    boolean existsByName(String name);
    List<Product> findAllByPriceLessThanEqualAndPriceGreaterThanEqual(Integer priceMin , Integer priceMax);

    @Query(value = "SELECT category_enum as category, COUNT(*) as productCount" +
            " FROM product GROUP BY category_enum", nativeQuery = true)
    List<CategoryCount> findCategoryCounts();

}
