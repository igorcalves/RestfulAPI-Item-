package br.com.igor.Itens.endpointsPort.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.Itens.endpointsPort.Exceptions.RequiredObjectIsNullException;
import br.com.igor.Itens.endpointsPort.Exceptions.ResourceNotFoundException;
import br.com.igor.Itens.endpointsPort.Repositories.ItemRepository;
import br.com.igor.Itens.endpointsPort.dataVO.ItemVO;
import br.com.igor.Itens.endpointsPort.mapper.DozerMapper;
import br.com.igor.Itens.endpointsPort.model.Item;

@Service
public class ItemService {
    
    @Autowired
    ItemRepository repository;

    public List<ItemVO> findAll(){
        var itens = DozerMapper.parseListObjects(repository.findAll(),ItemVO.class);
        return itens;
    }

    public ItemVO findById(Long id)  {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("item id not found"));
        var vo = DozerMapper.parseObject(entity, ItemVO.class);
        return vo;
    }

    public ItemVO create(ItemVO item){
        if(item == null) throw new RequiredObjectIsNullException();
        Item entity = DozerMapper.parseObject(item, Item.class);
        var vo = DozerMapper.parseObject(repository.save(entity),ItemVO.class);
        return vo;
    }

}
