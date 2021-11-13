package com.example.mybatisplus.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;

public interface BaseCrudIService<E, D> extends IService<E> {

    boolean create(D dto) throws ServiceException;

    int update(D dto) throws ServiceException;

    IPage<D> findAll(Wrapper<E> wrapper, Page<E> page);

    List<D> findAll(Wrapper<E> wrapper);

    D findOne(Long id);

    void delete(Long id);

    List<D> findByIds(List<Long> ids);

    int deleteByIds(List<Long> ids);

    List<D> saveAll(List<D> dtos);

    void updateOrInsert(String tableName, String accField, Map<String, Object> fieldValues);

    D findByCode(String code);
}
