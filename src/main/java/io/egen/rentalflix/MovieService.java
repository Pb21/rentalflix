package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {

	public Map<Integer, Movie> movieList = new ConcurrentHashMap<Integer,Movie>();
	
	public Map<Integer, Movie> getList(){
		return movieList;
	}
	/**
	 * Finds all available movies in the movie store
	 * @return list of movies or empty list
	 */
	public List<Movie> findAll (){
		Collection movieSet= movieList.values();
		List<Movie> ms = new ArrayList<Movie>();
		ms.addAll(movieSet);
		return ms;
	}
	
	/**
	 * Finds all movies in the movie store which contains <strong>name</strong> in the title
	 * @param name String
	 * @return list of movies or empty list
	 */
	public List<Movie> findByName (String name){
		
		Collection<Movie> movieSet= movieList.values();
		Iterator it = movieSet.iterator();
		List<Movie> matchingMovies = new ArrayList<Movie>();		
		while(it.hasNext()){
			Movie m = (Movie)it.next();
			if(m.getTitle().equalsIgnoreCase(name)){
				matchingMovies.add(m);
			}
		}
		return matchingMovies;
	}
	
	/**
	 * Create a new movie in the movie store
	 * @param movie
	 * @return Movie
	 */
	public Movie create (Movie movie){
		
		Movie m = new Movie(movie);
		movieList.put(m.getId(),m);
		return m;
	}
	
	/**
	 * Update an existing movie
	 * @param movie
	 * @return updated movie or throws <strong>IllegalArgumentException</strong> if movie with this id is not found
	 */
	public Movie update (Movie movie) throws IllegalArgumentException{
		int id =  movie.getId();
		
		if(movieList.containsKey(id)){		
			movieList.put(id,movie);
			return movie;
		}else{
			throw new IllegalArgumentException("Movie not found for update");
		}
	}
	
	/**
	 * Delete an existing movie 
	 * @param id
	 * @return deleted movie or throws <strong>IllegalArgumentException</strong> if movie with this id is not found
	 */
	public Movie delete (int id) throws IllegalArgumentException{
		if(movieList.containsKey(id)){
			Movie m = movieList.get(id);
			movieList.remove(m);
			return m;
		}else{
			throw new IllegalArgumentException("Movie not found");
		}
	}
	
	/**
	 * Rent the movie with movieId to the <strong>user</strong>.
	 * Make sure this movie is not rented already. 
	 * If it is already rented, throw <strong>IllegalArgumentException</strong>
	 * @param movieId
	 * @param user
	 * @return true: if movie can be rented, false otherwise
	 */
	public boolean rentMovie (int movieId, String user){
		if(movieList.containsKey(movieId)){
			Movie m = movieList.get(movieId);
			movieList.remove(m);
			return true;
		}else{
			return false;
		}
	}


}
