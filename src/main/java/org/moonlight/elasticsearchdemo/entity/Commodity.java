package org.moonlight.elasticsearchdemo.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;
import java.io.Serializable;

/**
 * 功能描述:
 * <p>
 * 主要逻辑:
 * <p>
 * 注意事项:
 *
 * @author Moonlight
 */
@Data
@Document(indexName = "commodity")
public class Commodity implements Serializable {

    @Id
    private String id;

    private String name;

    private String category;

    private Integer price;

    private String brand;

    private Integer stock;

}
