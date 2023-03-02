package org.team24.coursesmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team24.coursesmanager.dto.UserReadDto;
import org.team24.coursesmanager.mapper.UserReadMapper;
import org.team24.coursesmanager.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }
}
