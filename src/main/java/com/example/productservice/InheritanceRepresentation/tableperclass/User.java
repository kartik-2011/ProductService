package com.example.productservice.InheritanceRepresentation.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User  {
	@Id
	private long id;
	private String name;
	private String email;
	private String password;
}
