package com.nt.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "FESTIVAL")
public class Festival {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "festival_seq")
	@SequenceGenerator(name = "festival_seq", sequenceName = "FESTIVAL_SEQ", initialValue = 100, allocationSize = 1)
	@Column(name = "FESTIVAL_ID")
	private Long festivalId;

	@Column(name = "FESTIVAL_NAME", length = 30)
	private String festivalName;

	@Column(name = "CITY", length = 30)
	private String city;

	@Column(name = "EVENT_DATE")
	private LocalDate eventDate;

	@Column(name = "TICKET_PRICE")
	private Double ticketPrice;

	@ManyToMany(mappedBy = "festivals")
	private Set<Artist> artists = new HashSet<>();

	public Festival(String festivalName, String city, LocalDate eventDate, Double ticketPrice) {
		this.festivalName = festivalName;
		this.city = city;
		this.eventDate = eventDate;
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "Festival [festivalId=" + festivalId + ", festivalName=" + festivalName + ", city=" + city
				+ ", eventDate=" + eventDate + ", ticketPrice=" + ticketPrice + "]";
	}
}