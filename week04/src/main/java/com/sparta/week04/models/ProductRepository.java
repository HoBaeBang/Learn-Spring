package com.sparta.week04.models;

import org.springframework.data.jpa.repository.JpaRepository;

//관심 상품 조회,저장
public interface ProductRepository extends JpaRepository<Product, Long> {
}
