package com.bc.wb.gym.base.controller;

import com.bc.wb.gym.base.dataBean.BeanStore;
import com.bc.wb.gym.base.service.GymBase01StoreManagerService;
import com.bc.wb.gym.base.utils.HttpResult;
import com.bc.wb.gym.base.utils.HttpResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/base/store/manager")
public class GymBase01StoreManagerController {

    @Autowired
    private GymBase01StoreManagerService gymBase01StoreManagerService;

    @RequestMapping("/addStore")
    @ResponseBody
    public HttpResult addStore(@RequestParam("storeName") String storeName, @RequestParam("address") String address, @RequestParam("dzUrl") String dzUrl) throws Exception{
        gymBase01StoreManagerService.addStore(storeName,address,dzUrl);
        return HttpResultUtil.success();
    }

    @RequestMapping("/deleteStore")
    @ResponseBody
    public HttpResult deleteStore(@RequestParam("storeName") String storeName) throws Exception {
        gymBase01StoreManagerService.deleteStore(storeName);
        return HttpResultUtil.success();
    }

    @RequestMapping("/modifyStoreName")
    @ResponseBody
    public HttpResult modifyStoreName(@RequestParam("storeName") String storeName, @RequestParam("storeId") int storeId) throws Exception{
        gymBase01StoreManagerService.modifyStoreName(storeName, storeId);
        return HttpResultUtil.success();
    }

    @RequestMapping("/modifyAddress")
    @ResponseBody
    public HttpResult modifyAddress(@RequestParam("address") String address, @RequestParam("storeId") int storeId) throws Exception{
        gymBase01StoreManagerService.modifyStoreAddress(address, storeId);
        return HttpResultUtil.success();
    }

    @RequestMapping("/modifyStoreOwnerId")
    @ResponseBody
    public HttpResult modifyStoreOwnerId(@RequestParam("storeOwnerId") int storeOwnerId, @RequestParam("storeId") int storeId) throws Exception{
        gymBase01StoreManagerService.modifyStoreOwnerId(storeOwnerId, storeId);
        return HttpResultUtil.success();
    }

    @RequestMapping("/modifyDzUrl")
    @ResponseBody
    public HttpResult modifyStoreDzUrl(@RequestParam("dzUrl") String dzUrl, @RequestParam("storeId") int storeId) throws Exception{
        gymBase01StoreManagerService.modifyStoreDzUrl(dzUrl, storeId);
        return HttpResultUtil.success();
    }

    @RequestMapping("/searchStore")
    @ResponseBody
     public HttpResult loadStoresByStoreName(@RequestParam("storeName") String storeName)throws Exception{
        List<BeanStore> stores = gymBase01StoreManagerService.loadStoresByStoreName(storeName);
        return HttpResultUtil.success(stores);
    }
}
