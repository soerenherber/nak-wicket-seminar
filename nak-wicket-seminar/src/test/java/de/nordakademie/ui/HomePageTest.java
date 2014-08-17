package de.nordakademie.ui;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import org.testng.annotations.Test;

import de.nordakademie.business.product.ProductService;

public class HomePageTest {

    @Test(enabled=false)
    public void shouldRenderHomePage() {
        // given
        final NakWicketSeminarWicketTester wicketTester = NakWicketSeminarWicketTester.builder()
                .withMock(mock(ProductService.class)).build();

        // when
        wicketTester.startPage(HomePage.class);

        // then
        assertThat((HomePage) wicketTester.getLastRenderedPage(), isA(HomePage.class));
    }
}
