package WebService.Warhammer40k.Articles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ArticlesService {

    private final ArticlesRepository articlesRepository;
    private final ArticleTransformation articleTransformation;


    @Autowired
    public ArticlesService(ArticlesRepository articlesRepository, ArticleTransformation articleTransformation) {
        this.articlesRepository = articlesRepository;
        this.articleTransformation = articleTransformation;
    }

    public float findFirstAvailableId(){

        float result;
        try{
            Article lastArticle = articlesRepository.findAll(Sort.by("id").descending()).stream().findFirst().orElseThrow(NoSuchElementException::new);
            result = Float.parseFloat(lastArticle.getId())+1;
        } catch (NoSuchElementException e){
            result = 1;
        }

        return result;


    }

    public ArticleDTO createArticle(ArticleDTO artDTO){

        String id = String.valueOf(findFirstAvailableId());
        artDTO.setId(id);
        artDTO.setUrl(artDTO.getTitle().toLowerCase().replace(" ",""));

        return toDTO(articlesRepository
                .save(toEntity(artDTO)));
    }

    public ArticleDTO readArticleById(String id){
        return toDTO(articlesRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new));
    }

    public List<ArticleDTO> readAll(){
        return articlesRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ArticleDTO editArticle(ArticleDTO artDTO){
        return toDTO(articlesRepository
                        .save(toEntity(artDTO)));
    }

    public ArticleDTO deleteById (String id){
        Article articleForDelete = toEntity(readArticleById(id));
        articlesRepository.deleteById(id);
        return toDTO(articleForDelete);
    }

    public List<ArticleDTO> searchByTitle(String title){

        List<Article> result;

        result = articlesRepository.getArticlesByTitleContaining(title, Sort.by("date").descending());

        return result.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Article toEntity(ArticleDTO articleDTO){
        return articleTransformation.toEntity(articleDTO);
    }

    public ArticleDTO toDTO(Article article){
        return articleTransformation.toDTO(article);
    }
}
