package com.example.mybatisplus.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.util.CollectionUtils;

/**
 * @author mnzhang
 * @description
 * @date 2021/06/30
 */
public abstract class BaseConverter<E extends BaseEntity, D extends BaseDto> {

    protected final Class<E> entityClazz;

    protected final Class<D> dtoClazz;

    @Autowired
    protected BaseMapper<E> mapper;

    @SuppressWarnings("unchecked")
    public BaseConverter() {
        Class<?>[] genericTypes =
                GenericTypeResolver.resolveTypeArguments(getClass(), BaseConverter.class);
        assert genericTypes != null;
        this.entityClazz = (Class<E>) genericTypes[0];
        this.dtoClazz = (Class<D>) genericTypes[1];
    }

    public D entityToDto(E entity, String... ignoreProperties) {
        if (entity == null) {
            return null;
        }
        D dto = BeanUtils.instantiateClass(this.dtoClazz);
        BeanUtils.copyProperties(entity, dto, ignoreProperties);
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }

    public E dtoToEntity(D dto, String... ignoreProperties) {
        if (dto == null) {
            return null;
        }
        E entity = BeanUtils.instantiateClass(this.entityClazz);
        String[] ignores = Arrays.asList(ignoreProperties, "code").toArray(new String[20]);
        BeanUtils.copyProperties(dto, entity, ignores);
        return entity;
    }

    public List<D> entitiesToDtos(List<E> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<E> dtosToEntities(List<D> dtos) {
        if (CollectionUtils.isEmpty(dtos)) {
            return new ArrayList<>();
        }
        return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    protected String[] combineIgnoreProperties(
            String[] ignoreProperties, List<String> customIgnoreProperties) {
        List<String> result = new ArrayList<>();
        result.addAll(customIgnoreProperties);
        result.addAll(Arrays.asList(ignoreProperties));
        String[] target = new String[10];
        return result.toArray(target);
    }
}
