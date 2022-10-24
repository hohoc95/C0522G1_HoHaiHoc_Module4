package com.example.controller;

import com.example.dto.SongDto;
import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
    public ModelAndView showUserList(@PageableDefault(value = 5) Pageable pageable){
        return new ModelAndView("list", "songList", iSongService.findAll(pageable));
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songList", iSongService.findAll());
        model.addAttribute("song", new Song());
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute SongDto songDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new SongDto().validate(songDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/create";
        } else {
            Song user = new Song();
            BeanUtils.copyProperties(songDto, user);

            iSongService.save(user);
            redirectAttributes.addFlashAttribute("mess", "Add new successful!");
            return "redirect:/";
        }
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("song", iSongService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String updateSong(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("mess", "update successful");
        return "redirect:/";
    }


}
