package br.com.igor.Itens.endpointsPort.UnittiesTest.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.igor.Itens.endpointsPort.dataVO.ItemVO;
import br.com.igor.Itens.endpointsPort.model.Item;

public class MockItem {

    public Item mockEntity(Integer id){
        Item item = new Item();
        item.setId(1L);
        item.setName("item test"+id);
        item.setDescription("description test" + id);
        item.setSince(LocalDate.now());
        item.setPrice(10.00);
        return item;

    }
    public List<Item> mockListEntity(){
        List<Item> itens = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            itens.add(mockEntity(i));
        }

        return itens;
    }

    public ItemVO mockEntityVO(Integer id){
        ItemVO item = new ItemVO();
        item.setKey(1L);
        item.setName("item test"+id);
        item.setDescription("description test" + id);
        item.setSince(LocalDate.now());
        item.setPrice(10.00);
        return item;

    }

    public List<ItemVO> mockListVO(){
        List<ItemVO> itens = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            itens.add(mockEntityVO(i));
        }

        return itens;
    }

    
    
}
