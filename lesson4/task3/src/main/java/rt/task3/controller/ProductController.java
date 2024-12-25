package rt.task3.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rt.task3.model.Product;
import rt.task3.service.ProductService;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product product, Model model) {
        productService.addProduct(product);
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

}
