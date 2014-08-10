package com.stagegage.genreService.repository;

import com.mongodb.*;
import com.stagegage.genreService.dto.GenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott on 7/12/14.
 *
 * @author Scott Hendrickson
 */
@Component
public class GenreRepository {

    @Autowired
    private Environment env;

    private MongoConfig dbConfig;
    private DB db;
    private DBCollection genres;

    public GenreRepository() {
        dbConfig = new MongoConfig();

        this.db = dbConfig.createDB();
        if(db == null)
            System.out.println("Could not create DB");
        this.genres = db.getCollection("genres");

        // Make sure connection is ok
        db.getStats();
    }

    public List<GenreDto> getAllGenres() {
        List<GenreDto> genreDtos = new ArrayList<GenreDto>();
        DBCursor cursor = genres.find();
        try {
            while(cursor.hasNext()) {
                DBObject genre = cursor.next();
                genreDtos.add(GenreDto.toGenreDto(genre));
            }
        } finally {
            cursor.close();
        }
        return genreDtos;
    }

    public GenreDto upsert(GenreDto genreDto) {
        // True for upsert, false for multi. We dont need to update all, as only one will match anyway
        genres.update(genreDto.toDBO(), genreDto.toDBO(), true, false);

        return genreDto;
    }

    public void delete(GenreDto genreDto) {
        genres.remove(genreDto.toDBO());
    }
}
