package shopping.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import shopping.model.entity.CategoryName;
import shopping.model.entity.Product;
import shopping.model.service.ProductServiceModel;
import shopping.model.view.ProductViewModel;
import shopping.repository.ProductRepository;
import shopping.service.CategoryService;
import shopping.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {

        Product product = this.modelMapper
                .map(productServiceModel, Product.class);

        product.setCategory(this.categoryService
                .find(productServiceModel.getCategory().getCategoryName()));

        this.productRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductViewModel> findAllProducts() {
        return this.productRepository
                .findAll()
                .stream()
                .map(product -> {
                    ProductViewModel productViewModel = this.modelMapper
                            .map(product, ProductViewModel.class);

                    productViewModel.setImgUrl(String.format("/img/%s.jpg",
                            product.getCategory().getCategoryName().name()));

                    return productViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductViewModel findById(String id) {
        return this.productRepository
                .findById(id)
                .map(product -> {
                    ProductViewModel productViewModel = this.modelMapper
                            .map(product, ProductViewModel.class);

                    productViewModel.setImgUrl(String.format("/img/%s.jpg", product.getCategory().getCategoryName().name()));
                    return productViewModel;
                })
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<ProductViewModel> findAllDrinks() {
        return this.productRepository
                .findAllProductsByCategoryCategoryName(CategoryName.DRINK)
                .stream()
                .map(product -> {
                    ProductViewModel productViewModel = this.modelMapper
                            .map(product, ProductViewModel.class);

                    productViewModel.setImgUrl(String.format("/img/%s.jpg",
                            product.getCategory().getCategoryName().name()));

                    return productViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllFoods() {
        return this.productRepository
                .findAllProductsByCategoryCategoryName(CategoryName.FOOD)
                .stream()
                .map(product -> {
                    ProductViewModel productViewModel = this.modelMapper
                            .map(product, ProductViewModel.class);

                    productViewModel.setImgUrl(String.format("/img/%s.jpg",
                            product.getCategory().getCategoryName().name()));

                    return productViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllHouseholds() {
        return this.productRepository
                .findAllProductsByCategoryCategoryName(CategoryName.HOUSEHOLD)
                .stream()
                .map(product -> {
                    ProductViewModel productViewModel = this.modelMapper
                            .map(product, ProductViewModel.class);

                    productViewModel.setImgUrl(String.format("/img/%s.jpg",
                            product.getCategory().getCategoryName().name()));

                    return productViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllOthers() {
        return this.productRepository
                .findAllProductsByCategoryCategoryName(CategoryName.OTHER)
                .stream()
                .map(product -> {
                    ProductViewModel productViewModel = this.modelMapper
                            .map(product, ProductViewModel.class);

                    productViewModel.setImgUrl(String.format("/img/%s.jpg",
                            product.getCategory().getCategoryName().name()));

                    return productViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        this.productRepository.deleteAll();
    }
}
