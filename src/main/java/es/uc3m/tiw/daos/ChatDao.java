package es.uc3m.tiw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import es.uc3m.tiw.dominios.Chat;

public interface ChatDao extends  JpaRepository<Chat, Long>{
	List<Chat> findAll();

	List<Chat> findByEmisorAndReceptorOrderByIdChatAsc(int emisor, int receptor);

	List<Chat> findByEmisor(int emisor);

	List<Chat> findByReceptor(int receptor);

}
