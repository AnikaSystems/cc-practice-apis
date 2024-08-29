package com.anikasystems.files.service.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FilesRepositoryTest {
    @Autowired
    FilesRepository filesRepository;

    @Test
    public void testSaveFile() {
        long id = 1l;
        Optional<com.anikasystems.files.service.model.File> fileData = filesRepository.findById(id);
        if (fileData.isPresent()) {
            filesRepository.save(id);
        }
    }

}