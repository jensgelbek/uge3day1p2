package facades;

import dtos.MovieDTO;
import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MovieFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
   
    public MovieDTO create(MovieDTO md){
        Movie me = new Movie(md.getYear(),md.getTitle(),md.getActors());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(me);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new MovieDTO(me);
    }
     
    public MovieDTO getByName(String name){
        EntityManager em = emf.createEntityManager();
        Movie m;
        try {
            TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.title=:title", Movie.class);
            query.setParameter("title", name);
            m=query.getSingleResult();
        } finally {
            em.close();
        }
        return new MovieDTO(m);
    }
    
    public MovieDTO getById(int id){
        EntityManager em = emf.createEntityManager();
        Movie m;
        try {
            TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.id=:id", Movie.class);
            query.setParameter("id", id);
            m=query.getSingleResult();
        } finally {
            em.close();
        }
        return new MovieDTO(m);
    }
    public List<MovieDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        
        try {
            TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m",Movie.class);
            return MovieDTO.getDtos(query.getResultList());
        } finally {
            em.close();
        }
    
    }
     public void populate(){
        Populator.populate();
    
    }
    /*
    public MovieDTO getById(long id){
        EntityManager em = emf.createEntityManager();
        return new MovieDTO(em.find(Movie.class, id));
    }
    
    //TODO Remove/Change this before use
    public long getRenameMeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }
    
    public List<RenameMeDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Movie> query = em.createQuery("SELECT r FROM RenameMe r", Movie.class);
        List<Movie> rms = query.getResultList();
        return MovieDTO.getDtos(rms);
    }
   
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade fe = getMovieFacade(emf);
       // fe.getAll().forEach(dto->System.out.println(dto));
    }
 */
}
