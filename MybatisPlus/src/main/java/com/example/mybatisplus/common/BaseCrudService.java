package com.example.mybatisplus.common;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

/**
 * @author mnzhang
 * @description
 * @date 2021/06/30
 */
public abstract class BaseCrudService<E extends BaseEntity, D extends BaseDto> implements BaseCrudIService<E, D>,
        IService<E> {

    @Autowired
    protected BaseMapper<E> mapper;

    @Autowired
    protected BaseConverter<E, D> converter;

    @Override
    public boolean create(D dto) {
        businessValidate(dto, true);
        E entity = converter.dtoToEntity(dto);
        entity.setCode(UUID.randomUUID(true).toString());
        return save(entity);
    }

    @Override
    public int update(D dto) throws ServiceException {
        if (dto.getId() == null) {
            throw new ServiceException(ConstError.ID_IS_REQUIRED);
        }
        if (findOne(dto.getId()) == null) {
            throw new ServiceException(ConstError.ENTITY_NOT_EXISTED);
        }
        businessValidate(dto, false);
        E entity = converter.dtoToEntity(dto);
        return mapper.updateById(entity);
    }

    @Override
    public D findOne(Long id) {
        E entity = mapper.selectById(id);
        return converter.entityToDto(entity);
    }

    @Override
    public List<D> findByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        List<E> entities = mapper.selectBatchIds(ids);
        return converter.entitiesToDtos(entities);
    }

    @Override
    public IPage<D> findAll(Wrapper<E> wrapper, Page<E> page) {
        Page<E> ePage = mapper.selectPage(page, wrapper);
        Page<D> result = new Page<>();
        result.setCurrent(ePage.getCurrent());
        result.setTotal(ePage.getTotal());
        result.setRecords(converter.entitiesToDtos(ePage.getRecords()));
        return result;
    }

    @Override
    public List<D> findAll(Wrapper<E> wrapper) {
        List<E> list = mapper.selectList(wrapper);
        return converter.entitiesToDtos(list);
    }


    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return mapper.deleteBatchIds(ids);
    }

    /**
     * fixme 批量插入
     */
    @Override
    public List<D> saveAll(List<D> dtos) {
        List<E> entities = converter.dtosToEntities(dtos);
        //        entities = mapper.saveAll(entities);
        return converter.entitiesToDtos(entities);
    }

    @Override
    public D findByCode(String code) {
        QueryWrapper<E> wrapper = new QueryWrapper<>();
        wrapper.eq("code", code);
        E entity = mapper.selectOne(wrapper);
        return converter.entityToDto(entity);
    }

    protected void businessValidate(D dto, boolean isCreate) {
    }
}
