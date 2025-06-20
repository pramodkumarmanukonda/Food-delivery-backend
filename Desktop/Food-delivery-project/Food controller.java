package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.FoodItem;
import com.example.fooddelivery.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {
    private final FoodService service;

    public FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping
    public List<FoodItem> getAllFoods() {
        return service.getAllFoods();
    }

    @GetMapping("/{id}")
    public FoodItem getFood(@PathVariable int id) {
        return service.getFoodById(id);
    }

    @PostMapping
    public String addFood(@RequestBody FoodItem item) {
        service.addFood(item);
        return "Food added!";
    }

    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable int id) {
        service.deleteFood(id);
        return "Food deleted!";
    }
}
