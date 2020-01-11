package com.cognizant.moviecruiser.dao;
import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoSqlTest {

	public static void testaddFavoritesMovies() {

		Long userId = 2l;
		Long movieId = 5l;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.addFavoritesMovies(userId, movieId);
		System.out.println("Item added successfully");
	}

	public static void testgetAllFavoritesMovies() throws FavoritesEmptyException {

		long userId = 1l;
		FavoritesDaoSqlImpl favoriteDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites t = favoriteDaoSqlImpl.getAllFavoritesMovies(userId);
		System.out.println(t.getMovieList());
		System.out.println("--------------");
		System.out.println("Number of Rows:" + t.getTotal());
	}

	public static void testremoveFavoritesMovies() {

		Long userId = 2l;
		Long movieId = 5l;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.removeFavoritesMovies(userId, movieId);
		System.out.println("Item removed successfully");

	}

	public static void main(String[] args) throws FavoritesEmptyException {

		testaddFavoritesMovies();
		testgetAllFavoritesMovies();
		testremoveFavoritesMovies();

	}
}
