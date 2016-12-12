package es.uc3m.tiw.dominios;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="CHAT")
public class Chat implements Serializable {
	@Id
	private Calendar fecha;
	@Column(nullable = false)
	private String mensaje;
	@ManyToOne
	private Usuario emisor;
	@ManyToOne
	private Usuario receptor;
	
	public Chat(Usuario receptor, String mensaje, Usuario emisor) {
		super();
		this.fecha = Calendar.getInstance();
		this.receptor = receptor;
		this.mensaje = mensaje;
		this.emisor = emisor;
	}


	public Calendar getFecha() {
		return fecha;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}


	public Usuario getReceptor() {
		return receptor;
	}


	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}


	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

		
}