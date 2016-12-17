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
	@Column
	private int emisor;
	@Column
	private int receptor;
	public Chat(Calendar fecha, String mensaje, int emisor, int receptor) {
		super();
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.emisor = emisor;
		this.receptor = receptor;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getEmisor() {
		return emisor;
	}
	public void setEmisor(int emisor) {
		this.emisor = emisor;
	}
	public int getReceptor() {
		return receptor;
	}
	public void setReceptor(int receptor) {
		this.receptor = receptor;
	}
	
}