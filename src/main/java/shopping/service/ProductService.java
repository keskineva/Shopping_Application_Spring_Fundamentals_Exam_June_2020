package shopping.service;

import shopping.model.service.ProductServiceModel;
import shopping.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {

    void addProduct(ProductServiceModel productServiceModel);

    List<ProductViewModel> findAllProducts();

    ProductViewModel findById(String id);

    void delete(String id);
    List<ProductViewModel> findAllDrinks();
    List<ProductViewModel> findAllFoods();
    List<ProductViewModel> findAllHouseholds();
    List<ProductViewModel> findAllOthers();

    void deleteAll();
}
