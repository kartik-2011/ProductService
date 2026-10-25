package com.example.productservice.InheritanceRepresentation.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_TA")
public class TA extends User {
	private int numberOfSessions;
	private double avgRating; 
}
