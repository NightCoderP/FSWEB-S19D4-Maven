package com.workintech.s19d1.repository;

import com.workintech.s19d1.entity.Actor;

import java.util.List;

public interface ActorDao {
    List<Actor> findAll();
    Actor findById(long id);
    Actor save(Actor actor);
    Actor update(Actor actor);
    Actor delete(long id);
}