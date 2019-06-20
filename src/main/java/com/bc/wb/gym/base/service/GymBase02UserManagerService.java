package com.bc.wb.gym.base.service;

import com.bc.wb.gym.base.dataBean.BeanGymBase11UserInfo;

import java.util.List;

public interface GymBase02UserManagerService {
    void addUser(int storeId, int userId, int userRole) throws Exception;
    void deleteUser(int storeId, int userId, int userRole) throws Exception;
    void addUserInfo(String userName, String mobile, int sex) throws Exception;
    List<BeanGymBase11UserInfo> loadAllUserInfo() throws Exception;
}
