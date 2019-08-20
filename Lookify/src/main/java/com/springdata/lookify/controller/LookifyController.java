package com.springdata.lookify.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springdata.lookify.models.Song;
import com.springdata.lookify.services.LookifyServices;

@Controller
//@RequestMapping("/songs")
public class LookifyController {
	@Autowired
	LookifyServices lookifyServ;

	@GetMapping("/")
	public String home() {
		return "song/index.jsp";
	}

	@GetMapping("/dashboard")
	public String home(Model model, @ModelAttribute("newSongObject") Song song) {
		List<Song> allSong = lookifyServ.allSong();
		model.addAttribute("songs", allSong);
		return "song/dashboard.jsp";
	}

	@GetMapping("/songs/new")
	public String newSong(Model model) {
		model.addAttribute("newSongObject", new Song());
		return "song/new.jsp";
	}
	
	@PostMapping("/songs/process")
    public String createSong (@Valid @ModelAttribute("newSongObject") Song song, BindingResult results) {
		if(results.hasErrors()) {
			return "song/new.jsp";
		}
		lookifyServ.createOrUpdateSong(song);
		System.out.println(song.getTitle());
		return "redirect:/dashboard";
    }
	
	@GetMapping("/song/{song_id}/show")
    public String show(@PathVariable("song_id") Long id, Model model) {
    	Song song = lookifyServ.findSong(id);
    	model.addAttribute("Song", song);
    	return "song/show.jsp";
    }
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> songs = lookifyServ.topTen();
		model.addAttribute("Songs", songs);
		return "song/topTen.jsp";
	}
	
	@PostMapping("/search")
	public String search(Model model, HttpServletRequest request) {
		String artist = request.getParameter("searchArtist");
			List<Song> songs = lookifyServ.searchSongs(artist);
			model.addAttribute("Songs", songs);
			model.addAttribute("Artist", artist);
			return "song/search.jsp";

	}

	@DeleteMapping("/songs/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		lookifyServ.deleteSong(id);
		return "redirect:/dashboard";
	}
}
