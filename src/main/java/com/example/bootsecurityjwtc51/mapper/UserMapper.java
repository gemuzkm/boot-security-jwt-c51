package com.example.bootsecurityjwtc51.mapper;

import com.example.bootsecurityjwtc51.dto.UserDTO;
import com.example.bootsecurityjwtc51.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

//	UserDTO toUserDTO(User user);
	User toUser(UserDTO userDTO);
//	List<UserDTO> toUserDTOList(List<User> users);
}
