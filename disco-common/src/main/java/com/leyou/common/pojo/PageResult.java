package com.leyou.common.pojo;

import java.util.List;

/**
 * @ClassName: PageResult
 * @Description: 分页结果实体类
 * @date: 2022/5/5
 * @author zhb
 */
public class PageResult<T> {

    // 总条数
    private Long total;

    // 每页条数
    private Integer totalPage;

    // 结果集
    private List<T> items;

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PageResult{" +
            "total=" + total +
            ", totalPage=" + totalPage +
            ", items=" + items +
            '}';
    }
}
