package com.leyou.order.service.api;

import com.disco.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "disco-gateway", path = "/api/item")
public interface GoodsService extends GoodsApi {
}
