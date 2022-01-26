package WebService.Warhammer40k.Category;

import WebService.Warhammer40k.Articles.ArticleDTO;
import WebService.Warhammer40k.Articles.ArticleTransformation;
import WebService.Warhammer40k.Articles.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryTransformer {

    private final ArticlesService articlesService;

    @Autowired
    public CategoryTransformer(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    public Category toEntity(CategoryDTO categoryDTO){

        Category entity = new Category();

        entity.setId(categoryDTO.getId());
        entity.setName(categoryDTO.getName());
        entity.setURL(categoryDTO.getURL());
        entity.setArticles(categoryDTO.
                getArticlesDTO().stream()
                .map(articlesService::toEntity)
                .collect(Collectors.toList()));

        return entity;
    }

    public CategoryDTO toDTO(Category entity){
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(entity.getId());
        categoryDTO.setName(entity.getName());
        categoryDTO.setURL(entity.getURL());
        categoryDTO.setArticlesDTO(entity
                .getArticles().stream()
                .map(articlesService::toDTO)
                .collect(Collectors.toList()));

        return categoryDTO;
    }

    public Category toEntity(NewCategoryDTO newCategoryDTO){
        Category entity = new Category();

        entity.setId(newCategoryDTO.getName().replace(" ","_").toLowerCase());
        entity.setName(newCategoryDTO.getName());
        entity.setURL(newCategoryDTO.getName().replace(" ","").toLowerCase());
        entity.setArticles(new ArrayList<>());

        return entity;
    }

    public CategoryEditorDTO toCategoryEditorDTO(Category category){

        CategoryEditorDTO categoryEditorDTO = new CategoryEditorDTO();

        categoryEditorDTO.setId(category.getId());
        categoryEditorDTO.setName(category.getName());
        categoryEditorDTO.setUrl(category.getURL());

        return categoryEditorDTO;
    }


}
