package de.nordakademie.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import de.nordakademie.business.product.Product;
import de.nordakademie.business.product.ProductService;

@MountPath("home")
public class HomePage extends WebPage {

    @SpringBean
    private ProductService messageService;

    public HomePage() {
    	add(new PageHeader("pageHeader"));
        add(new PageFooter("pageFooter"));
    }
}
