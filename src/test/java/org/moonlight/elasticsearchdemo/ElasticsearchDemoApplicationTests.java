package org.moonlight.elasticsearchdemo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.moonlight.elasticsearchdemo.entity.Commodity;
import org.moonlight.elasticsearchdemo.service.CommodityService;
import org.moonlight.elasticsearchdemo.vo.CommodityQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

@SpringBootTest
class ElasticsearchDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private CommodityService commodityService;

    @Test
    public void testSave() {
        Commodity commodity = new Commodity();

        commodity.setId("21102101");
        commodity.setName("索尼（SONY）Play Station 5高清家用游戏机 PS5体感游戏机 日版 数字版");
        commodity.setCategory("1");
        commodity.setPrice(4499);
        commodity.setBrand("索尼");
        commodityService.save(commodity);

        commodity = new Commodity();
        commodity.setId("21102102");
        commodity.setName("英伟达 RTX 3070 3080 3080ti 3090 原厂公版AI深度学习GPU运算显卡 NVIDIA RTX 3090 24G 公版");
        commodity.setCategory("1");
        commodity.setPrice(23799);
        commodity.setBrand("英伟达");
        commodityService.save(commodity);

        commodity = new Commodity();
        commodity.setId("21102103");
        commodity.setName("索尼（SONY）Play Station 5高清家用游戏机 PS5/PS4 Pro体感游戏机 日版 光驱版");
        commodity.setCategory("1");
        commodity.setPrice(5299);
        commodity.setBrand("索尼");
        commodityService.save(commodity);
    }

    @Test
    public void testCount() {
        long count = commodityService.count();
        System.out.println(" test count " + count);
    }

    @Test
    public void testDelete() {
        Commodity commodity = new Commodity();
        commodity.setId("21102102");

        commodityService.delete(commodity);

        System.out.println(" test delete count " + commodityService.count());
    }

    @Test
    public void testGetAll() {
        List<Commodity> all = commodityService.getAll();
        Assert.assertTrue(all != null && all.size() > 0);
        System.out.println("test get all : " + all);
    }

    @Test
    public void testGetByName() {
        List<Commodity> list = commodityService.getByName("Pro体感游戏机");
        Assert.assertTrue(list != null && list.size() > 0);
        System.out.println("test get by name : " + list);
    }

    @Test
    public void testPage() {
        CommodityQueryVo queryVo = new CommodityQueryVo();
        queryVo.setPage(0).setSize(10).setPriceStart(5000).setPriceEnd(6000);

        Page<Commodity> page = commodityService.pageQuery(queryVo);
        System.out.println(" test page " + page.getTotalPages());
        System.out.println(" test page " + page.getNumber());
        System.out.println(" test page " + page.getContent());
    }

}
