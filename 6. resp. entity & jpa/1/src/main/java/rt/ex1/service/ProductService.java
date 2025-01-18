package rt.ex1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rt.ex1.model.Product;
import rt.ex1.repo.ProductsRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductsRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return repo.save(product);
    }

    public Product createProduct(Product product){
        return repo.save(product);
    }

    public void deleteProduct(Long id){
        repo.deleteById(id);
    }
}
