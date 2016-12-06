package es.uc3m.tiw.dominios;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="CHAT")
public class Chat implements Serializable {
	@Id
	private Date fecha;
	@Column(nullable = false)
	//email del emisor
	private String emisor;
	@Column(nullable = false)
	//email del receptor
	private String receptor;
	@Column(nullable = false)
	private String mensaje;
	public Chat(Date fecha, String emisor, String receptor, String mensaje) {
		super();
		this.fecha = fecha;
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

		
}