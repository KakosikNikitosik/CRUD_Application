package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController {
    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping(value = "/")
    public String printListOfCars(ModelMap model, @RequestParam(value = "count", defaultValue = "5") Integer count) {
        model.addAttribute("cars", carService.listCars(count));
        return "cars";
    }
}

