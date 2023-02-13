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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/item/v1")
@Tag(name = "Item", description = "Endpoints for Managing Itens")
public class ItemController {

    @Autowired
    ItemService service;



    @GetMapping(produces = {
        MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML})
        @Operation(summary = "Finds all Itens", description = "Finds All Itens",
        tags = {"Item"},
        responses = {
                @ApiResponse(description = "Success", responseCode = "200",
                        content = {
                         @Content(
                                 mediaType = "application/json",
                                 array = @ArraySchema(schema = @Schema(implementation = ItemVO.class))
                                 )
                    }),
                @ApiResponse(description = "No Content", responseCode = "204",content = {@Content}),
                @ApiResponse(description = "Bad Request", responseCode = "400",content = {@Content}),
                @ApiResponse(description = "Unauthorized", responseCode = "401",content = {@Content}),
                @ApiResponse(description = "Not Found", responseCode = "404",content = {@Content}),
                @ApiResponse(description = "Internal Error", responseCode = "500",content = {@Content})
        })
    public List<ItemVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {
        MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML})
    @Operation(summary = "Finds an Item", description = "Finds an Item",
        tags = {"Item"},
        responses = {
                @ApiResponse(description = "Success", responseCode = "200",
                        content = @Content(schema = @Schema(implementation = ItemVO.class))),
                @ApiResponse(description = "No Content", responseCode = "204",content = {@Content}),
                @ApiResponse(description = "Bad Request", responseCode = "400",content = {@Content}),
                @ApiResponse(description = "Unauthorized", responseCode = "401",content = {@Content}),
                @ApiResponse(description = "Not Found", responseCode = "404",content = {@Content}),
                @ApiResponse(description = "Internal Error", responseCode = "500",content = {@Content})
        })    
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
    @Operation(summary = "Adds a new  Item in JSON, XML or YML", description = "Adds a new  Item in JSON, XML or YML",
                    tags = {"Item"},
                    responses = {
                            @ApiResponse(description = "Success", responseCode = "200",
                                    content = @Content(schema = @Schema(implementation = ItemVO.class))),
                            @ApiResponse(description = "Bad Request", responseCode = "400",content = {@Content}),
                            @ApiResponse(description = "Unauthorized", responseCode = "401",content = {@Content}),
                            @ApiResponse(description = "Internal Error", responseCode = "500",content = {@Content}),
                    })
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
    @Operation(summary = "Update  an Item by parsing in a JSON ,XML or YML", description = "Update  an Item by parsing in a JSON ,XML or YML",
	tags = {"Item"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = ItemVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400",content = {@Content}),
			@ApiResponse(description = "Unauthorized", responseCode = "401",content = {@Content}),
			@ApiResponse(description = "Not Found", responseCode = "404",content = {@Content}),
			@ApiResponse(description = "Internal Error", responseCode = "500",content = {@Content})
	})
    public ItemVO update(@RequestBody ItemVO itemVO){
        return service.update(itemVO);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "delete an Item by id", description = "delete an Item by id",
	tags = {"Item"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204",content = {@Content}),
			@ApiResponse(description = "Bad Request", responseCode = "400",content = {@Content}),
			@ApiResponse(description = "Unauthorized", responseCode = "401",content = {@Content}),
			@ApiResponse(description = "Not Found", responseCode = "404",content = {@Content}),
			@ApiResponse(description = "Internal Error", responseCode = "500",content = {@Content})
	})
    public String delete(@PathVariable(value = "id") Long id){
       service.delete(id);
       return "id " + id +  " Deleted";
    }
}
