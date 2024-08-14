package com.anikasystems.files.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.files.service.model.File;
import java.util.List;
import java.util.Optional;

public interface FilesRepository extends JpaRepository<File, Long> {
    Optional<File> findById(long id);
    List<File> findByLastName(String lastName);
    List<File> findByPublished(boolean published);
    List<File> findByTitleContainingIgnoreUser(String title);
    public void save(long id);
}