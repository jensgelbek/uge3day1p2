/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class MovieDTO {
    private Long id;
    private int year;
    private String title;
    private String[] actors;

    public MovieDTO(Long id,int year,String title,String[] actors) {
        this.id=id;
        this.title=title;
        this.year=year;
        this.actors=actors;
        
    }
    
    public static List<MovieDTO> getDtos(List<Movie> rms){
        List<MovieDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new MovieDTO(rm)));
        return rmdtos;
    }


    public MovieDTO(Movie rm) {
        this.id = rm.getId();
        this.title=rm.getTitle();
        this.year=rm.getYear();
        this.actors=rm.getActors();
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "MovieDTO{" + "id=" + id + ", year=" + year + ", title=" + title + ", actors=" + actors + '}';
    }

   
    
    
    
    
    
    
}
