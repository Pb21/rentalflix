package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * JUnit test cases for MovieService
 */
@SuppressWarnings("deprecation")
public class MovieServiceTest {

	private MovieService ms = null;
	
	@Before
	public void initialize(){
		ms = new MovieService();
		createMovieList();
	}
	
	
	@Test
	public void  findByNameTest(){
		
		List<Movie> list = new ArrayList();
		
		Movie m4 = new Movie(4,"Airlift",2016,"Hindi");
		Movie m5 = new Movie(5,"Airlift",1987,"English");
		list.add(m4);
		list.add(m5);
		Assert.assertEquals(list,ms.findByName("Airlift"));
		
		list = new ArrayList();
		Movie m3 = new Movie(3,"Kung Fu Panda",2016,"English");
		list.add(m3);
		Assert.assertEquals(list,ms.findByName("Kung Fu Panda"));
	}
	

	@Test	
	public void findAllTest(){
	
		List<Movie> allList = processInputOutput();
		Assert.assertEquals(allList,ms.findAll());
	}
	
		
	@Test
	public void createTest (){
		Movie m3 = new Movie(9,"Kung Fu Panda 12",2020,"English");
		Assert.assertEquals(m3,ms.create(m3));
	}
	
	@Test
	public void update (){
		Movie m1 = new Movie(1,"Terminator",2000,"English");
		Assert.assertEquals(m1,ms.update(m1));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void updateTestException (){
		Movie m1 = new Movie(190,"Terminator",2000,"English");
	//	Assert.assertEquals(m1,ms.update(m1));
		ms.update(m1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deleteTestException (){
		//Movie m2 = new Movie(212,"Grease",1978,"English");
		//Assert.assertEquals(m2,);
		ms.delete(212);
	}
	
	
	@Test
	public void delete (){
		Movie m2 = new Movie(2,"Grease",1978,"English");
		Assert.assertEquals(m2,ms.delete(2));
		
	}
	
	@Test
	public void rentMovie (){
		Assert.assertEquals(true,ms.rentMovie(1,"Pb"));
		Assert.assertEquals(false,ms.rentMovie(31,"Pb"));
	}

	
	public void createMovieList(){
		
		Movie m1 = new Movie(1,"Terminator",2000,"English");
		Movie m2 = new Movie(2,"Grease",1978,"English");
		Movie m3 = new Movie(3,"Kung Fu Panda",2016,"English");
		Movie m4 = new Movie(4,"Airlift",2016,"Hindi");
		Movie m5 = new Movie(5,"Airlift",1987,"English");
		Movie m6 = new Movie(6,"Superman 1",2000,"English");
		Movie m7 = new Movie(7,"Superman 1",2000,"Hindi");
		Movie m8 = new Movie(8,"Superman 2",2010,"English");
	    ms.movieList.put(1,m1);
	    ms.movieList.put(2,m2);
	    ms.movieList.put(3,m3);
	    ms.movieList.put(4,m4);
	    ms.movieList.put(5,m5);
	    ms.movieList.put(6,m6);
	    ms.movieList.put(7,m7);
	    ms.movieList.put(8,m8);
	    
	}
	public List<Movie> processInputOutput(){
		Movie m1 = new Movie(1,"Terminator",2000,"English");
		Movie m2 = new Movie(2,"Grease",1978,"English");
		Movie m3 = new Movie(3,"Kung Fu Panda",2016,"English");
		Movie m4 = new Movie(4,"Airlift",2016,"Hindi");
		Movie m5 = new Movie(5,"Airlift",1987,"English");
		Movie m6 = new Movie(6,"Superman 1",2000,"English");
		Movie m7 = new Movie(7,"Superman 1",2000,"Hindi");
		Movie m8 = new Movie(8,"Superman 2",2010,"English");
		
	    List<Movie> expectedOutput = new ArrayList<Movie>();
	    expectedOutput.add(m1);
	    expectedOutput.add(m2);
	    expectedOutput.add(m3);
	    expectedOutput.add(m4);
	    expectedOutput.add(m5);
	    expectedOutput.add(m6);
	    expectedOutput.add(m7);
	    expectedOutput.add(m8);
	    return expectedOutput;
	}
}
