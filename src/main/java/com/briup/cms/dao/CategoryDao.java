package com.briup.cms.dao;

import com.briup.cms.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {

    Page<Category> findByParentIdIsNull(Pageable page);


    @Transactional
    @Modifying
    @Query("update Category set no = ?2 where id = ?1")
    void updateNoById(Integer id, int no);
}
