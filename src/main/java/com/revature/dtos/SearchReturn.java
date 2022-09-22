package com.revature.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchReturn {
	
	private int id;
	private String email;
	private String firstName;
	private String lastName;

}
