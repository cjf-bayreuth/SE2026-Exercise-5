package de.uni_bayreuth.se.demo.repository;

import de.uni_bayreuth.se.demo.model.Coffee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CoffeeRepository {

    private final ArrayList<Coffee> coffees = new ArrayList(List.of(
            new Coffee(1L, "Campus Cafe", 2.50, true, true),
            new Coffee(2L, "Library Coffee", 2.00, false, false),
            new Coffee(3L, "Botanical Beans", 3.20, true, true),
            new Coffee(4L, "Cafebar 8tto Grammi", 4.20, false, false)
        )
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

    public List<Coffee> findReturnPoint() {
        return coffees.stream()
                .filter(Coffee::returnPoint)
                .toList();
    }

    public Coffee updateCoffee(String name, Coffee coffee) {
        Coffee c = findByName(name).orElse(null);

        if (c == null) return null;

        coffees.remove(c);
        coffees.add(coffee);

        return coffee;
    }
}
