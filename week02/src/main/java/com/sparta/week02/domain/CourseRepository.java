package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {//Course라는 녀석이고 id의 자료형으 롱형이다.
}
