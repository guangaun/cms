package com.briup.cms.service.impl;

import com.briup.cms.bean.User;
import com.briup.cms.dao.UserDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Page<User> getAll(Integer pageNum, Integer pageSize) throws ServiceException {
        Page<User> userPage = userDao.findAll(PageRequest.of(pageNum, pageSize));
        return userPage;
    }

    @Override
    public void saveOrUpdateUser(User user) throws ServiceException {
        userDao.save(user);
    }

    @Override
    public void deleteUserInBatch(List<Integer> ids) throws ServiceException {
        userDao.deleteAllById(ids);
    }

    @Override
    public void updateUserStatus(Integer id, String status) throws ServiceException {
        userDao.updateUserStatus(id,status);
    }

    @Override
    public String login(String username, String password) throws ServiceException {
        return null;
    }

    @Override
    public User findUserByUsername(String username) throws ServiceException {
//        User user = userDao.findByName(username);

        return null;
    }
}
