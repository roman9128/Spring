package rt.ex1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.ex1.model.Product;

@Repository
public interface ProductsRepo extends JpaRepository<Product, Long> {
}
