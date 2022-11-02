package com.briup.cms.service.impl;

import com.briup.cms.bean.Comment;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {




    @Override
    public Page<Comment> findAll(Integer pageNum, Integer pageSize) throws ServiceException {
        return null;
    }

    @Override
    public void saveOrUpdateComment(Comment comment) throws ServiceException {

    }

    @Override
    public void deleteCommentInBatch(List<Integer> ids) throws ServiceException {

    }

    @Override
    public Page<Comment> findAllByArticleId(Integer articleId, Integer pageNum, Integer pageSize) throws ServiceException {
        return null;
    }
}
