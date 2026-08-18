package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ARTIST")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_seq")
	@SequenceGenerator(name = "artist_seq", sequenceName = "ARTIST_SEQ", initialValue = 100, allocationSize = 1)
	@Column(name = "ARTIST_ID")
	private Long artistId;

	@Column(name = "ARTIST_NAME", length = 30)
	private String artistName;

	@Column(name = "GENRE", length = 30)
	private String genre;

	@Column(name = "COUNTRY", length = 30)
	private String country;

	@Column(name = "EXPERIENCE_YEARS")
	private Integer experienceYears;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "ARTIST_FESTIVAL",
			joinColumns = @JoinColumn(name = "ARTIST_ID"),
			inverseJoinColumns = @JoinColumn(name = "FESTIVAL_ID"))
	private Set<Festival> festivals = new HashSet<>();

	public Artist(String artistName, String genre, String country, Integer experienceYears) {
		this.artistName = artistName;
		this.genre = genre;
		this.country = country;
		this.experienceYears = experienceYears;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", genre=" + genre + ", country="
				+ country + ", experienceYears=" + experienceYears + "]";
	}
}