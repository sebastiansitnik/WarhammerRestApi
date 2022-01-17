package WebService.Warhammer40k.Articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, String> {


}
