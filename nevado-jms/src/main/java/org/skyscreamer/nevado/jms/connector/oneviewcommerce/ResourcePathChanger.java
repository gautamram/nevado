package org.skyscreamer.nevado.jms.connector.oneviewcommerce;

import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.handlers.RequestHandler2;

import java.util.List;

/**
 * Created by ted on 6/16/16.
 */
class ResourcePathChanger {

	private final List<RequestHandler2> requestHandler2s;

	public ResourcePathChanger(List<RequestHandler2> requestHandler2s) {
		this.requestHandler2s = requestHandler2s;
	}

	void changeResPath() {
		requestHandler2s.clear();
		HandlerChainFactory chainFactory = new HandlerChainFactory();
		requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
				"/org/skyscreamer/nevado/jms/resource/request.handlers")
		);
	}
}
