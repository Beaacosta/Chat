package es.uc3m.tiw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.daos.ChatDao;
import es.uc3m.tiw.dominios.Chat;
import es.uc3m.tiw.dominios.Conversacion;
import es.uc3m.tiw.dominios.Usuario;



@RestController
// La siguiente anotación es necesaria para permitir 
// que diferente dominios puedan usar este microservicio
@CrossOrigin
public class Controlador {
	
	private Chat chat;
	@Autowired
	private ChatDao dao;
	
	//Buscar un producto en la BBDD por id
	@RequestMapping(value = "/buscar_mensaje", method = RequestMethod.POST)
	public @ResponseBody List<Chat> buscarEmisor(@RequestBody Conversacion conv){
		int emisor = conv.getEmisor().getId();
		int receptor = conv.getReceptor().getId();
		List<Chat> mensajes= dao.findByEmisorAndReceptorOrderByIdChatAsc(emisor, receptor);
		return mensajes;
	}
	
	//Añadir un mensaje en la BBDD 
	@RequestMapping(value = "/anyadir_mensaje", method = RequestMethod.POST)
	public void anyadirMensaje(@RequestBody Chat chat){
		String bea = chat.getMensaje();
		dao.save(chat);	
	}
	
	//Buscar los productos de un usuario en la BBDD
	@RequestMapping(value = "/listar_receptores", method = RequestMethod.POST)
	public @ResponseBody List<Chat> listarReceptores(@RequestBody Usuario usuario_ses){
		int emisor = usuario_ses.getId();
		List<Chat> receptores= null;
		receptores = dao.findByEmisor(emisor);
		return receptores;
	}	

}
