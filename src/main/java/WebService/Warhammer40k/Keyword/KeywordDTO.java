package WebService.Warhammer40k.Keyword;

import WebService.Warhammer40k.Articles.Article;
import WebService.Warhammer40k.Articles.ArticleDTO;

public class KeywordDTO {

    private String id;
    private ArticleDTO articleDTO;
    private String keyword;

    public KeywordDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArticleDTO getArticleDTO() {
        return articleDTO;
    }

    public void setArticleDTO(ArticleDTO articleDTO) {
        this.articleDTO = articleDTO;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
