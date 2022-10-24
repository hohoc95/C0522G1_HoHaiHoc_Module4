package com.example.service;

import com.example.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Page<Song> findAll(Pageable pageable);
    void save(Song song);
    void update(Song song);
    void remove(int id);
    Song findById(int id);
}
