package com.example.springloggin.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 登陆的一些信息缓存
 *
 * @author LiXuekai on 2019/12/13
 */
@Service("loginInfoCache")
public class LoginInfoCache {
    private static Logger LOG = LoggerFactory.getLogger(LoginInfoCache.class);

    /**
     * 缓存注册的子系统地址 <子系统， 子系统地址>
     */
    private static final Map<String, String> SUB_SYSTEM_MAP = new HashMap<>();


    /**
     * 缓存用户的子系统与tokenId的关联  Map<用户名, Map<子系统, tokenId>>
     */
    public static final Map<String, Map<String, String>> USER_SUB_TOKEN_MAP = new HashMap<>();


    /**
     * 获取 SUB_SYSTEM_MAP
     *
     * @return SUB_SYSTEM_MAP
     */
    public Map<String, String> getSubSystemMap() {
        Map<String, String> map = new HashMap<>();
        SUB_SYSTEM_MAP.forEach(map::put);
        return map;
    }

    /**
     * 子系统地址
     *
     * @param product 子系统
     * @return 子系统地址
     */
    public String getSubSystemByProduct(String product) {
        return SUB_SYSTEM_MAP.get(product);
    }

    /**
     * 注册子系统
     *
     * @param product  子系统
     * @param location 子系统地址
     */
    public void updateSubSystemMap(String product, String location) {
        synchronized (SUB_SYSTEM_MAP) {
            LOG.info("注册子系统...... product is {} , location is {}", product, location);
            SUB_SYSTEM_MAP.put(product, location);
        }
    }

    /**
     * 子系统取消注册
     *
     * @param product  子系统名称
     */
    public void removeSubSystemMap(String product) {
        synchronized (SUB_SYSTEM_MAP) {
            LOG.info("子系统取消注册...... product is {}", product);
            SUB_SYSTEM_MAP.remove(product);
        }
    }
}
