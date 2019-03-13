/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sistemcobro.davivienda.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author jhurtado
 */
@Entity
@Table(name = "comite_estado")
@XmlRootElement
public class ComiteEstado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcomiteestado;

	private String nombre;
	private Integer idComite;
	private Short estado;
	private int idrevision;
	private String observacion;
	private Integer idUsuarioCrea;

	public ComiteEstado() {
	}

	public int getIdrevision() {
		return idrevision;
	}

	public void setIdrevision(int idrevision) {
		this.idrevision = idrevision;
	}

	public ComiteEstado(Integer idcomiteestado) {
		this.idcomiteestado = idcomiteestado;
	}

	public Integer getIdcomiteestado() {
		return idcomiteestado;
	}

	public void setIdcomiteestado(Integer idcomiteestado) {
		this.idcomiteestado = idcomiteestado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Short getEstado() {
		return estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcomiteestado != null ? idcomiteestado.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ComiteEstado)) {
			return false;
		}
		ComiteEstado other = (ComiteEstado) object;
		if ((this.idcomiteestado == null && other.idcomiteestado != null)
				|| (this.idcomiteestado != null && !this.idcomiteestado.equals(other.idcomiteestado))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "test3.ComiteEstado[ idcomiteestado=" + idcomiteestado + " ]";
	}

	public Integer getIdComite() {
		return idComite;
	}

	public void setIdComite(Integer idComite) {
		this.idComite = idComite;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getIdUsuarioCrea() {
		return idUsuarioCrea;
	}

	public void setIdUsuarioCrea(Integer idUsuarioCrea) {
		this.idUsuarioCrea = idUsuarioCrea;
	}

}
