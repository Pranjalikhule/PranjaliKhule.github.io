package com.cognizant.moviecruiser.model;

import java.util.Date;

import com.cognizant.moviecruiser.util.DateUtil;

public class Movies {
	private Long id;
	private String title;
	private Long gross;
	private Boolean active;
	private Date dateOfLaunch;
	private String genre;
	private Boolean hasTeaser;

	public Movies() {
		super();

	}

	public Movies(Long id, String title, Long gross, Boolean active, Date dateOfLaunch, String genre,
			Boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.gross = gross;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getGross() {
		return gross;
	}

	public void setGross(Long gross) {
		this.gross = gross;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Boolean getHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(Boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", gross=" + gross + ", active=" + active + ", dateOfLaunch="
				+ new DateUtil().convertToString(dateOfLaunch) + ", genre=" + genre + ", Teaser=" + hasTeaser + "]";
	}

}
