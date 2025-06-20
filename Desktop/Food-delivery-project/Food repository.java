package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.FoodItem;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class FoodRepository {
    private final Map<Integer, FoodItem> foodItems = new HashMap<>();

    public List<FoodItem> findAll() {
        return new ArrayList<>(foodItems.values());
    }

    public Optional<FoodItem> findById(int id) {
        return Optional.ofNullable(foodItems.get(id));
    }

    public void save(FoodItem item) {
        foodItems.put(item.getId(), item);
    }

    public void delete(int id) {
        foodItems.remove(id);
    }

    @PostConstruct
    public void init() {
        save(new FoodItem(1, "Burger", 5.99));
        save(new FoodItem(2, "Pizza", 8.99));
        save(new FoodItem(3, "Fries", 2.99));
    }
}
