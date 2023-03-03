package org.team24.coursesmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.team24.coursesmanager.entity.Group;
import org.team24.coursesmanager.repository.GroupRepository;

@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Group getById(int id) {
        return groupRepository.findById(id).orElse(null);
    }
}
