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
//        dictionaries.add(new Dictionary("happiness ", "hạnh phúc"));
//        dictionaries.add(new Dictionary("sadness", "đau khổ"));
//        dictionaries.add(new Dictionary("confused ", "bối rối"));
//        dictionaries.add(new Dictionary("hope ", "hy vọng"));
//        dictionaries.add(new Dictionary("hopeless ", "tuyệt vọng"));
//        dictionaries.add(new Dictionary("pain ", "đau đớn"));
//        dictionaries.add(new Dictionary("depressive", "trầm cảm"));
//        dictionaries.add(new Dictionary("rescue ", "giải thoát"));

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