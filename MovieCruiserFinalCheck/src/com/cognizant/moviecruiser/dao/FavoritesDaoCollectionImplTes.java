package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTes {
	int TotalFavorites = 0;

	public static void testAddFavoritesMovies() throws FavoritesEmptyException {

		FavoritesDao favoriteDao = new FavoritesDaoCollectionImpl();
		favoriteDao.addFavoritesMovies(1, 2L);
		favoriteDao.addFavoritesMovies(1, 5L);
		favoriteDao.addFavoritesMovies(2, 1L);
		favoriteDao.addFavoritesMovies(2, 3L);

		Favorites favorites = favoriteDao.getAllFavoritesMovies(1);
		List<Movies> movieListItem = favorites.getMovieList();
		System.out.println("User Added Favorites for CheckOut");
		for (Movies movies : movieListItem) {
			System.out.println(movies);
		}
		System.out.println("Total Favorites=" + movieListItem.size());
	}

	public static void testRemoveFavoritesMovies() {

		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("Item List for Customer after Remove");
		try {
			favoritesDao.removeFavoritesMovies(1, 2L);
			// favoritesDao.removeFavoritesMovies(1, 5L);
			Favorites favorites = favoritesDao.getAllFavoritesMovies(1);
			List<Movies> movieListItem = favorites.getMovieList();
			for (Movies movies : movieListItem) {
				System.out.println(movies);
			}
			System.out.println("Total Favorites=" + movieListItem.size());
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAddFavoritesMovies() {

	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoritesMovies();
		testRemoveFavoritesMovies();
	}

}
