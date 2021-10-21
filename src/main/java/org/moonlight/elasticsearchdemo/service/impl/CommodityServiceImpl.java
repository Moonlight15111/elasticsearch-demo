package org.moonlight.elasticsearchdemo.service.impl;

import org.elasticsearch.index.query.QueryBuilders;
import org.moonlight.elasticsearchdemo.dao.CommodityRepository;
import org.moonlight.elasticsearchdemo.entity.Commodity;
import org.moonlight.elasticsearchdemo.service.CommodityService;
import org.moonlight.elasticsearchdemo.vo.CommodityQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 本来传统的jpa是新建一个接口去继承Repository接口，但是在高版本的spring-data-elasticsearch中
 * ElasticsearchRepository的方法几乎都被废弃掉了，不够灵活，不好用，故而使用ElasticsearchRestTemplate
 * @author Moonlight
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    private final CommodityRepository commodityRepository;

    @Autowired
    public CommodityServiceImpl(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @Override
    public long count() {
        return commodityRepository.count();
    }

    @Override
    public Commodity save(Commodity commodity) {
        return commodityRepository.save(commodity);
    }

    @Override
    public void delete(Commodity commodity) {
        commodityRepository.delete(commodity);
    }

    @Override
    public List<Commodity> getAll() {
        List<Commodity> res = new ArrayList<>();
        commodityRepository.findAll().forEach(res::add);
        return res;
    }

    @Override
    public List<Commodity> getByName(String name) {
        List<Commodity> res = new ArrayList<>();
        commodityRepository.search(QueryBuilders.matchPhraseQuery("name", name)).forEach(res::add);
        return res;
    }

    @Override
    public Page<Commodity> pageQuery(CommodityQueryVo queryVo) {
        return commodityRepository.search(queryVo.buildQuery(), queryVo.buildPageable());
    }
}
