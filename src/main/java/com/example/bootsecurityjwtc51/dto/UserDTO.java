package com.example.bootsecurityjwtc51.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private String country;

//	@JsonFormat(pattern = "yyyy-MM-dd")
//	private LocalDate birthDate;

	private int subscriberCounter;
}
