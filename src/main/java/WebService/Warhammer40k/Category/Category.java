package WebService.Warhammer40k.Category;

import WebService.Warhammer40k.Articles.Article;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@NamedEntityGraph(
        name = "graph.Articles",
        attributeNodes = @NamedAttributeNode("articles")
)

@Entity
public class Category {

    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String URL;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Article> articles = new ArrayList<>();

    public Category() {
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
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
}
