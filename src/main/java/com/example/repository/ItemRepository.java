package com.example.repository;

import com.example.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemNm(String ItemNM);

    List<Item> findByItemNmOrItemDetail(String ItemNm, String ItemDetail);

    List<Item> findByPriceLessThan(Integer price);

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
}
