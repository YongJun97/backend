package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import entity.Product;

public class ProductDB {
    
    private static final ProductDB productDB = new ProductDB();

    public static ProductDB getInstance() {
        return productDB;
    }

    private final ArrayList<Product> productList = new ArrayList<>();

    public void insertProduct(Product product) {
        productList.add(product);
    }

    public Optional<Product> getProductByProductId(String ProductId) {
        Product findProduct = null;
        for (Product product : productList) {
            if (product.getProductId().equals(ProductId)) {
                findProduct = product;
                break;
            }
        }
        return Optional.ofNullable(findProduct);
    }

    public List<Product> getAllProducts() {
        return productList.stream().collect(Collectors.toList());
    }

    public void deleteProduct(Product product) {
        productList.remove(product);
    }
}
