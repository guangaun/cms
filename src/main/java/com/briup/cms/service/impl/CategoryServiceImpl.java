package com.briup.cms.service.impl;

import com.briup.cms.bean.Category;
import com.briup.cms.dao.CategoryDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Page<Category> findAllSortByNo(Integer pageNum, Integer pageSize) throws ServiceException {
        Page<Category> page = categoryDao.findByParentIdIsNull(PageRequest.of(pageNum - 1, pageSize, Sort.by("no")));
        return page;

//        return null;
    }

    @Override
    public void saveOrUpdateCategory(Category category) throws ServiceException {

        Category cate = categoryDao.findById(category.getId()).orElse(null);

        if(category.getId() != 0 && cate == null){
            throw new ServiceException(ResultCode.DATA_NONE);
        }


        System.out.println(category);

        categoryDao.save(category);


    }

    @Override
    public void deleteCategoryInBatch(List<Integer> ids) throws ServiceException {
        categoryDao.deleteAllByIdInBatch(ids);
    }

    @Override
    public void updateCategoryNo(Integer id, int no) throws ServiceException {

        categoryDao.updateNoById(id,no);
    }
}
