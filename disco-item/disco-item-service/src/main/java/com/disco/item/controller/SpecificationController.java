package com.disco.item.controller;

import com.disco.item.service.impl.SpecificationServiceImpl;
import com.disco.pojo.SpecGroup;
import com.disco.pojo.SpecParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: SpecificationController
 * @Description: 规格参数服务层Controller
 * @date: 2022/7/12
 * @author zhb
 */
@Controller
@RequestMapping("spec")
public class SpecificationController {

    @Resource
    private SpecificationServiceImpl specificationService;

    /**
     * 根据分类id查询规格参数组
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupsByCid(@PathVariable("cid") Long cid){
        List<SpecGroup> groups = this.specificationService.queryGroupsByCid(cid);
        if (CollectionUtils.isEmpty(groups)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(groups);
    }

    /**
     * 根据组id 查询规格分类
     * @param gid
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> queryParams(
        @RequestParam(value = "gid",required = false) Long gid,
        @RequestParam(value = "cid",required = false) Long cid,
        @RequestParam(value = "generic",required = false) Boolean generic,
        @RequestParam(value = "searching",required = false) Boolean searching)
    {
        List<SpecParam> params = this.specificationService.queryParams(gid,cid,generic,searching);
        if (CollectionUtils.isEmpty(params)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(params);
    }

    /**
     * 根据分类id 查询组、组下的规格参数信息
     * @param cid
     * @return
     */
    @GetMapping("group/param/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupsWithParam(@PathVariable("cid")Long cid){
        List<SpecGroup> specGroups = this.specificationService.queryGroupsWithParam(cid);
        if (CollectionUtils.isEmpty(specGroups) || specGroups == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(specGroups);
    }
}
