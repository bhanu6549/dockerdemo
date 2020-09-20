package com.mindtree.librarieswebapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarieswebapp.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

	Optional<Library> findByLibraryName(String libraryName);

}
