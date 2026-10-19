package ru.vozzaeva.MyUiRestDbService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vozzaeva.MyUiRestDbService.entity.StudyGroup;

public interface StudyGroupRepository
        extends JpaRepository<StudyGroup, Long> {
}
