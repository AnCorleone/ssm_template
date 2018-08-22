package com.anran.tmall.service.impl;

import com.anran.tmall.mapper.ProductMapper;
import com.anran.tmall.pojo.Category;
import com.anran.tmall.pojo.Product;
import com.anran.tmall.pojo.ProductExample;
import com.anran.tmall.pojo.ProductImage;
import com.anran.tmall.service.CategoryService;
import com.anran.tmall.service.ProductImageService;
import com.anran.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/16
 * @time 11:46
 * 描述    ${TODO}
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductImageService productImageService;

    @Override
    public void add(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public Product get(int id) {
        Product product = productMapper.selectByPrimaryKey(id);
        setCategory(product);
        setFirstProductImage(product);
        return product;
    }

    private void setCategory(Product product) {
        Integer cid = product.getCid();
        Category category = categoryService.get(cid);
        product.setCategory(category);
    }

    @Override
    public List<Product> list(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List<Product> products = productMapper.selectByExample(example);
        setFirstProductImage(products);
        return products;
    }

    @Override
    public void setFirstProductImage(Product product) {
        List<ProductImage> list = productImageService.list(product.getId(), ProductImageService.type_single);
        if (!list.isEmpty()) {
            ProductImage productImage = list.get(0);
            product.setFirstProductImage(productImage);
        }
    }

    @Override
    public void fill(List<Category> categorys) {
        for (Category category : categorys) {
            fill(category);
        }
    }

    @Override
    public void fill(Category category) {
        List<Product> products = list(category.getId());
        category.setProducts(products);
    }

    @Override
    public void fillByRow(List<Category> categorys) {
        int productNumberEachRow = 8;
        for (Category cs : categorys) {
            List<Product> ps = cs.getProducts();
            List<List<Product>> productsByRow = new ArrayList<>();
            for (int i = 0; i <ps.size() ; i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size =size>ps.size()?ps.size():size;
                List<Product> productsOfEachRow = ps.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            cs.setProductsByRow(productsByRow);
        }
    }

    public void setFirstProductImage(List<Product> pis) {
        for (Product pi : pis) {
            setFirstProductImage(pi);
        }
    }
}
