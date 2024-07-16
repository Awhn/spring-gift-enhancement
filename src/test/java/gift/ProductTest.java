package gift;

import gift.entity.Category;
import gift.entity.Product;
import gift.repository.CategoryRepository;
import gift.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    private Product testProduct;
    private Category testCategory;

    @BeforeEach
    public void setUp() {
        testCategory = new Category(1, "test", "test", "test", "test");
        categoryRepository.save(testCategory);

        testProduct = new Product(1, testCategory,1, "test", "testURL");
        productRepository.save(testProduct);
    }

    @AfterEach
    public void tearDown() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
    }

    @Test
    void testFindById() {
        Product foundProduct = productRepository.findById(testProduct.getId());
        assertEquals(testProduct.getId(), foundProduct.getId());
    }
}
