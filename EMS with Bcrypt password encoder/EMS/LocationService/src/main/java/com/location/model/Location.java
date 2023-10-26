package com.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collation = "locations")
@Entity
@Table(name = "Location")
public class Location {
	@Id
	private int locationId;
	private String locationName;

}
