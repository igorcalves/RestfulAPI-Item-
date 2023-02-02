package br.com.igor.Itens.endpointsPort.Config;


import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import br.com.igor.Itens.endpointsPort.Serializable.LocalDateSerializer;
import br.com.igor.Itens.endpointsPort.Serializable.YamilJackson2HttpMessasgeConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer  {
    

    private static final MediaType MEDIA_TYPE_APPLICATION_YML= MediaType.valueOf("application/x-yaml");
    


    @Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamilJackson2HttpMessasgeConverter());
        ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new SimpleModule().addSerializer(LocalDate.class, new LocalDateSerializer()));
    converters.add(new YamilJackson2HttpMessasgeConverter(objectMapper));
	}

    @Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer.favorParameter(false)
        .ignoreAcceptHeader(false)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json", MediaType.APPLICATION_JSON)
            .mediaType("xml", MediaType.APPLICATION_XML)
            .mediaType("yml", MEDIA_TYPE_APPLICATION_YML);
    }
}
