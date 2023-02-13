package br.com.igor.Itens.endpointsPort.Serializable;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamilJackson2HttpMessasgeConverter extends AbstractJackson2HttpMessageConverter{

    private ObjectMapper objectMapper;

	public YamilJackson2HttpMessasgeConverter() {
		super(new YAMLMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL),MediaType.parseMediaType("application/x-yaml"));
        this.objectMapper = this.getObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        this.objectMapper.registerModule(module);
    
    }

    public YamilJackson2HttpMessasgeConverter(ObjectMapper objectMapper) {
        super(objectMapper, MediaType.parseMediaType("application/x-yaml"));
        this.objectMapper = objectMapper;
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        this.objectMapper.registerModule(module);
    }


}