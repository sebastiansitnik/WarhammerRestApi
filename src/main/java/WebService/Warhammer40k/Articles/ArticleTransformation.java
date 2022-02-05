package WebService.Warhammer40k.Articles;

import WebService.Warhammer40k.Category.Category;
import WebService.Warhammer40k.Category.CategoryRepository;
import WebService.Warhammer40k.Category.CategoryService;
import WebService.Warhammer40k.Category.CategoryTransformer;
import WebService.Warhammer40k.Keyword.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleTransformation {

    private final CategoryRepository categoryRepository;
    private final KeywordRepository keywordRepository;


    @Autowired
    public ArticleTransformation(CategoryRepository categoryRepository, KeywordRepository keywordRepository) {
        this.categoryRepository = categoryRepository;
        this.keywordRepository = keywordRepository;
    }

    private List<Keyword> addKeywordsToEntity(ArticleDTO articleDTO, Article article){

        List<Keyword> result = new ArrayList<>();

        for (KeywordDTO dto:articleDTO.getKeywordDTO()) {

            Keyword temp = new Keyword();
            temp.setArticle(article);
            temp.setKeyword(dto.getKeyword());
            temp.setId(dto.getId());

            result.add(temp);
        }

        return result;

    }



    public Article toEntity (ArticleDTO articleDTO){

        Article entity = new Article();

        entity.setId(articleDTO.getId());
        entity.setTitle(articleDTO.getTitle());
        entity.setAuthor(articleDTO.getAuthor());
        entity.setContent(articleDTO.getContent());
        entity.setDate(articleDTO.getDate());

        entity.setCategory(categoryRepository.findById(articleDTO.getCategoryId()).orElse(new Category()));
        entity.setURL(articleDTO.getUrl());

        entity.setKeywords(addKeywordsToEntity(articleDTO, entity));

        return entity;

    }

    public ArticleDTO toDTO (Article entity){

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setId(entity.getId());
        articleDTO.setTitle(entity.getTitle());
        articleDTO.setAuthor(entity.getAuthor());
        articleDTO.setContent(entity.getContent());
        articleDTO.setDate(entity.getDate());
        articleDTO.setCategoryId(entity.getCategory().getId());
        articleDTO.setUrl(entity.getURL());

        List<KeywordDTO> keywordDTOList = new ArrayList<>();

        for (Keyword keyword: entity.getKeywords()) {
            KeywordDTO keywordDTO = new KeywordDTO();
            keywordDTO.setKeyword(keyword.getKeyword());
            keywordDTO.setArticleID(entity.getId());
            keywordDTO.setId(keyword.getId());

            keywordDTOList.add(keywordDTO);
        }

        articleDTO.setKeywordDTO(keywordDTOList);

        return articleDTO;
    }

    public Article toEntity (NewArticleDTO dto){

        Article entity = new Article();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setContent(dto.getContent());
        entity.setDate(dto.getDate());
        entity.setKeywords(new ArrayList<>());
        entity.setCategory(categoryRepository.findById(dto.getCategoryId()).orElse(new Category()));
        entity.setURL(dto.getUrl());

        return entity;

    }
}
