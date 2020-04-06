package com.company.lab4;

public class DomesticFilm implements FilmInteface{

    private String genre;
    private double length;

    public DomesticFilm(String genre, double length) {
        this.genre = genre;
        this.length = length;
    }

    private DomesticFilm(){}

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public double getLength() {
        return length;
    }
}
