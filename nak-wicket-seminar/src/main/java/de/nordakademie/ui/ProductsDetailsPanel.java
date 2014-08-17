package de.nordakademie.ui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.nordakademie.business.product.Product;
import de.nordakademie.business.product.ProductService;

public class ProductsDetailsPanel extends Panel {
	
	@SpringBean
	private ProductService productService;
	
	public ProductsDetailsPanel(final String id) {
		super(id);
		
		add(new ListView<Product>("products", productService.findAll()) {

            @Override
            protected void populateItem(final ListItem<Product> item) {
                item.add(new Label("productName", item.getModelObject().getName()));
                item.add(new Label("productPrice", item.getModelObject().getPrice()));
            }
        });
	}
}
