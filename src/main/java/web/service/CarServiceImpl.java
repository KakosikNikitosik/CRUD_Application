package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    List<Car> cars;
    @Override
    public List<Car> listCars(Integer count) {
       cars = new ArrayList<>();

       cars.add(new Car("Almera","Nissan",1999));
       cars.add(new Car("Silvia","Nissan",1999));
       cars.add(new Car("Altezza","Toyota",1968));
       cars.add(new Car("R33","Nissan",2020));
       cars.add(new Car("M5","BMW",1997));

       return (count > 5|| count < 0) ? cars : cars.subList(0, count);
    }

}
