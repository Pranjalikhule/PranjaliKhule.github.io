package com.cognizant.moviecruiser.dao;

import java.util.List;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {
	public static void testGetMovieListAdmin() {
		System.out.println("Item List for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMovieListAdmin();
		for (Movies movie : movieList) {
			System.out.println(movie);
		}
	}

	public static void testGetMovieListCustomer() {
		System.out.println("Item List for Customer");
		MoviesDao movieDao = new  MoviesDaoCollectionImpl();
		List<Movies> movieList = movieDao.getMovieListCustomer();
		for (Movies movie : movieList) {
			System.out.println(movie);
		}
	}

	public static void testModifyMovieList() {
		Movies item = new Movies(5L, "Avengers", 1333333333L, true, new DateUtil().convertToDate("02/11/2022"),
				"Superhero", true);
		MoviesDao movieDao = new  MoviesDaoCollectionImpl();
		movieDao.modifyMovie(item);
		System.out.println("** Modified Menu Item List**");
		testGetMovieListAdmin();
		Movies modified_item = movieDao.getMovie(item.getId());
		System.out.println("Modified Item Detail\n" + modified_item);
	}

	public static void main(String[] args) {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovieList();
	}

}
