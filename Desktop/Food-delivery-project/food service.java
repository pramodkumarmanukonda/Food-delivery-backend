package com.example.fooddelivery.service;

import com.example.fooddelivery.model.FoodItem;
import com.example.fooddelivery.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository repo;

    public FoodService(FoodRepository repo) {
        this.repo = repo;
    }

    public List<FoodItem> getAllFoods() {
        return repo.findAll();
    }

    public FoodItem getFoodById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void addFood(FoodItem item) {
        repo.save(item);
    }

    public void deleteFood(int id) {
        repo.delete(id);
    }
}
