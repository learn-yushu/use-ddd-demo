package com.tojaoomy.demo.cache.facade;

import com.tojaoomy.demo.cache.api.CacheService;
import org.springframework.stereotype.Service;

/**
 * @author 玉书
 * @date 2022/7/15
 */
@Service
public class CacheServiceFacade implements CacheService {

    @Override
    public String get(String key) {
        //读redis 缓存
        return null;
    }

    @Override
    public void put(String key, String value) {
        //设置redis 缓存
    }
}