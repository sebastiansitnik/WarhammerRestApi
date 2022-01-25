package WebService.Warhammer40k.Category;

public class CategoryAlreadyTakenException extends RuntimeException{

    public CategoryAlreadyTakenException() {
        super("Category already exist");
    }
}


