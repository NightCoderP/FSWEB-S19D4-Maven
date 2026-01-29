package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.util.HollywoodValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> findAll() {
        log.info("Fetching all actors");
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable long id) {
        log.info("Fetching actor with id: {}", id);
        return actorService.findById(id);
    }

    @PostMapping
    public Actor save(@Validated @RequestBody Actor actor) {
        log.info("Saving actor: {} {}", actor.getFirstName(), actor.getLastName());
        return actorService.save(actor);
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable long id, @RequestBody Actor actor) {
        log.info("Updating actor id: {}", id);
        Actor existingActor = actorService.findById(id);
        actor.setId(id);
        return actorService.save(actor);
    }

    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable long id) {
        log.warn("Deleting actor id: {}", id);
        Actor actor = actorService.findById(id);
        actorService.delete(actor);
        return actor;
    }
}