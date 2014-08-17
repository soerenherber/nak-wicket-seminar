package de.nordakademie.business.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.nordakademie.business.product.Product;
import de.nordakademie.business.product.ProductDAO;
import de.nordakademie.business.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO messageDAO;

    @Override
    public List<Product> findAll() {
        return messageDAO.findAll();
    }
}
