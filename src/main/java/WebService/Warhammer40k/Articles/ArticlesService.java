package WebService.Warhammer40k.Articles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticlesService {

    private final ArticlesRepository articlesRepository;

    @Autowired
    public ArticlesService(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public Article createArticle(Article art){
        return articlesRepository.save(art);
    }

    public Article readArticleById(String id){
        return articlesRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Article> readAll(){
        return articlesRepository.findAll();
    }

    public Article editArticle(Article art){
        return articlesRepository.save(art);
    }

    public Article deleteById (String id){
        Article articleForDelete = readArticleById(id);
        articlesRepository.deleteById(id);
        return articleForDelete;
    }

    public List<Article> searchByTitle(String title){

        List<Article> result;

        result = articlesRepository.getArticlesByTitle(title, Sort.by("date").descending());

        return result;
    }
}
