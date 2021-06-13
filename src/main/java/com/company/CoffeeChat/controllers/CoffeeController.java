package com.company.CoffeeChat.controllers;


import com.company.CoffeeChat.dao.CoffeeRepository;
import com.company.CoffeeChat.dto.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffee")
public class  CoffeeController {

    @Autowired
    CoffeeRepository repo;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Coffee> getAllCoffee(@RequestParam (required = false) String typeOfCoffee, @RequestParam (required = false) Integer roasterId) {
        if (typeOfCoffee != null && roasterId != null) {
            return repo.findByTypeAndRoasterId(typeOfCoffee, roasterId);
        } else if ( typeOfCoffee != null) {
            return repo.findByType(typeOfCoffee);
        } else if (roasterId != null) {
            return repo.findByRoasterId(roasterId);
        } else {
            return repo.findAll();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coffee getCoffeeById(@PathVariable int id) {
        Optional<Coffee> optionalCoffee = repo.findById(id);

        if (optionalCoffee.isPresent()) {
            return optionalCoffee.get();
        } else {
            return null;
        }
    }

    @GetMapping("/roaster/{roasterId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coffee> getAllCoffeeMadeByRoaster(@PathVariable int roasterId) {
        return repo.findByRoasterId(roasterId);
    }

//    @GetMapping("/{typeOfCoffee}/{roasterId}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Coffee> getAllCoffeeByTypeAndRoasterId(@PathVariable String typeOfCoffee, @PathVariable int roasterId) {
//        return repo.findAllCoffeeByTypeAndRoasterId(typeOfCoffee, roasterId);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee createCoffee(@RequestBody Coffee coffeeToBeMade) {
        return repo.save(coffeeToBeMade);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCoffee(@RequestBody Coffee coffeeToBeUpdated, @PathVariable int id) {
        if (id != coffeeToBeUpdated.getId()) {
            throw new RuntimeException("Id's don't match.");
        }

        repo.save(coffeeToBeUpdated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCoffeeById(@PathVariable int id) {
        repo.deleteById(id);
    }
}
