package com.cenfotec.jareth.mena.tarea1.repository;

import com.cenfotec.jareth.mena.tarea1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}