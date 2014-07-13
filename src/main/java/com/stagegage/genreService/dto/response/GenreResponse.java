package com.stagegage.genreService.dto.response;

import com.stagegage.genreService.dto.GenreDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott on 7/12/14.
 *
 * @author Scott Hendrickson
 */
public class GenreResponse {

    private final String genre;

    public GenreResponse(final String genre) {
        this.genre = genre;
    }

    public static List<GenreResponse> getResponse(List<GenreDto> genreDtos) {
        if (genreDtos == null) return null;

        List<GenreResponse> genreResponses = new ArrayList<GenreResponse>();
        for (GenreDto dto : genreDtos) {
            genreResponses.add(toResponse(dto));
        }

        return genreResponses;
    }

    public static GenreResponse toResponse(GenreDto dto) {
        if(dto == null) return null;

        return new GenreResponse(dto.getGenre());
    }

    public String getGenre() {
        return genre;
    }
}
