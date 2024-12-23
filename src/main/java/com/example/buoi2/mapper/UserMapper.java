package com.example.buoi2.mapper;

import com.example.buoi2.dto.request.UserCreationRequest;
import com.example.buoi2.dto.request.UserUpdateRequest;
import com.example.buoi2.dto.response.UserResponse;
import com.example.buoi2.entity.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    @Mapping(source = "firstName", target = "lastName")
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
