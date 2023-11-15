package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Product;
import utils.BaseDao;

public class ProductDao implements BaseDao<Product, Integer> {

    List<Product> products = new ArrayList<>(Arrays.asList(new Product("Jeruk", "Jeruk dari mandarin", 3000., 4)));

    @Override
    public void add(Product data) {
        this.products.add(data);
    }

    @Override
    public List<Product> findAll() {
        return this.products;
    }

    @Override
    public Product findById(Integer id) {
        return this.products.get(id - 1);
    }

    @Override
    public void updataById(Integer id, Product data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updataById'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Integer size() {
        return this.products.size();
    }

}
