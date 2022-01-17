package WebService.Warhammer40k.Articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticlesController {

        private final ArticlesService articlesService;

    @Autowired
    public ArticlesController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

        @CrossOrigin(origins = "http://localhost:3000")
        @PostMapping
        public Article createArticle(@RequestBody Article art){
            return articlesService.createArticle(art);
        }

        @GetMapping
        public Article readArticle(@RequestParam String id){
            return articlesService.readArticleById(id);
        }

        @GetMapping("/all")
        public List<Article> readAllArticles(){
            return articlesService.readAll();
        }

        @PutMapping("/edit")
        public Article editArticle(@RequestBody Article article){
            return articlesService.editArticle(article);
        }

        @DeleteMapping("/delete")
        public Article deleteArticle(@RequestParam String id){
            return articlesService.deleteById(id);
        }


}
