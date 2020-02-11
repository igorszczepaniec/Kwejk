package com.example.Kwejk.Repository;

import com.example.Kwejk.Model.File;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.LinkedList;
import java.util.List;


public interface FileRepository extends JpaRepository<File, Integer>, FileRepositoryCustom {



}
