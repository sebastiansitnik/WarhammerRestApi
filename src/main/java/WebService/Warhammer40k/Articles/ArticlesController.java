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
    
    
        @CrossOrigin
        @PostMapping
        public ArticleDTO createArticle(@RequestBody ArticleDTO art){
            return articlesService.createArticle(art);
        }

        @CrossOrigin
        @GetMapping
        public ArticleDTO readArticle(@RequestParam String id){
            return articlesService.readArticleById(id);
        }

        @GetMapping("/all")
        public List<ArticleDTO> readAllArticles(){
            return articlesService.readAll();
        }

        @PutMapping("/edit")
        public ArticleDTO editArticle(@RequestBody ArticleDTO article){
            return articlesService.editArticle(article);
        }

        @DeleteMapping("/delete")
        public ArticleDTO deleteArticle(@RequestParam String id){
            return articlesService.deleteById(id);
        }

        @CrossOrigin
        @GetMapping("/searchByTitle")
        public List<ArticleDTO> searchByTitle(@RequestParam String title){
            return articlesService.searchByTitle(title);
        }


}
