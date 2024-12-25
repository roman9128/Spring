package rt.task3.service;

import org.springframework.stereotype.Service;
import rt.task3.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
