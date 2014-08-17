package de.nordakademie.ui;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

class NakWicketSeminarSession extends WebSession {

    public NakWicketSeminarSession(final Request request) {
        super(request);
    }
}
