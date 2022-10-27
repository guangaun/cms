package com.briup.cms.service.impl;

import com.briup.cms.bean.Role;
import com.briup.cms.bean.User;
import com.briup.cms.config.CmsInfo;
import com.briup.cms.dao.RoleDao;
import com.briup.cms.dao.UserDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.IUserService;
import com.briup.cms.utils.JwtUtil;
import com.briup.cms.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public Page<User> getAll(Integer pageNum, Integer pageSize) throws ServiceException {
        Page<User> userPage = userDao.findAll(PageRequest.of(pageNum-1, pageSize));
        return userPage;
    }

    @Override
    public void saveOrUpdateUser(User user) throws ServiceException {

        Role role = roleDao.findById(user.getRole().getId()).orElse(null);

        if(role == null){
            throw new RuntimeException("角色不存在");
        }
        if(user == null || "".equals(user.getUsername())){
            throw new ServiceException(ResultCode.PARAM_IS_INVALID);
        }
        User user1 = userDao.findByUsername(user.getUsername());
        if(user1 != null && user1.getId()!= user.getId() && user1.getUsername().equals(user.getUsername())){
            throw new ServiceException(ResultCode.DATA_EXISTED);
        }

        if(user.getId() == null){
            user.setRegisterTime(new Date());
            user.setStatus(CmsInfo.USER_STATUS_YES);
        }



        userDao.save(user);
    }

    @Override
    public void deleteUserInBatch(List<Integer> ids) throws ServiceException {
        userDao.deleteAllByIdInBatch(ids);
    }

    @Override
    public void updateUserStatus(Integer id, String status) throws ServiceException {
        userDao.updateUserStatus(id,status);
    }

    @Override
    public String login(String username, String password) throws ServiceException {
        User user = userDao.findByUsername(username);
        //用户不存在
        if(user==null){
            throw  new ServiceException(ResultCode.USER_LOGIN_ERROR);
        }
        //密码错误
        if(!password.equals(user.getPassword())){
            throw new ServiceException(ResultCode.USER_LOGIN_ERROR);
        }
        //账号被禁用
        if(CmsInfo.USER_STATUS_NO.equals(user.getStatus())){
            throw  new ServiceException(ResultCode.USER_ACCOUNT_FORBIDDEN);
        }

        Map<String,Object>userInfo = new HashMap<>();
        userInfo.put("userId",user.getId());
        String token = JwtUtil.sign(username, userInfo);
        return token;

    }

    @Override
    public User findUserByUsername(String username) throws ServiceException {
        User user = userDao.findByUsername(username);

        return user;
    }
}
