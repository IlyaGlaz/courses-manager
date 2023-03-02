package org.team24.coursesmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team24.coursesmanager.dto.UserReadDto;
import org.team24.coursesmanager.dto.UserWriteDto;
import org.team24.coursesmanager.mapper.UserReadMapper;
import org.team24.coursesmanager.mapper.UserWriteMapper;
import org.team24.coursesmanager.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserWriteMapper userWriteMapper;

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .collect(toList());
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }

    public UserReadDto create(UserWriteDto userDto) {
        return Optional.of(userDto)
                .map(userWriteMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
