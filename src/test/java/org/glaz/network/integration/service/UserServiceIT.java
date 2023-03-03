package org.glaz.network.integration.service;

import lombok.RequiredArgsConstructor;
import org.glaz.network.integration.IntegrationTestBase;
import org.junit.jupiter.api.Test;
import org.team24.coursesmanager.dto.UserReadDto;
import org.team24.coursesmanager.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase {

    private static final Long USER_1 = 1L;

    private final UserService userService;

    @Test
    void findAll() {
        List<UserReadDto> result = userService.findAll();
        assertThat(result).hasSize(5);
    }

    @Test
    void findById() {
        Optional<UserReadDto> maybeUser = userService.findById(USER_1);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals("Teacher1", user.getFirstname()));
    }
}
