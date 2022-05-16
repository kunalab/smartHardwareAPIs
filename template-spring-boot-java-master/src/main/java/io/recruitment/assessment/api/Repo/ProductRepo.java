package io.recruitment.assessment.api.Repo;

import io.recruitment.assessment.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {


    }

