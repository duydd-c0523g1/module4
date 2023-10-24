package com.validate_songs.controller;

import com.validate_songs.model.Song;
import com.validate_songs.model.SongDTO;
import com.validate_songs.service.IGenreService;
import com.validate_songs.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class SongController {
    @Autowired
    private ISongService songService;
    @Autowired
    private IGenreService genreService;
    @GetMapping("")
    public ModelAndView showAddSongPage(Model model) {
        model.addAttribute("genreList", genreService.findAllGenre());
        return new ModelAndView("home", "songDTO", new SongDTO());
    }
    @PostMapping("/add")
    public ModelAndView addNewSong(@Validated @ModelAttribute SongDTO songDTO, BindingResult bindingResult,
                      Model model, RedirectAttributes redirectAttributes) {
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("genreList", genreService.findAllGenre());
            return new ModelAndView("redirect:/", "songDTO", new SongDTO());
        } else {
            songService.addNewSong(song);
            redirectAttributes.addFlashAttribute("msg", "Success!");
            return new ModelAndView("redirect:/", "songDTO", new SongDTO());
        }
    }
}
