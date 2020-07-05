package com.servi.study.boot.repository;

import com.servi.study.boot.bean.entry.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {
}
