package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {
	public static final String ADD_MOVIE_TO_FAVORITE = "insert into favorite(fav_us_id,fav_mo_id)values(?,?)";
	public static final String GET_MOVIE = "select mo_id,mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from movie inner join favorite on fav_mo_id=mo_id where fav_us_id=?";
	public static final String GET_COUNT_FAVORITE = "select count(fav_id) as Favorite_count from favorite;";
	public static final String REMOVE_MOVIE_TO_FAVORITE = "delete from favorite where fav_us_id=? and fav_mo_id=?  limit 1";

	@Override
	public void addFavoritesMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_MOVIE_TO_FAVORITE);
			statement.setLong(1, userId);
			statement.setLong(2, moviesId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of rows affected:" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Data not inserted");
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Favorites getAllFavoritesMovies(long userId) throws FavoritesEmptyException {

		Favorites favorites = new Favorites();
		ArrayList<Movies> FavoriteMovie = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		try {
			statement = connection.prepareStatement(GET_MOVIE);
			statement.setLong(1, userId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				FavoriteMovie.add(movies);
			}
			statement1 = connection.prepareStatement(GET_COUNT_FAVORITE);
			resultSetTotal = statement1.executeQuery();
			if (FavoriteMovie.size() == 0) {

				throw new FavoritesEmptyException();
			}
			while (resultSetTotal.next()) {
				favorites.setTotal((int) resultSetTotal.getDouble("Favorite_count"));
			}
			favorites.setMovieList(FavoriteMovie);
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (statement1 != null)
					statement1.close();
				if (resultSetTotal != null)
					resultSetTotal.close();
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return favorites;
	}

	@Override
	public void removeFavoritesMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(REMOVE_MOVIE_TO_FAVORITE);
			statement.setLong(1, userId);
			statement.setLong(2, moviesId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of rows affected:" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Data not inserted");
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
