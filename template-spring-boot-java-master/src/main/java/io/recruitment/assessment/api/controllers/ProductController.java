package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.Repo.ProductRepo;
import io.recruitment.assessment.api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    ProductRepo repo;
    @GetMapping(path = "/getProductList")

    public List<Product> getProducts() {

        return repo.findAll();
    }

    @PostMapping(path="/insertProduct",consumes= {"application/json"})
    public Product addProduct(@RequestBody Product product)
    {
        repo.save(product);
        return product;
    }
    @DeleteMapping(path="/deleteProduct/{product_id}")
    public String deleteProduct(@PathVariable int product_id)
    {
        Product p = repo.getOne(product_id);
        repo.deleteById(product_id);
        return "Deleted Successfully";
    }

    @PutMapping(path="/updateProduct/{product_id}")
    public Product updateProduct(@PathVariable int product_id, @RequestBody Product product)
    {
        Product p=repo.getOne(product_id);
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        repo.save(p);
        return product;
    }
}
