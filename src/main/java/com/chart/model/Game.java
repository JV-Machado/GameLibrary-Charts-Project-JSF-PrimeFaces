package com.chart.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_game")
public class Game implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name="game_genre")
	private String genre;
	
	@Column(name="release_year")
	private Integer releaseYear;
	
//	@ManyToMany
//	@JoinTable(name="tb_console_game", 
//		joinColumns = @JoinColumn(name="game_id"), 
//		inverseJoinColumns = @JoinColumn(name="console_id"))
//	private GameConsole gameConsole;
	
	@ManyToOne
	@JoinColumn(name="game_console_id")
	private GameConsole gameConsole;
	
	public Game() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public GameConsole getGameConsole() {
		return gameConsole;
	}

	public void setGameConsole(GameConsole gameConsole) {
		this.gameConsole = gameConsole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
	
}