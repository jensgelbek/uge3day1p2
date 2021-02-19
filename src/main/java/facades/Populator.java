/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.MovieDTO;
import entities.Movie;
import java.lang.reflect.Array;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade fe = MovieFacade.getMovieFacade(emf);
      
        fe.create(new MovieDTO(new Movie(1971,"det",new String[]{"frd","gfd"})));
              fe.create(new MovieDTO(new Movie(1971,"dat",new String[]{"f","gd"})));
              fe.create(new MovieDTO(new Movie(1977,"dut",new String[]{"d","fd"})));
              fe.create(new MovieDTO(new Movie(1979,"dit",new String[]{"rd","d"})));

    }
    
    public static void main(String[] args) {
        populate();
    }
}
