package br.com.igor.Itens.endpointsPort.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.Itens.endpointsPort.Config.util.MediaType;
import br.com.igor.Itens.endpointsPort.Services.ItemService;
import br.com.igor.Itens.endpointsPort.dataVO.ItemVO;

@RestController
@RequestMapping("/v1/item")
public class ItemController {

    @Autowired
    ItemService service;



    @GetMapping(produces = {
        MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML})
    public List<ItemVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {
        MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML})
    public ItemVO findById(@PathVariable(value = "id") Long id)  {
        return service.findById(id);
    }

    @PostMapping(produces = {
        MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML}, 
            consumes ={ 
                    MediaType.APPLICATION_JSON, 
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public ItemVO create(@RequestBody ItemVO itemVO){
        return service.create(itemVO);
    }

    @PutMapping(produces = {
        MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML}, 
            consumes ={ 
                    MediaType.APPLICATION_JSON, 
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public ItemVO update(@RequestBody ItemVO itemVO){
        return service.update(itemVO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
       service.delete(id);
    }
}
