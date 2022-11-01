package com.briup.cms.service.impl;

import com.briup.cms.bean.Article;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.IArticleService;
import com.briup.cms.utils.UserInfoUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Override
    public void saveOrUpdateArticle(Article article) throws ServiceException {
        Integer userId = UserInfoUtil.getUserId();

    }

    @Override
    public Page<Article> findAllByUser(Integer pageNum, Integer pageSize) throws ServiceException {
        return null;
    }

    @Override
    public void deleteArticleInBatch(List<Integer> ids) throws ServiceException {

    }

    @Override
    public void updateArticleStatus(Integer id, String status) throws ServiceException {

    }

    @Override
    public Page<Article> findAllByCategoryId(Integer articleId, int pageNum, int pageSize) throws ServiceException {
        return null;
    }
}
