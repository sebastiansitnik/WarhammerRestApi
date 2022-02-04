package WebService.Warhammer40k.Keyword;


import WebService.Warhammer40k.Articles.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeywordService {

    private final KeywordRepository keywordRepository;
    public final KeywordTransformer keywordTransformer;

    @Autowired
    public KeywordService(KeywordRepository keywordRepository, KeywordTransformer keywordTransformer) {
        this.keywordRepository = keywordRepository;
        this.keywordTransformer = keywordTransformer;
    }

    public List<KeywordDTO> setKeywords(List<KeywordDTO> keywordDTOS){

        List<Keyword> keywords = keywordDTOS.stream()
                .map(keywordTransformer::toKeyword)
                .collect(Collectors.toList());

        keywords = keywordRepository.saveAll(keywords);

        return keywords.stream()
                .map(keywordTransformer::toDto)
                .collect(Collectors.toList());
    }

    public KeywordDTO createKeyword(String keywordName, Article art){

        Keyword keyword = new Keyword();

        keyword.setKeyword(keywordName);
        keyword.setArticle(art);

        keywordRepository.save(keyword);

        return keywordTransformer.toDto(keyword);
    }



}
