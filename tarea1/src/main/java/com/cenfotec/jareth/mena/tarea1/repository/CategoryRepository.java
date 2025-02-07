package com.cenfotec.jareth.mena.tarea1.repository;

import com.cenfotec.jareth.mena.tarea1.model.Category;
import com.cenfotec.jareth.mena.tarea1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}