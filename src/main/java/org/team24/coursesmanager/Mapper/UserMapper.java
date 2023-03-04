package org.team24.coursesmanager.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.team24.coursesmanager.dto.UserDTO;
import org.team24.coursesmanager.entity.User;
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "totalGrade", target = "totalGrade")
   // @Mapping(source = "role", target = "role")
    UserDTO userToUserDTO(User user);



}
