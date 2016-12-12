package es.uc3m.tiw.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.daos.ChatDao;
import es.uc3m.tiw.dominios.Chat;



@RestController
// La siguiente anotación es necesaria para permitir 
// que diferente dominios puedan usar este microservicio
@CrossOrigin
public class Controlador {
	
	private Chat chat;
	private ChatDao dao;
	
	//Buscar un producto en la BBDD por id
	@RequestMapping(value = "/buscar_mensaje", method = RequestMethod.GET)
	public List<Chat> buscarEmisor(@RequestParam(value = "emisor", required = true) String emisor, @RequestParam(value = "receptor", required = true) String receptor){
		List<Chat> mensajes= dao.findByEmisorAndReceptorOrderByFechaAsc(emisor, receptor);
		return mensajes;
	}
	
	//Añadir un mensaje en la BBDD 
	@RequestMapping(value = "/anyadir_mensaje", method = RequestMethod.GET)
	public void anyadirMensaje(@RequestParam(value = "chat", required = true) Chat chat){
		dao.save(chat);	
	}
	

}
