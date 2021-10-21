package org.moonlight.elasticsearchdemo.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 *
 * @author Moonlight
 */
@Data
@Accessors(chain = true)
public class CommodityQueryVo implements Serializable {
    private Integer page;
    private Integer size;
    private String name;
    private String category;
    private Integer priceStart;
    private Integer priceEnd;

    public QueryBuilder buildQuery() {
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        if (name != null && !"".equals(name.trim())) {
            builder.must(QueryBuilders.matchPhraseQuery("name", name));
        }
        if (category != null && !"".equals(category.trim())) {
            builder.must(QueryBuilders.matchPhraseQuery("category", category));
        }
        if (priceStart != null) {
            builder.must(QueryBuilders.rangeQuery("price").gte(priceStart));
        }
        if (priceEnd != null) {
            builder.must(QueryBuilders.rangeQuery("price").lte(priceEnd));
        }
        return builder;
    }

    public Pageable buildPageable() {
        return PageRequest.of(page, size);
    }

}