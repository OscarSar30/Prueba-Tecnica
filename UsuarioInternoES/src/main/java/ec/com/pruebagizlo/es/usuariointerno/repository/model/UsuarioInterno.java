package ec.com.pruebagizlo.es.usuariointerno.repository.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_usuario_interno")
public class UsuarioInterno extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String area;
	@NotNull
	@Email(message = "no es una direccion de correo valida")
	private String emailCorporativo;
	private Double valorIESS;

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the emailCorporativo
	 */
	public String getEmailCorporativo() {
		return emailCorporativo;
	}

	/**
	 * @param emailCorporativo the emailCorporativo to set
	 */
	public void setEmailCorporativo(String emailCorporativo) {
		this.emailCorporativo = emailCorporativo;
	}

	/**
	 * @return the valorIESS
	 */
	public Double getValorIESS() {
		return valorIESS;
	}

	/**
	 * @param valorIESS the valorIESS to set
	 */
	public void setValorIESS(Double valorIESS) {
		this.valorIESS = valorIESS;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
