package com.bc.wb.gym.base.dao;

import com.bc.wb.gym.base.dataBean.BeanStore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@Mapper
public interface GymBase01StoreMapper {
    /**
     * 添加门店记录
     * @param storeName
     * @param address
     * @param dzUrl
     */
    public int addStore(String storeName,String address,String dzUrl);

    /**
     * 删除门店记录
     * @param storeName
     */
    public int deleteStore(String storeName);

    /**
     * 按门店ID修改门店名称
     * @param storeName
     * @param storeId
     */
    public int modifyStoreName(String storeName,int storeId);

    /**
     * 按门店ID修改门店地址
     * @param address
     * @param storeId
     */
    public int modifyStoreAddress(String address, int storeId);

    /**
     * 按门店ID修改门店店长
     * @param storeOwerId
     * @param storeId
     */
    public int modifyStoreOwnerId(int storeOwerId, int storeId);

    /**
     * 按门店ID修改门店大众点评地址
     * @param dzUrl
     * @param storeId
     */
    public int modifyStoreDzUrl(String dzUrl, int storeId);

    /**
     * 按名称查找门店记录
     * @param storeName
     * @return
     */
    public List<BeanStore> loadStoresByStoreName(String storeName);


}
