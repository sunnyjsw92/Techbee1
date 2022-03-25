package com.sj.shoppingCartJpaH2.Repositories;

import com.sj.shoppingCartJpaH2.VOs.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// jpa repository being used for basic CRUD operations.Using product and integer for JPA
@Repository
public interface ProductJpa extends JpaRepository<Product, Integer> {

}
