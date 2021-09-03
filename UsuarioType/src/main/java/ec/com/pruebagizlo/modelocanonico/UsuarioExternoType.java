package ec.com.pruebagizlo.modelocanonico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UsuarioExternoType extends UsuarioType {

	@NotNull
	@Email(message = "no es una direccion de correo valida")
	private String email;
	private Integer horasFreeLancer;
	private Boolean esUniversitario;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the horasFreeLancer
	 */
	public Integer getHorasFreeLancer() {
		return horasFreeLancer;
	}

	/**
	 * @param horasFreeLancer the horasFreeLancer to set
	 */
	public void setHorasFreeLancer(Integer horasFreeLancer) {
		this.horasFreeLancer = horasFreeLancer;
	}

	/**
	 * @return the esUniversitario
	 */
	public Boolean getEsUniversitario() {
		return esUniversitario;
	}

	/**
	 * @param esUniversitario the esUniversitario to set
	 */
	public void setEsUniversitario(Boolean esUniversitario) {
		this.esUniversitario = esUniversitario;
	}

}
