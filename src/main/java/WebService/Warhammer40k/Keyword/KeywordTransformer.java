package WebService.Warhammer40k.Keyword;

import WebService.Warhammer40k.Articles.Article;
import WebService.Warhammer40k.Articles.ArticleDTO;
import WebService.Warhammer40k.Articles.ArticleTransformation;
import WebService.Warhammer40k.Articles.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class KeywordTransformer {

    private final ArticlesRepository articlesRepository;

    @Autowired
    public KeywordTransformer(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public Keyword toKeyword(KeywordDTO dto){

        Keyword entity = new Keyword();

        entity.setId(dto.getId());
        entity.setKeyword(dto.getKeyword());

        entity.setArticle(articlesRepository.findById(dto.getArticleID()).orElseThrow(NoSuchElementException::new));

        return entity;

    }


    public KeywordDTO toDto(Keyword entity){

        KeywordDTO dto = new KeywordDTO();

        dto.setId(entity.getId());
        dto.setKeyword(entity.getKeyword());
        dto.setArticleID(entity.getId());

        return dto;
    }

    public KeywordDTO keywordNameToDto(String keywordName, ArticleDTO articleDTO){

        KeywordDTO dto = new KeywordDTO();

        dto.setArticleID(articleDTO.getId());
        dto.setKeyword(keywordName);

        return dto;

    }

}
