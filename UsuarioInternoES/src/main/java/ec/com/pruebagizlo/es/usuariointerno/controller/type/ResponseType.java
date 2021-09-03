package ec.com.pruebagizlo.es.usuariointerno.controller.type;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Canonical Response Model
 */
@Schema(description = "Canonical Response Model")
public class ResponseType {
	@JsonProperty("codeResponse")
	private String codeResponse;

	@JsonProperty("description")
	private String description;

	public ResponseType codeResponse(String codeResponse) {
		this.codeResponse = codeResponse;
		return this;
	}

	/**
	 * Get codeResponse
	 * 
	 * @return codeResponse
	 **/
	@Schema(description = "")

	public String getCodeResponse() {
		return codeResponse;
	}

	public void setCodeResponse(String codeResponse) {
		this.codeResponse = codeResponse;
	}

	public ResponseType description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/
	@Schema(description = "")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResponseType responseType = (ResponseType) o;
		return Objects.equals(this.codeResponse, responseType.codeResponse)
				&& Objects.equals(this.description, responseType.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeResponse, description);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResponseType {\n");

		sb.append("    codeResponse: ").append(toIndentedString(codeResponse)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
