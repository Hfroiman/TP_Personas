
public class DNIinvalido extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DNIinvalido() {
	}
	@Override
	public String getMessage() {
		return "ERROR, dni invalido";
	}
}
