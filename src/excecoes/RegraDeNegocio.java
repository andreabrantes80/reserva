package excecoes;

public class RegraDeNegocio extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RegraDeNegocio(String msg) {
		super(msg);
	}

}
