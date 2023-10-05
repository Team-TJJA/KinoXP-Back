package com.example.kinoxpback.model;

import com.example.kinoxpback.enums.AgeLimit;
import com.example.kinoxpback.enums.MovieCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieID;
    @Column(name = "title")
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private MovieCategory category;
    @Enumerated(EnumType.STRING)
    @Column(name = "age_limit")
    private AgeLimit ageLimit;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "photo")
    private String photo;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Showing> showing;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieCategory getCategory() {
        return category;
    }

    public void setCategory(MovieCategory category) {
        this.category = category;
    }

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Set<Showing> getShowing() {
        return showing;
    }

    public void setShowing(Set<Showing> showing) {
        this.showing = showing;
    }

}
