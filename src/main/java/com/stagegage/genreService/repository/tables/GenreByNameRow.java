package com.stagegage.genreService.repository.tables;

import com.stagegage.genreService.dto.GenreDto;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Scott on 7/12/14.
 *
 * @author Scott Hendrickson
 */
@Table("genres_by_name")
public class GenreByNameRow {

    @PrimaryKey
    private final String genre;

    @Column
    private final UUID id;

    public GenreByNameRow(String name, UUID id) {
        this.genre = name;
        this.id = id;
    }

    public static GenreDto toDto(GenreByNameRow genreByNameRow) {
        return new GenreDto(genreByNameRow.getId(), genreByNameRow.getGenre());
    }

    public static List<GenreDto> toDto(List<GenreByNameRow> genreRows) {
        if(genreRows == null) return null;

        List<GenreDto> dtos = new ArrayList<GenreDto>();
        for (GenreByNameRow row : genreRows) {
            dtos.add(toDto(row));
        }

        return dtos;
    }

    public String getGenre() {
        return genre;
    }

    public UUID getId() {
        return id;
    }
}
