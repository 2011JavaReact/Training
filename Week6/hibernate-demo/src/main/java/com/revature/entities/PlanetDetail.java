package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "planet_detail")
//@NamedQueries({@NamedQuery(name = "PlanetDetail_getAssociatedPlanet", query = "SELECT p from Planet p JOIN p.planetDetail pd WHERE pd.id = :pdi")})
public class PlanetDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "planet_detail_id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "atmosphere")
	private String atmosphere;
	
//	@OneToOne(mappedBy = "planetDetail")
//	private Planet planet;
	
	public PlanetDetail() {
		super();
	}

	public PlanetDetail(String description, String atmosphere) {
		super();
		this.description = description;
		this.atmosphere = atmosphere;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}

	@Override
	public String toString() {
		return "PlanetDetail [id=" + id + ", description=" + description + ", atmosphere=" + atmosphere + "]";
	}

}
