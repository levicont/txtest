package com.lvg.txtest.task.services.jpa;

import com.google.common.collect.Lists;
import com.lvg.txtest.task.models.Car;
import com.lvg.txtest.task.repository.CarRepository;
import com.lvg.txtest.task.services.CarService;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Victor Levchenko LVG Corp. on 20.11.16.
 */

@Service("carService")
@Transactional
@Repository
public class CarServiceJpaImpl implements CarService {
    private static final Logger LOG = Logger.getLogger(CarServiceJpaImpl.class);

    @Autowired
    CarRepository carRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void updateCarAgeJob() {
        List<Car> cars = findAll();
        DateTime currentDate = DateTime.now();
        LOG.info("Car age update job started");
        for (Car car : cars){
            int age = Years.yearsBetween(car.getManufactureDate(), currentDate).getYears();
            car.setAge(age);
            save(car);
            LOG.info("Car age update --- "+ car);
        }
        LOG.info("Car age update job completed successfully!");
    }
}
