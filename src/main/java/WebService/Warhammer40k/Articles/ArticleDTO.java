package WebService.Warhammer40k.Articles;

import WebService.Warhammer40k.Keyword.KeywordDTO;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class ArticleDTO {


    private String id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @NotEmpty
    private String content;

    @NotEmpty
    private String date;

    @NotEmpty
    private List<KeywordDTO> keywordDTO = new ArrayList<>();

    @NotEmpty
    private String categoryId;

    @NotEmpty
    private String url;

    public ArticleDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<KeywordDTO> getKeywordDTO() {
        return keywordDTO;
    }

    public void setKeywordDTO(List<KeywordDTO> keywordDTO) {
        this.keywordDTO = keywordDTO;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
