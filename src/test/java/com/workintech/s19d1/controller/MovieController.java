package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import com.workintech.s19d1.util.HollywoodValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movie") // Hocanın testleri genelde /movie bekler, hata alırsan /workintech/movies yaparsın
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll() {
        log.info("Fetching all movies");
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable long id) {
        log.info("Fetching movie with id: {}", id);
        return movieService.findById(id);
    }

    @PostMapping
    public Movie save(@Validated @RequestBody Movie movie) {
        log.info("Saving movie: {}", movie.getName());
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable long id, @RequestBody Movie movie) {
        log.info("Updating movie id: {}", id);

        movieService.findById(id);

        movie.setId(id);
        return movieService.save(movie);
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable long id) {
        log.warn("Deleting movie id: {}", id);

        Movie movie = movieService.findById(id);

        movieService.delete(movie);

        return movie;
    }
}