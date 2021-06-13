package com.company.CoffeeChat.controllers;

import com.company.CoffeeChat.dao.RoasterRepository;
import com.company.CoffeeChat.dto.Coffee;
import com.company.CoffeeChat.dto.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roaster")
public class RoasterController {

    @Autowired
    RoasterRepository repo;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Roaster> getAllRoasters() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Roaster getRoasterById(@PathVariable int id) {
        Optional<Roaster> optionalRoaster = repo.findById(id);

        if (optionalRoaster.isPresent()) {
            return optionalRoaster.get();
        } else {
            return null;
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Roaster createRoaster(@RequestBody Roaster roasterToBeMade) {
        return repo.save(roasterToBeMade);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateRoaster(@RequestBody Roaster roasterToBeUpdated) {
        repo.save(roasterToBeUpdated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRoaster(@PathVariable int id) {
        repo.deleteById(id);
    }

}
