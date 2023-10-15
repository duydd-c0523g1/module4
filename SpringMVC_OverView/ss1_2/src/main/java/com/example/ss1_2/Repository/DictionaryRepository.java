package com.example.ss1_2.Repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> wordMap = new HashMap<>();

    static {
        wordMap.put("dog", "Con chó");
        wordMap.put("cat", "Con mèo");
        wordMap.put("apple", "Quả táo");
        wordMap.put("turtle", "Con rùa");
        wordMap.put("bottle", "Cái bình");
        wordMap.put("laptop", "Máy tính xách tay");
        wordMap.put("coffee", "Cà phê");
        wordMap.put("class", "Lớp");
        wordMap.put("glass", "Tấm kính");
        wordMap.put("ring", "Chiếc nhẫn");
    }

    @Override
    public String translate(String word) {
        return word != null ? wordMap.getOrDefault(word.toLowerCase(), "Từ này chưa có trong từ điển") : "Từ này chưa có trong từ điển";
    }
}
