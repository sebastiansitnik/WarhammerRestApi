package WebService.Warhammer40k.Keyword;

import WebService.Warhammer40k.Articles.ArticleDTO;
import WebService.Warhammer40k.Articles.ArticleTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordTransformer {

    private final ArticleTransformation articleTransformation;

    @Autowired
    public KeywordTransformer(ArticleTransformation articleTransformation) {
        this.articleTransformation = articleTransformation;
    }

    public Keyword toKeyword(KeywordDTO dto){

        Keyword entity = new Keyword();

        entity.setId(dto.getId());
        entity.setKeyword(dto.getKeyword());

        entity.setArticle(articleTransformation.toEntity(dto.getArticleDTO()));

        return entity;

    }

    public KeywordDTO toDto(Keyword entity){

        KeywordDTO dto = new KeywordDTO();

        dto.setId(entity.getId());
        dto.setKeyword(entity.getKeyword());
        dto.setArticleDTO(articleTransformation.toDTO(entity.getArticle()));

        return dto;
    }

    public KeywordDTO keywordNameToDto(String keywordName, ArticleDTO articleDTO){

        KeywordDTO dto = new KeywordDTO();

        dto.setArticleDTO(articleDTO);
        dto.setKeyword(keywordName);

        return dto;

    }

}
