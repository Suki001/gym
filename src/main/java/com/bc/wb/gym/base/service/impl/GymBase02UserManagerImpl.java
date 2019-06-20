package com.bc.wb.gym.base.service.impl;

import com.bc.wb.gym.base.dao.GymBase01StoreMapper;
import com.bc.wb.gym.base.dao.GymBase02UserMapper;
import com.bc.wb.gym.base.dataBean.BeanGymBase11UserInfo;
import com.bc.wb.gym.base.dataBean.BeanStoreUser;
import com.bc.wb.gym.base.service.GymBase02UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("GymBase02UserManagerService")
@Transactional(rollbackFor = Exception.class)
public class GymBase02UserManagerImpl implements GymBase02UserManagerService {
    @Autowired
    private GymBase02UserMapper gymBase02UserMapper;

    public void addUser(int storeId, int userId, int userRole) throws Exception{
        List<BeanStoreUser> storeUsers = gymBase02UserMapper.loadStoreUsers(storeId, userId, userRole);
        if ( storeUsers.size() == 0 || storeUsers == null){
            Date createTime = new Date();
            gymBase02UserMapper.addUser(storeId, userId, userRole, createTime);
            if(userRole==1)
                gymBase02UserMapper.addOneMemberCount(storeId);
            if(userRole==2)
                gymBase02UserMapper.addOneCoachCount(storeId);
        }
        else{
            throw new Exception("该门店用户已存在，不再添加。");
        }
    }

    public void deleteUser(int storeId, int userId, int userRole) throws Exception{
        List<BeanStoreUser> storeUsers = gymBase02UserMapper.loadStoreUsers(storeId, userId, userRole);
        if ( storeUsers.size() == 0 || storeUsers == null){
            throw new Exception("该门店用户不存在，未执行删除操作。");
        }
        else{
            Date deleteTime = new Date();
            gymBase02UserMapper.deleteUser(storeId, userId, userRole, deleteTime);
            gymBase02UserMapper.addUserLose(storeId, userId, userRole, deleteTime);
            if(userRole==1)
                gymBase02UserMapper.reduceOneMemberCount(storeId);
            if(userRole==2)
                gymBase02UserMapper.reduceOneCoachCount(storeId);
        }
    }

    public void addUserInfo(String userName, String mobile, int sex){
        gymBase02UserMapper.addUserInfo(userName, mobile, sex);
    }

    public List<BeanGymBase11UserInfo> loadAllUserInfo(){
        return gymBase02UserMapper.loadAllUserInfo();
    }

}
