package de.uni_bayreuth.se.demo.service;

import de.uni_bayreuth.se.demo.model.Coffee;
import de.uni_bayreuth.se.demo.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffeeByName(String name) {
        return coffeeRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Coffee shop not found: " + name));
    }

    public List<Coffee> getAccessibleCoffees() {
        return coffeeRepository.findAccessible();
    }

    public List<Coffee> getReturnPoints() { return coffeeRepository.findReturnPoint(); }
}
