package com.csfrez.demo.eventhandler;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.csfrez.demo.dto.domainevent.CustomerCreatedEvent;

/**
 * Handle customer created event
 *
 * @author frankzhang
 * @date 2019/04/09
 */
@EventHandler
public class CustomerCreatedHandler implements EventHandlerI<Response, CustomerCreatedEvent> {

    private Logger logger = LoggerFactory.getLogger(CustomerCreatedHandler.class);

    @Override
    public Response execute(CustomerCreatedEvent event) {
        logger.warn("Sync new customer to Search");
        logger.warn("Logging system operation for new customer");
        logger.warn("customerId="+ event.getCustomerId());
        return Response.buildSuccess();
    }
}
