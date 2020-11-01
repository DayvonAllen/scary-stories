package com.dna.dev.userservice.api.v1.mapper;

import com.dna.dev.userservice.api.v1.domain.UserDto;
import com.dna.dev.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto userToUserDtoMapper(User user) {
        if(user == null){
            return null;
        }
        return new UserDto(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getLastLoginDate(),
                user.getJoinDate(),
                user.getRole(),
                user.getActive(),
                user.getUnlocked());
    }

    @Override
    public User userDtoToUserMapper(UserDto userDto) {
        if(userDto == null){
            return null;
        }
        return new User(userDto.getId(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getLastLoginDate(),
                userDto.getJoinDate(),
                userDto.getRole(),
                userDto.getActive(),
                userDto.getUnlocked());
    }
}
