package ec.com.pruebagizlo.modelocanonico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UsuarioInternoType extends UsuarioType {

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

}
