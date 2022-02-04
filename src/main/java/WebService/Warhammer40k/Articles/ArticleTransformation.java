package WebService.Warhammer40k.Articles;

import WebService.Warhammer40k.Category.Category;
import WebService.Warhammer40k.Category.CategoryRepository;
import WebService.Warhammer40k.Category.CategoryService;
import WebService.Warhammer40k.Category.CategoryTransformer;
import WebService.Warhammer40k.Keyword.Keyword;
import WebService.Warhammer40k.Keyword.KeywordRepository;
import WebService.Warhammer40k.Keyword.KeywordService;
import WebService.Warhammer40k.Keyword.KeywordTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleTransformation {

    private final CategoryRepository categoryRepository;
    private final KeywordRepository keywordRepository;

    private final KeywordTransformer keywordTransformer = new KeywordTransformer(this);



    @Autowired
    public ArticleTransformation(CategoryRepository categoryRepository, KeywordRepository keywordRepository) {
        this.categoryRepository = categoryRepository;
        this.keywordRepository = keywordRepository;
    }



    public Article toEntity (ArticleDTO articleDTO){

        Article entity = new Article();

        entity.setId(articleDTO.getId());
        entity.setTitle(articleDTO.getTitle());
        entity.setAuthor(articleDTO.getAuthor());
        entity.setContent(articleDTO.getContent());
        entity.setDate(articleDTO.getDate());
        entity.setKeywords(articleDTO.getKeywordDTO().stream()
                .map(keywordTransformer::toKeyword)
                .collect(Collectors.toList()));
        entity.setCategory(categoryRepository.findById(articleDTO.getCategoryId()).orElse(new Category()));
        entity.setURL(articleDTO.getUrl());

        return entity;

    }

    public ArticleDTO toDTO (Article entity){

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setId(entity.getId());
        articleDTO.setTitle(entity.getTitle());
        articleDTO.setAuthor(entity.getAuthor());
        articleDTO.setContent(entity.getContent());
        articleDTO.setDate(entity.getDate());
        articleDTO.setKeywordDTO(entity.getKeywords().stream()
                .map(keywordTransformer::toDto)
                .collect(Collectors.toList()));
        articleDTO.setCategoryId(entity.getCategory().getId());
        articleDTO.setUrl(entity.getURL());

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
