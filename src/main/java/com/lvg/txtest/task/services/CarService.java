package com.lvg.txtest.task.services;

import com.lvg.txtest.task.models.Car;

import java.util.List;

/**
 * Created by Victor Levchenko LVG Corp. on 20.11.16.
 */
public interface CarService {
    List<Car> findAll();
    Car save(Car car);
    void updateCarAgeJob();
}
