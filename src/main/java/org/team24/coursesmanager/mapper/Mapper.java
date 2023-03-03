package org.team24.coursesmanager.mapper;

public interface Mapper<F, T> {

    T map(F object);
}
