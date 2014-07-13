package com.stagegage.genreService.resource;

import com.stagegage.genreService.dto.GenreDto;
import com.stagegage.genreService.dto.response.GenreResponse;
import com.stagegage.genreService.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Scott on 7/13/14.
 *
 * @author Scott Hendrickson
 */
@RestController
@RequestMapping("/genres")
public class GenreResource {

    @Autowired
    private GenreService genreService;

    @RequestMapping(method = RequestMethod.GET)
    public List<GenreResponse> getGenres() {

        List<GenreDto> genreDtos = genreService.getAllGenres();

        return GenreResponse.getResponse(genreDtos);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public GenreResponse createGenre(@RequestParam String name) {
        return GenreResponse.toResponse(genreService.createGenre(name));
    }
}
