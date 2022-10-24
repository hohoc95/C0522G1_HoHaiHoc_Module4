package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator{

    private int id;

    @NotBlank(message = "Tên bài hát không được để trống.")
    @Size(max = 800, message = "Tên bài hát không được quá 800 ký tự.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Tên bài hát không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String nameSong;

    @NotBlank(message = "Tên nghệ sĩ thể hiện không được để trống.")
    @Size(max = 300, message = "Tên nghệ sĩ thể hiện không được quá 300 ký tự.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Tên nghệ sĩ thể hiện không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String singer;

    @NotBlank(message = "Tên thể loại nhạc không được để trống.")
    @Size(max = 1000, message = "Tên thể loại nhạc không được quá 1000 ký tự.")
    @Pattern(regexp = "^[a-zA-Z0-9, ]*$", message = "Tên thể loại nhạc không chứa các kí tự đặc biệt (ngoại trừ dấu ',').")
    private String category;

    @NotBlank(message = "Link nhạc không được để trống.")
    private String link;

    public SongDto() {
    }

    public SongDto(int id, String nameSong, String singer, String category, String link) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if ("admin".equals(songDto.getNameSong())){
            errors.rejectValue("name", "name.forbidden", "Khong duoc la admin.");
        }
    }
}
