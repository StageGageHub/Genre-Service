package com.stagegage.genreService.service;

import com.stagegage.genreService.dto.GenreDto;
import com.stagegage.genreService.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Scott on 7/13/14.
 *
 * @author Scott Hendrickson
 */
@Component
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreDto> getAllGenres() {
        return genreRepository.getAllGenres();
    }

    public GenreDto createGenre(String name) {
        return genreRepository.upsert(new GenreDto(name));
    }

    public void deleteGenre(String name) {
        genreRepository.delete(new GenreDto(name));
    }
}
