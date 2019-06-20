package com.bc.wb.gym.base.dao;

import com.bc.wb.gym.base.dataBean.BeanGymBase11UserInfo;
import com.bc.wb.gym.base.dataBean.BeanStoreCoachMember;
import com.bc.wb.gym.base.dataBean.BeanStoreUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface GymBase02UserMapper {
    /**
     * 增加门店用户信息
     * @param storeId
     * @param userId
     * @param userRole
     * @param createTime
     */
    public void addUser(int storeId, int userId, int userRole, Date createTime);

    /**
     * 门店会员数+1
     * @param storeId
     */
    public void addOneMemberCount(int storeId);

    /**
     * 门店教练数+1
     * @param storeId
     */
    public void addOneCoachCount(int storeId);

    /**
     * 删除门店用户信息
     * @param storeId
     * @param userId
     * @param userRole
     * @param deleteTime
     */
    public void deleteUser(int storeId, int userId, int userRole, Date deleteTime);

    /**
     * 新增用户流失记录
     * @param storeId
     * @param userId
     * @param userRole
     * @param createTime
     */
    public void addUserLose(int storeId, int userId, int userRole, Date createTime);

    /**
     * 门店会员数-1
     * @param storeId
     */
    public void reduceOneMemberCount(int storeId);

    /**
     * 门店教练数-1
     * @param storeId
     */
    public void reduceOneCoachCount(int storeId);

    /**
     * 查询门店用户信息
     * @param storeId
     * @param userId
     * @param userRole
     * @return
     */
    public List<BeanStoreUser> loadStoreUsers(int storeId, int userId, int userRole);

    /**
     * 新增门店教练会员绑定信息
     * @param storeId
     * @param coachId
     * @param memberId
     * @param createTime
     */
    public void addStoreCoachMember(int storeId, int coachId,int memberId, Date createTime);

    /**
     * 删除门店教练会员绑定信息
     * @param storeId
     * @param coachId
     * @param memberId
     * @param removeTime
     */
    public void deleteStoreCoachMember(int storeId, int coachId, int memberId, Date removeTime);
    /**
     * 查询门店教练会员绑定信息
     * @param storeId
     * @param coachId
     * @param memberId
     * @return
     */
    public List<BeanStoreCoachMember> searchStoreCoachMember(int storeId, int coachId, int memberId);

    /**
     * 新增系统用户信息
     * @param userName
     * @param mobile
     * @param sex
     */
    public void addUserInfo(String userName, String mobile, int sex);
    public List<BeanGymBase11UserInfo> loadAllUserInfo();





}
