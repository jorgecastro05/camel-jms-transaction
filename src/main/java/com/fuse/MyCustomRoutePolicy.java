package com.fuse;

import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.support.RoutePolicySupport;

public class MyCustomRoutePolicy extends RoutePolicySupport {

    @Override
    public void onExchangeBegin(Route route, Exchange exchange) {
        String message = exchange.getIn().getBody(String.class);
        if (message.equals("STOP")) {
            try {
                exchange.getContext().getRoute(route.getId()).getConsumer().stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
