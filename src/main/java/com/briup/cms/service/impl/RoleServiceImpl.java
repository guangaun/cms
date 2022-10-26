package com.briup.cms.service.impl;

import com.briup.cms.bean.Role;
import com.briup.cms.dao.RoleDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Page<Role> findAll(Integer pageNum, Integer pageSize) throws ServiceException {
        Page<Role> rolePage = roleDao.findAll(PageRequest.of(pageNum,pageSize));


        return rolePage;
    }

    @Override
    public void saveOrUpdateRole(Role role)  throws ServiceException{
        roleDao.save(role);
    }

    @Override
    public void deleteRoleInBatch(List<Integer> ids)  throws ServiceException {
        roleDao.deleteAllById(ids);
    }
}
