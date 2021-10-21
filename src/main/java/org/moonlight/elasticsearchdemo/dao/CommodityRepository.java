package org.moonlight.elasticsearchdemo.dao;

import org.moonlight.elasticsearchdemo.entity.Commodity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moonlight
 */
@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {

}