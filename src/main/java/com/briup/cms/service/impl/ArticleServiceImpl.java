package com.briup.cms.service.impl;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.User;
import com.briup.cms.config.CmsInfo;
import com.briup.cms.dao.ArticleDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.IArticleService;
import com.briup.cms.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleDao dao;
    @Override
    public void saveOrUpdateArticle(Article article) throws ServiceException {
        Integer userId = UserInfoUtil.getUserId();
        System.out.println("userId = " + userId);

       if(article.getId()==null){
            article.setPublishTime(new Date());
            article.setStatus(0);
            article.setReadTimes(0);
            article.setThumbUp(0);
            article.setThumbDown(0);
           User user = new User();
           user.setId(userId);
           article.setUser(user);
       }else {

       }

        dao.save(article);



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
