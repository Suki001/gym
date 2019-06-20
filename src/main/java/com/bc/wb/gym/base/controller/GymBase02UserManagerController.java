package com.bc.wb.gym.base.controller;

import com.bc.wb.gym.base.dataBean.BeanGymBase11UserInfo;
import com.bc.wb.gym.base.dataBean.BeanStoreCoachMember;
import com.bc.wb.gym.base.dao.GymBase02UserMapper;
import com.bc.wb.gym.base.service.GymBase02UserManagerService;
import com.bc.wb.gym.base.utils.HttpResult;
import com.bc.wb.gym.base.utils.HttpResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/base/user/manager")
public class GymBase02UserManagerController {
    @Resource
    private GymBase02UserMapper user = null;

    @Autowired
    private GymBase02UserManagerService userManagerService;

    @RequestMapping("/addUser")
    @ResponseBody
    public HttpResult addUser(@RequestParam("storeId") int storeId, @RequestParam("userId") int userId, @RequestParam("userRole") int userRole) throws Exception{
        userManagerService.addUser(storeId, userId, userRole);
        return HttpResultUtil.success();
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public HttpResult deleteUser(@RequestParam("storeId") int storeId, @RequestParam("userId") int userId, @RequestParam("userRole") int userRole) throws Exception {
        userManagerService.deleteUser(storeId, userId, userRole);
        return HttpResultUtil.success();
    }

    @RequestMapping("/addStoreCoachMember")
    @ResponseBody
    public void addStoreCoachMember(HttpServletRequest request){
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int coachId = Integer.parseInt(request.getParameter("coachId"));
        int memberId = Integer.parseInt(request.getParameter("memberId"));
        List<BeanStoreCoachMember> storeCoachMembers = user.searchStoreCoachMember(storeId, coachId, memberId);
        if ( storeCoachMembers.size() == 0 || storeCoachMembers == null){
            Date createTime = new Date();
            user.addStoreCoachMember(storeId, coachId, memberId, createTime);
        }else{
            System.out.println("该教练名下已存在该会员，不再添加绑定信息。");
        }
    }
//    public HttpResult addStoreCoachMember(@RequestParam("storeId") int storeId, @RequestParam("coachId") int coachId, @RequestParam("memberId") int memberId){
//
//    }

    @RequestMapping("/deleteStoreCoachMember")
    @ResponseBody
    public void deleteStoreCoachMember(HttpServletRequest request){
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int coachId = Integer.parseInt(request.getParameter("coachId"));
        int memberId = Integer.parseInt(request.getParameter("memberId"));
        List<BeanStoreCoachMember> storeCoachMembers = user.searchStoreCoachMember(storeId, coachId, memberId);
        if ( storeCoachMembers.size() == 0 || storeCoachMembers == null){
            System.out.println("该教练名下不存在该会员，未执行删除操作");
        }else{
            Date removeTime = new Date();
            user.deleteStoreCoachMember(storeId, coachId, memberId, removeTime);
        }
    }

    @RequestMapping("/addUserInfo")
    @ResponseBody
    public HttpResult addUserInfo(@RequestParam("userName") String userName, @RequestParam("mobile") String mobile, @RequestParam("sex") int sex) throws Exception{
        userManagerService.addUserInfo(userName, mobile, sex);
        return HttpResultUtil.success();
    }

    @RequestMapping("/loadAllUserInfo")
    @ResponseBody
    public HttpResult loadAllUserInfo() throws Exception{
        List<BeanGymBase11UserInfo> userInfos = userManagerService.loadAllUserInfo();
        return HttpResultUtil.success(userInfos);
    }


}
