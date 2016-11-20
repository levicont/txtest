package com.lvg.txtest.task.repository;

import com.lvg.txtest.task.models.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Victor Levchenko LVG Corp. on 20.11.16.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}
