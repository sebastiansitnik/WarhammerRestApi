package WebService.Warhammer40k.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryTransformer categoryTransformer;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryTransformer categoryTransformer) {
        this.categoryRepository = categoryRepository;
        this.categoryTransformer = categoryTransformer;
    }

    public CategoryDTO createCategory (NewCategoryDTO newCategoryDTO){

        Category category = toEntity(newCategoryDTO);

        if(!categoryRepository.findById(category.getId()).isPresent()){
            return toDTO(categoryRepository.save(category));
        } else {
            throw new CategoryAlreadyTakenException();
        }

    }

    public CategoryDTO readCategory (String id){
        return toDTO(categoryRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new));
    }

    public CategoryDTO editCategory (CategoryDTO categoryDTO){
        return toDTO(categoryRepository
                .save(toEntity(categoryDTO)));
    }


    public CategoryDTO deleteCategory (String id){
        Category categoryToDelete = toEntity(readCategory(id));

        categoryRepository.delete(categoryToDelete);

        return toDTO(categoryToDelete);
    }

    public List<CategoryDTO> readAllCategories(){

        return categoryRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());

    }

    public final CategoryDTO toDTO(Category category){
        return categoryTransformer.toDTO(category);
    }

    public final Category toEntity(CategoryDTO categoryDTO){
        return categoryTransformer.toEntity(categoryDTO);
    }

    private Category toEntity(NewCategoryDTO newCategoryDTO){
        return categoryTransformer.toEntity(newCategoryDTO);
    }
}
