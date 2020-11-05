package eda2;

public abstract class Pedido {
	private Integer numeroDePedido;

	public Pedido() {
		super();
	}

	protected Integer getNumeroDePedido() {
		return numeroDePedido;
	}

	protected void setNumeroDePedido(Integer numeroDePedido) {
		this.numeroDePedido = numeroDePedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDePedido == null) ? 0 : numeroDePedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (numeroDePedido == null) {
			if (other.numeroDePedido != null)
				return false;
		} else if (!numeroDePedido.equals(other.numeroDePedido))
			return false;
		return true;
	}
	
}
