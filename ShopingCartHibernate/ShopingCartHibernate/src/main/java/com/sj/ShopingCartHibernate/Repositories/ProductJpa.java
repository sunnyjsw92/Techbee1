package com.sj.ShopingCartHibernate.Repositories;

import com.sj.ShopingCartHibernate.VOs.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//using jap respository with product and integer as identifiers
@Repository
public interface ProductJpa extends JpaRepository<Product, Integer> {

}
