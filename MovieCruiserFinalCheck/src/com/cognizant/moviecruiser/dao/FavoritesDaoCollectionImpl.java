package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
		}
	}

	@Override
	public void addFavoritesMovies(long userId, long moviesId) {
		MoviesDao movieDao = new MoviesDaoCollectionImpl();
		Movies movies = movieDao.getMovie(moviesId);
		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getMovieList().add(movies);
		} else {
			Favorites favorites = new Favorites();
			ArrayList<Movies> movieList = new ArrayList<>();
			movieList.add(movies);
			favorites.setMovieList(movieList);
			userFavorites.put(userId, favorites);
		}
	}

	@Override
	public Favorites getAllFavoritesMovies(long userId) throws FavoritesEmptyException {
		// List<Movies> movieList = userFavorites.get(userId).getMovieList();
		Favorites favorites = userFavorites.get(userId);
		if (favorites == null || favorites.getMovieList().isEmpty()) {
			throw new FavoritesEmptyException();
		}
		return favorites;
	}

	@Override
	public void removeFavoritesMovies(long userId, long moviesId) {
		List<Movies> movieList = userFavorites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == moviesId) {
				movieList.remove(i);
				return;
			}
		}
	}
}
