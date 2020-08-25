package shopping.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import shopping.service.CategoryService;

@Component
public class DataInit implements CommandLineRunner {

    private final CategoryService categoryService;

    public DataInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService
                .initCategories();
    }
}
