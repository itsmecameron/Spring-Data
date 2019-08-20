package com.springdata.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springdata.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();

    void deleteById(Long id);

	List<Song> findTop10ByOrderByRatingDesc();

	List<Song> findByArtist(String artist);
}
