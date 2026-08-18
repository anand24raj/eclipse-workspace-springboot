package com.nt.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "RECIPE_BOOK")
@NoArgsConstructor
@AllArgsConstructor
public class RecipeBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long recipeId;

	@Column(name = "RECIPE_NAME", length = 20)
	private String recipeName;

	@Column(name = "CUISINE", length = 20)
	private String cuisine;

	@ToString.Exclude
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name = "RECIPE_INGREDIENTS",
			joinColumns = @JoinColumn(name = "RECIPE_ID")
	)
	@Column(name = "INGREDIENTS", length = 30)
	private List<String> ingredients;

	@ToString.Exclude
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name = "RECIPE_COOKINGTIPS",
			joinColumns = @JoinColumn(name = "RECIPE_ID")
	)
	@Column(name = "COOKINGTIPS", length = 30)
	private Set<String> cookingTips;
}