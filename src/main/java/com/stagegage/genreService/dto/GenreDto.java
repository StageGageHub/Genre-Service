package com.stagegage.genreService.dto;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Created by Scott on 7/12/14.
 *
 * @author Scott Hendrickson
 */
public class GenreDto {

    private final String genre;


    public GenreDto(final String genre) {
        this.genre = genre;
    }


    public String getGenre() {
        return genre;
    }

    public static GenreDto toGenreDto(DBObject genreDBO) {
        return new GenreDto((String) genreDBO.removeField("genre"));
    }

    public DBObject toDBO() {
        return new BasicDBObject()
                .append("genre", genre);
    }
}
