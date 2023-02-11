package br.com.igor.Itens.endpointsPort.UnittiesTest.Mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.igor.Itens.endpointsPort.UnittiesTest.Mock.MockItem;
import br.com.igor.Itens.endpointsPort.dataVO.ItemVO;
import br.com.igor.Itens.endpointsPort.mapper.DozerMapper;
import br.com.igor.Itens.endpointsPort.model.Item;

public class MapperConverterItemTest {

    MockItem input = new MockItem();

    @Test
    public void parseEntityToVO(){
        ItemVO item = DozerMapper.parseObject(input.mockEntity(1), ItemVO.class);
        assertEquals(1L, item.getKey());
        assertEquals("item test1", item.getName());
        assertEquals("description test1", item.getDescription());
        assertEquals(10.00, item.getPrice());
        assertNotNull(item.getSince());
    }

    @Test
    public void parseVOtoEntity(){
        Item item = DozerMapper.parseObject(input.mockEntityVO(1), Item.class);
        assertEquals("item test1", item.getName());
        assertEquals("description test1", item.getDescription());
        assertEquals(10.00, item.getPrice());
        assertNotNull(item.getSince());
    }

    @Test
    public void parveEntityToVOList(){
        List<ItemVO> itens = DozerMapper.parseListObjects(input.mockListEntity(), ItemVO.class);
        ItemVO item1 = itens.get(1);
        assertEquals("item test1", item1.getName());
        assertEquals("description test1", item1.getDescription());
        assertEquals(10.00, item1.getPrice());
        assertNotNull(item1.getSince());

        ItemVO item9 = itens.get(9);
        assertEquals("item test9", item9.getName());
        assertEquals("description test9", item9.getDescription());
        assertEquals(10.00, item9.getPrice());
        assertNotNull(item9.getSince());

        ItemVO item11 = itens.get(11);
        assertEquals("item test11", item11.getName());
        assertEquals("description test11", item11.getDescription());
        assertEquals(10.00, item11.getPrice());
        assertNotNull(item11.getSince());






    }
    
}
