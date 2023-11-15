package services.Product;

import models.Product;

public interface ProductService {
    void addProduct(Product product);

    void showAllProduct();

    void showProductById(Integer id);
}
