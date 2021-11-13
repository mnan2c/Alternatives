package com.example.mybatisplus.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mnzhang
 * @description
 * @date 2021/06/30
 */
@Slf4j
@Validated
public abstract class BaseController<E extends BaseEntity, D extends BaseDto> {

    @Autowired
    private BaseCrudService<E, D> service;

    @Autowired
    protected BaseMapper<E> mapper;

    @Autowired
    protected BaseConverter<E, D> converter;

    @PostMapping
    public boolean createEntity(@Validated @RequestBody D dto) {
        return service.create(dto);
    }

    @PostMapping("/saveAll")
    public List<D> saveAll(@Validated @RequestBody List<D> dtos) {
        return service.saveAll(dtos);
    }

    @PutMapping
    public int updateEntity(@Validated @RequestBody D dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @DeleteMapping
    public int deleteByIds(@RequestParam("ids") List<Long> ids) {
        return service.deleteByIds(ids);
    }

    @GetMapping("/{id}")
    public D getById(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @GetMapping(params = {"ids"})
    public List<D> getByIds(@RequestParam("ids") List<Long> ids) {
        return service.findByIds(ids);
    }

    @GetMapping("/findByCode/{code}")
    public D findByCode(@PathVariable("code") String code) {
        return service.findByCode(code);
    }

}
