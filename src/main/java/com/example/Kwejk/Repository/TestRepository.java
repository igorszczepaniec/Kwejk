package com.example.Kwejk.Repository;

import com.example.Kwejk.Model.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<File,Integer> {
    Page<File> findAll(Pageable pageable);
}
