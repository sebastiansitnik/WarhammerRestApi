package WebService.Warhammer40k.Articles;

import WebService.Warhammer40k.Category.Category;
import WebService.Warhammer40k.Category.CategoryRepository;
import WebService.Warhammer40k.Category.CategoryService;
import WebService.Warhammer40k.Category.CategoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleTransformation {

    private final CategoryRepository categoryRepository;

    @Autowired
    public ArticleTransformation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Article toEntity (ArticleDTO articleDTO){

        Article entity = new Article();

        entity.setId(articleDTO.getId());
        entity.setTitle(articleDTO.getTitle());
        entity.setAuthor(articleDTO.getAuthor());
        entity.setContent(articleDTO.getContent());
        entity.setDate(articleDTO.getDate());
        entity.setKeyword(articleDTO.getKeyword());
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
        articleDTO.setKeyword(entity.getKeyword());
        articleDTO.setCategoryId(entity.getCategory().getId());
        articleDTO.setUrl(entity.getURL());

        return articleDTO;
    }
}
