package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public interface FavoritesDao {

	public void addFavoritesMovies(long userId, long moviesId);

	public Favorites getAllFavoritesMovies(long userId) throws FavoritesEmptyException;

	public void removeFavoritesMovies(long userID, long moviesId);

}
