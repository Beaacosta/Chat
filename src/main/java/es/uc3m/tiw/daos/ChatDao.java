package es.uc3m.tiw.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import es.uc3m.tiw.dominios.Chat;

public interface ChatDao extends  JpaRepository<Chat, Long>{

}
