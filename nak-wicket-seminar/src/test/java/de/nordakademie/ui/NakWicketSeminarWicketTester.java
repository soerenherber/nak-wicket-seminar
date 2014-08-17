package de.nordakademie.ui;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Session;
import org.apache.wicket.mock.MockApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.resource.loader.ClassStringResourceLoader;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;

import de.otto.wickettester.EnhancedWicketTester;

public final class NakWicketSeminarWicketTester extends EnhancedWicketTester {

    private NakWicketSeminarWicketTester(final Map<String, Object> mocks) {
        super(new MockApplication() {

            @Override
            public Session newSession(final Request request, final Response response) {
                return new NakWicketSeminarSession(request);
            }
        });
        getApplication().getResourceSettings().getStringResourceLoaders()
                .add(new ClassStringResourceLoader(NakWicketSeminarApplication.class));
        final ApplicationContextMock applicationContextMock = new ApplicationContextMock();
        for (Object value : mocks.values()) {
			applicationContextMock.putBean(value);
		}
        getApplication().getComponentInstantiationListeners().add(
                new SpringComponentInjector(getApplication(), applicationContextMock));
    }

    public static CheesrWicketTesterBuilder builder() {
        return new CheesrWicketTesterBuilder();
    }

    public static final class CheesrWicketTesterBuilder {

        private final Map<String, Object> mocks = new HashMap<>();

        public CheesrWicketTesterBuilder withMock(final Object... objects) {
            for (final Object object : objects) {
                mocks.put(object.getClass().getName(), object);
            }
            return this;
        }

        public NakWicketSeminarWicketTester build() {
            return new NakWicketSeminarWicketTester(mocks);
        }
    }
}
