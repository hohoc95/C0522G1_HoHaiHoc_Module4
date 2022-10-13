package com.dictionary.repository.impl;

import com.dictionary.model.Dictionary;
import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static List<Dictionary> dictionaries = new ArrayList<>();

    static {
        dictionaries.add(new Dictionary("i", "anh"));
        dictionaries.add(new Dictionary("love", "yêu"));
        dictionaries.add(new Dictionary("you", "em"));
        dictionaries.add(new Dictionary("forever", "mãi mãi"));
        dictionaries.add(new Dictionary("endless", "vĩnh cữu"));
        dictionaries.add(new Dictionary("lovesickness", "tương tư"));
        dictionaries.add(new Dictionary("depression", "trầm cảm"));
    }

    @Override
    public String search(String word) {
        for (Dictionary dic : dictionaries) {
            if (word.toLowerCase().equals(dic.getEnglish())) {
                return dic.getVietnamese();
            }
        }
        return "not found!";
    }
}