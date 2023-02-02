package br.com.igor.Itens.endpointsPort.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.igor.Itens.endpointsPort.model.Item;

@Component
public interface ItemRepository extends JpaRepository<Item,Long> {
    
}
