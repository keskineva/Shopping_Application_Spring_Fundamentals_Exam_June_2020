package shopping.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.model.entity.Category;
import shopping.model.entity.CategoryName;
import shopping.repository.CategoryRepository;
import shopping.service.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
//създаване на категориите, ако няма такива.за всяка енумерация се създава ново ентити от тип категория
        if (this.categoryRepository.count() == 0) {
            //взимаме всички стойности на ENUm - CategoryName
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        this.categoryRepository
                                .save(new Category(categoryName, String.format("Description for %s",
                                        categoryName.name())));
                    });
        }
    }

    @Override
    public Category find(CategoryName categoryName) {
        return this.categoryRepository
                .findByCategoryName(categoryName)
                .orElse(null);
    }
}
