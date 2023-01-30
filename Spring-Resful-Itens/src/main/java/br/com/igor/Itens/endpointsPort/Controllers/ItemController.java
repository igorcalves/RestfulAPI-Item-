package br.com.igor.Itens.endpointsPort.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.Itens.endpointsPort.Services.ItemService;
import br.com.igor.Itens.endpointsPort.dataVO.ItemVO;
import br.com.igor.Itens.endpointsPort.model.Item;

@RestController
@RequestMapping("/item/v1")
public class ItemController {

    @Autowired
    ItemService service;


    @GetMapping()
    public List<ItemVO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ItemVO findById(@PathVariable(value = "id") Long id) throws Exception{
        return service.findById(id);
    }
    
}
