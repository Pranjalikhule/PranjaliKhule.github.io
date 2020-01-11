package com.cognizant.moviecruiser.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoSqlTest {

	public static void testGetMovieListAdmin() {

		System.out.println("List of Admin:");
		List<Movies> moviesList = new MoviesDaoCollectionImpl().getMovieListAdmin();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,###,####");
		System.out.format("\n%15s%15s%15s%15s\t%15s%15s%15s\n", "ID", "TITLE", "BOX_OFFICE", " ACTIVE",
				"DATE_OF_LAUNCH", "GENRE", "HAS_TEASER");
		for (Movies movies : moviesList) {
			String date = sdf.format(movies.getDateOfLaunch());
			String gross = df.format(movies.getGross());
			System.out.format("%15d%15s%15s%15s\t%15s%15s%15s\n", movies.getId(), movies.getTitle(), gross,
					movies.getActive(), date, movies.getGenre(), movies.getHasTeaser());

		}
	}

	public static void testGetMovieListCustomer() {

		System.out.println("List of Customer:");
		List<Movies> moviesList = new MoviesDaoCollectionImpl().getMovieListCustomer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,###,####");
		System.out.format("\n%15s%15s%15s%15s\t%15s%15s%15s\n", "ID", "TITLE", "BOX_OFFICE", " ACTIVE",
				"DATE_OF_LAUNCH", "GENRE", "HAS_TEASER");
		for (Movies movies : moviesList) {
			String date = sdf.format(movies.getDateOfLaunch());
			String gross = df.format(movies.getGross());
			System.out.format("%15d%15s%15s%15s\t%15s%15s%15s\n", movies.getId(), movies.getTitle(), gross,
					movies.getActive(), date, movies.getGenre(), movies.getHasTeaser());

		}
	}

	public static void testModifyMovie() {

		System.out.println("Modify Movies Data:");
		Movies movies = new Movies(1L, "Tiger Zinda Hai", 555555555L, false, new DateUtil().convertToDate("27/12/2019"),
				"Thriller", true);
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		movieDaoSqlImpl.modifyMovie(movies);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,###,####");
		System.out.format("\n%15s%15s%15s%15s\t%15s%15s%15s\n", "ID", "TITLE", "BOX_OFFICE", " ACTIVE",
				"DATE_OF_LAUNCH", "GENRE", "HAS_TEASER");
		System.out.format("%15d%15s%15s%15s\t%15s%15s%15s\n", movies.getId(), movies.getTitle(),
				df.format(movies.getGross()), movies.getActive(), sdf.format(movies.getDateOfLaunch()),
				movies.getGenre(), movies.getHasTeaser());
	}

	public static Movies testGetMovie() {

		System.out.println("Get Data Details:");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###");
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		long movieId = 3;
		Movies movies = movieDaoSqlImpl.getMovie(movieId);
		System.out.format("\n%15s%15s%15s%15s\t%15s%15s%15s\n", "ID", "TITLE", "BOX_OFFICE", " ACTIVE",
				"DATE_OF_LAUNCH", "GENRE", "HAS_TEASER");
		System.out.format("%15d%15s%15s%15s\t%15s%15s%15s\n", movies.getId(), movies.getTitle(),
				df.format(movies.getGross()), movies.getActive(), sdf.format(movies.getDateOfLaunch()),
				movies.getGenre(), movies.getHasTeaser());
		System.out.println("--------");

		return movies;

	}

	public static void main(String[] args) {

		// testGetMovieListAdmin();
		testGetMovieListCustomer();
		// testModifyMovie();
		// testGetMovie();

	}

}
