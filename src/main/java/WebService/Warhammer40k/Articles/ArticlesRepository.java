package WebService.Warhammer40k.Articles;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, String> {

    List<Article> getArticlesByTitle(String title, Sort sort);


}
