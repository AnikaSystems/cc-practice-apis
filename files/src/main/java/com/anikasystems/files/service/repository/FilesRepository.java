package com.anikasystems.files.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.files.service.model.File;

public interface FilesRepository extends JpaRepository<File, Long> {
    Optional<File> findById(long id);

    List<File> findByPublished(boolean published);

    public void save(long id);
}