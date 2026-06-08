package de.uni_bayreuth.se.demo.repository;

import de.uni_bayreuth.se.demo.model.Coffee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CoffeeRepository {

    private final List<Coffee> coffees = List.of(
            new Coffee(1L, "Campus Cafe", 2.50, true),
            new Coffee(2L, "Library Coffee", 2.00, false),
            new Coffee(3L, "Botanical Beans", 3.20, true)
    );

    public List<Coffee> findAll() {
        return coffees;
    }

    public Optional<Coffee> findByName(String name) {
        return coffees.stream()
                .filter(c -> c.name().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Coffee> findAccessible() {
        return coffees.stream()
                .filter(Coffee::wheelchairAccessible)
                .toList();
    }
}
