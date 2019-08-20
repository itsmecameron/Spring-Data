package com.springdata.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springdata.lookify.models.Song;
import com.springdata.lookify.repository.LookifyRepository;

@Service
public class LookifyServices {
	// variable to call all methods in repository
	// adding the book repository as a dependency
	private LookifyRepository lookifyRepo;

	public LookifyServices(LookifyRepository lookifyRepo) {
		this.lookifyRepo = lookifyRepo;
	}

	// returns all the songs
	public List<Song> allSong() {
		return this.lookifyRepo.findAll();
	}
	
	// creates a song and is also a method to use to update a song
	public Song createOrUpdateSong(Song s) {
//		System.out.println(b.getVersion());
//		Lookify l = lookifyRepo.save(b);
//		System.out.println(l.getVersion());
//		return l;
		return lookifyRepo.save(s);
		
	}

	// retrieves a song
	public Song findSong(Long id) {
		Optional<Song> optionalSong = lookifyRepo.findById(id); // Optional means that it could exist or not
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}

	public void deleteSong(Long id) {
		// TODO Auto-generated method stub
		lookifyRepo.deleteById(id);
	}

	public List<Song> topTen() {
		// TODO Auto-generated method stub
		return lookifyRepo.findTop10ByOrderByRatingDesc();
	}

	public List<Song> searchSongs(String artist) {
		// TODO Auto-generated method stub
		return lookifyRepo.findByArtist(artist);}	
}