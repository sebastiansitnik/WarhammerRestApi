package WebService.Warhammer40k.Category;

import WebService.Warhammer40k.Articles.Article;
import WebService.Warhammer40k.Articles.ArticleDTO;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


public class CategoryDTO {

    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String URL;

    private List<ArticleDTO> articlesDTO = new ArrayList<>();

    public CategoryDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public List<ArticleDTO> getArticlesDTO() {
        return articlesDTO;
    }

    public void setArticlesDTO(List<ArticleDTO> articlesDTO) {
        this.articlesDTO = articlesDTO;
    }
}
