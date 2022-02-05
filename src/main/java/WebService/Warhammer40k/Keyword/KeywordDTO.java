package WebService.Warhammer40k.Keyword;

import WebService.Warhammer40k.Articles.Article;
import WebService.Warhammer40k.Articles.ArticleDTO;

public class KeywordDTO {

    private String id;
    private String articleID;
    private String keyword;

    public KeywordDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
