package com.briup.cms.service.impl;

import com.briup.cms.bean.Role;
import com.briup.cms.dao.RoleDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(role.getName()==null &&"".equals(role.getName())){
            throw new RuntimeException("参数无效");
        }
        Role role1 = roleDao.findByName(role.getName());
        if(role1==null){
            roleDao.save(role);
        }else {
            throw new RuntimeException("数据已存在");
        }
    }

    @Override
    public void deleteRoleInBatch(List<Integer> ids)  throws ServiceException {
        roleDao.deleteAllById(ids);
    }

    @Override
    public Role findByRoleName(String roleName) throws ServiceException {
        Role role = roleDao.findByName(roleName);
        return role;
    }
}
