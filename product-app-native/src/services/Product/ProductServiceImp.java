package services.Product;

import java.util.List;
import java.util.Objects;

import dao.ProductDao;
import models.Product;

public class ProductServiceImp implements ProductService {
    ProductDao productDao;

    public ProductServiceImp(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(Product product) {
        // cek null product
        if (Objects.isNull(product)) {
            throw new RuntimeException("Product can't be null!");
        }

        productDao.add(product);
        System.out.println("Success Add!");
    }

    @Override
    public void showAllProduct() {
        List<Product> products = productDao.findAll();

        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    @Override
    public void showProductById(Integer id) {
        if (id > productDao.size()) {
            throw new RuntimeException("No Product is not found!");
        }

        Product product = productDao.findById(id);
        System.out.println(product);
    }

}
