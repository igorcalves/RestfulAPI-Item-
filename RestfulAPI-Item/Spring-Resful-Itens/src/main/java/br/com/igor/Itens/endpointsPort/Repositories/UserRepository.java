package br.com.igor.Itens.endpointsPort.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.igor.Itens.endpointsPort.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.username =:username")
    User findByUserName(@Param ("username") String username); 
    
}
