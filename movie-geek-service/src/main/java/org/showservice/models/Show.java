package org.showservice.models;

import org.showservice.models.*;
import jakarta.persistence.*;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "runtime")
    private String runtime;

    @Column(name = "seasons")
    private int seasons;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "imdb_score")
    private int imdbScore;

    @Column(name = "trend_score")
    private int trendScore;

    @Column(name = "genre")
    private String genre;

    @Column(name = "color_theme")
    private String colorTheme;

    public Show() {
    }

    public Show(int id) {
        this.id = id;
    }

    public Show(String title, String runtime, int seasons, int releaseYear, int imdbScore, int trendScore, String genre, String colorTheme) {
        this.title = title;
        this.runtime = runtime;
        this.seasons = seasons;
        this.releaseYear = releaseYear;
        this.imdbScore = imdbScore;
        this.trendScore = trendScore;
        this.genre = genre;
        this.colorTheme = colorTheme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(int imdbScore) {
        this.imdbScore = imdbScore;
    }

    public int getTrendScore() {
        return trendScore;
    }

    public void setTrendScore(int trendScore) {
        this.trendScore = trendScore;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(String colorTheme) {
        this.colorTheme = colorTheme;
    }
}


