package cn.itcast.bos.domain;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.criterion.DetachedCriteria;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class PageBean<T> implements Serializable{

    /**当前页*/
    private int currentPage;
    /**每页数据量*/
    private int pageSize;
    /**Criteria的离线查询类，在控制层或业务层组织查询参数*/
    private DetachedCriteria detachedCriteria;
    /**总数据量*/
    private int total;
    /**数据*/
    private List<T> rows;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public DetachedCriteria getDetachedCriteria() {
        return detachedCriteria;
    }

    public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
        this.detachedCriteria = detachedCriteria;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }







    private String id;
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
