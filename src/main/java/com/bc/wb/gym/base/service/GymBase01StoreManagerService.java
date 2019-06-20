package com.bc.wb.gym.base.service;

import com.bc.wb.gym.base.dataBean.BeanStore;

import java.util.List;

public interface GymBase01StoreManagerService {
    void addStore(String storeName, String address, String dzUrl) throws Exception;
    void deleteStore(String storeName) throws Exception;
    void modifyStoreName(String storeName, int storeId) throws Exception;
    void modifyStoreAddress(String address, int storeId) throws Exception;
    void modifyStoreOwnerId(int storeOwnerId, int storeId) throws Exception;
    void modifyStoreDzUrl(String dzUrl, int storeId) throws Exception;
    List<BeanStore> loadStoresByStoreName(String storeName) throws Exception;
}
