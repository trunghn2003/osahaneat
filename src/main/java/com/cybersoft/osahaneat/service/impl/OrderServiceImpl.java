package com.cybersoft.osahaneat.service.impl;

import com.cybersoft.osahaneat.payload.request.OrderRequest;

public interface OrderServiceImpl {
    boolean insertOrder(OrderRequest orderRequest);
}
