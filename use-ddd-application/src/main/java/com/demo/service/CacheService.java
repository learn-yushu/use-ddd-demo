package com.demo.service;

/**
 * @author 玉书
 * @date 2022/7/15
 */
public interface CacheService {

    String get(String key);

    void put(String key, String value);
}