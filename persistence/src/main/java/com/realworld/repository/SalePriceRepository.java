package com.realworld.repository;

import com.realworld.model.SalePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalePriceRepository extends JpaRepository< SalePrice, String > {
}
