package com.disco.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: SpuDetail
 * @Description: spu详情实体类
 * @date: 2022/7/17
 * @author zhb
 */
@Table(name = "tb_spu_detail")
public class SpuDetail {

    @Id
    private Long spuId; // spu的id
    private String description; // 商品描述信息
    private String genericSpec; // 通用规格参数数据
    private String specialSpec; // 特有规格参数及可选值信息，json格式
    private String packingList; // 包装清单
    private String afterService; // 售后服务

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenericSpec() {
        return genericSpec;
    }

    public void setGenericSpec(String genericSpec) {
        this.genericSpec = genericSpec;
    }

    public String getSpecialSpec() {
        return specialSpec;
    }

    public void setSpecialSpec(String specialSpec) {
        this.specialSpec = specialSpec;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    public String getAfterService() {
        return afterService;
    }

    public void setAfterService(String afterService) {
        this.afterService = afterService;
    }
}
