package com.servi.study.boot.repository;

import com.servi.study.boot.bean.entry.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
