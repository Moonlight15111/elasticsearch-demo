package org.moonlight.elasticsearchdemo.service;

import org.moonlight.elasticsearchdemo.entity.Commodity;
import org.moonlight.elasticsearchdemo.vo.CommodityQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 商品service
 * @author Moonlight
 */
public interface CommodityService {

    /**
     * 统计商品总数
     * @author Moonlight
     * @return long
     **/
    long count();

    /**
     * 存储商品实体到ES
     * @param commodity 商品实体
     * @author Moonlight
     * @return Commodity
     **/
    Commodity save(Commodity commodity);

    /**
     * 从ES中删除商品实体
     * @param commodity 商品实体
     * @author Moonlight
     **/
    void delete(Commodity commodity);

    /**
     * 获取ES中的全部商品数据
     * @author Moonlight
     * @return List<Commodity>
     **/
    List<Commodity> getAll();

    /**
     * 根据商品名称查询商品数据
     * @param name 商品名称
     * @author Moonlight
     * @return List<Commodity>
     **/
    List<Commodity> getByName(String name);

    /**
     * 根据条件分页查询商品数据
     * @param queryVo 商品查询参数封装实体
     * @author Moonlight
     * @return List<Commodity>
     **/
    Page<Commodity> pageQuery(CommodityQueryVo queryVo);
}
