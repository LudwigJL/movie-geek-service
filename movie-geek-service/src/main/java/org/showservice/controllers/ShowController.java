package org.showservice.controllers;

import org.showservice.models.Show;
import org.showservice.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowRepository showRepository;

    @GetMapping
    public List<Show> getAll(){
        return this.showRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Show> getOne(@PathVariable int id){
        Show show = this.showRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        return ResponseEntity.ok(show);
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody Show show){
        return new ResponseEntity<Show>(this.showRepository.save(show), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Show> updateShow(@PathVariable int id, @RequestBody Show show) {
        Show showToUpdate = this.showRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found."));

        showToUpdate.setTitle(show.getTitle());
        showToUpdate.setRuntime(show.getRuntime());
        showToUpdate.setSeasons(show.getSeasons());
        showToUpdate.setReleaseYear(show.getReleaseYear());
        showToUpdate.setImdbScore(show.getImdbScore());

        return new ResponseEntity<Show>(this.showRepository.save(showToUpdate), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Show> deleteShow(@PathVariable int id){
        Show showToDelete = this.showRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));

        this.showRepository.delete(showToDelete);
        return ResponseEntity.ok(showToDelete);
    }

    @GetMapping("/toprated")
    public List<Show> getToprated() {
        return this.showRepository.find15BestRatedShows();
    }







}
