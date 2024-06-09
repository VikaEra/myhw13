package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Кофе", 300);
    Product product2 = new Product(2, "Джинсы", 1000);
    Product product3 = new Product(3, "Книга", 750);


    @Test
    public void shouldAddProductInRepository() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductFromRepositoryExist() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductFromRepositoryNotExist() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(7));
    }

    @Test
    public void addProductFromRepositoryAlreadyExists() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertThrows(AlreadyExistsException.class,
                () -> repo.add(product1));
    }
}
