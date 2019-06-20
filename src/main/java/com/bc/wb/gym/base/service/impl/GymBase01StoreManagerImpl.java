package com.bc.wb.gym.base.service.impl;


import com.bc.wb.gym.base.dataBean.BeanStore;
import com.bc.wb.gym.base.dao.GymBase01StoreMapper;
import com.bc.wb.gym.base.service.GymBase01StoreManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GymBase01StoreManagerService")
@Transactional(rollbackFor = Exception.class)
public class GymBase01StoreManagerImpl implements GymBase01StoreManagerService {
    @Autowired
    private GymBase01StoreMapper gymBase01StoreMapper;

    @Override
    public void addStore(String storeName, String address, String dzUrl) throws Exception{
        List<BeanStore> stores = gymBase01StoreMapper.loadStoresByStoreName(storeName);
        if (stores.size() == 0 || stores == null){
            int rows = gymBase01StoreMapper.addStore(storeName, address, dzUrl);
            if (rows != 1){
                throw new Exception("添加门店失败");
            }
        } else {
            throw new Exception("已存在该门店，不再添加。");
        }
    }

    @Override
    public void deleteStore(String storeName) throws Exception{
        int rows = gymBase01StoreMapper.deleteStore(storeName);
        if (rows != 1){
            throw new Exception("删除门店失败");
        }
    }

    @Override
    public void modifyStoreName(String storeName, int storeId) throws Exception{
        int rows = gymBase01StoreMapper.modifyStoreName(storeName, storeId);
        if (rows != 1){
            throw new Exception("修改门店名称失败");
        }
    }

    @Override
    public void modifyStoreAddress(String address, int storeId) throws Exception{
        int rows = gymBase01StoreMapper.modifyStoreAddress(address, storeId);
        if (rows != 1){
            throw new Exception("修改门店地址失败");
        }
    }

    @Override
    public void modifyStoreOwnerId(int storeOwnerId, int storeId) throws Exception{
        int rows = gymBase01StoreMapper.modifyStoreOwnerId(storeOwnerId, storeId);
        if(rows != 1){
            throw new Exception("修改门店店长失败");
        }
    }

    @Override
    public void modifyStoreDzUrl(String dzUrl, int storeId) throws Exception{
        int rows = gymBase01StoreMapper.modifyStoreDzUrl(dzUrl, storeId);
        if (rows != 1){
            throw new Exception("修改门店大众点评地址失败");
        }
    }

    @Override
    public List<BeanStore> loadStoresByStoreName(String storeName){
        return gymBase01StoreMapper.loadStoresByStoreName(storeName);
    }

}
