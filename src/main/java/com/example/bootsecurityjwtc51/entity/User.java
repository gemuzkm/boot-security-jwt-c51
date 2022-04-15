package com.example.bootsecurityjwtc51.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;

	private String country;
//	private LocalDate birthDate;

	private int subscriberCounter;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Role> roleList;

	@Enumerated(EnumType.STRING)
	private Status status;
}
