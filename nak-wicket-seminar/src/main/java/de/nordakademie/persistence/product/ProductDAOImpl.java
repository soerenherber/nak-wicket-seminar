package de.nordakademie.persistence.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import de.nordakademie.business.product.Product;
import de.nordakademie.business.product.ProductDAO;
import de.nordakademie.persistence.common.MongodbFactory;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private MongodbFactory mongodb;

    @Override
    public List<Product> findAll() {
    	
    	final DBCursor dbProducts = mongodb.getObject().getCollection("products").find().sort(new BasicDBObject().append("name", 1));
    	
    	final List<Product> products = new ArrayList<>();
    	while (dbProducts.hasNext()) {
    		DBObject product = dbProducts.next();
    		Double price = (Double) product.get("price");
			products.add(new Product((String) product.get("name"), price.intValue()));
		}
    	
    	return products;
    }
}
