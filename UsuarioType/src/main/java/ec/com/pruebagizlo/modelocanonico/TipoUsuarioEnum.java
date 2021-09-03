package ec.com.pruebagizlo.modelocanonico;

public enum TipoUsuarioEnum {

	INTERNO("INTERNO"),
	EXTERNO("EXTERNO");

	private String value;

	TipoUsuarioEnum(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static TipoUsuarioEnum fromValue(String value) {
		for (TipoUsuarioEnum b : TipoUsuarioEnum.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}

}
