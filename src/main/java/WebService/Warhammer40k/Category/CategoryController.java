package WebService.Warhammer40k.Category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @CrossOrigin
    @PostMapping("/create")
    public CategoryDTO createCategory(@RequestBody NewCategoryDTO newCategoryDTO){
        return categoryService.createCategory(newCategoryDTO);
    }

    @CrossOrigin
    @GetMapping("/id")
    public CategoryDTO readArticleById (@RequestParam String id){
        return categoryService.readCategory(id);
    }

    @PutMapping("/edit")
    public CategoryDTO editCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.editCategory(categoryDTO);
    }

    @DeleteMapping("/delete")
    public CategoryDTO deleteById(@RequestParam String id){
        return categoryService.deleteCategory(id);
    }
    @CrossOrigin
    @GetMapping("/readAll")
    public List<CategoryDTO> readAll (){
        return categoryService.readAllCategories();
    }


}
