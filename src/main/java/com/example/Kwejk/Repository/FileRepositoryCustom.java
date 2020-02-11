package com.example.Kwejk.Repository;

import com.example.Kwejk.Model.File;

import java.util.List;

public interface FileRepositoryCustom {
    List<File> findByCategoryId(Integer id);
    File findByTitle(String title);
    List<File> findByUserId(Integer id);
    List<File> findAllByUserId(Integer id);
}
