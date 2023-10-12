package com.example.ss1_2.Service;

import com.example.ss1_2.Repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;
    @Override
    public String translate(String word) {
        return dictionaryRepository.translate(word);
    }
}
