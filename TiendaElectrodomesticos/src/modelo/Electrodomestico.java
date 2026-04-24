package modelo;

public class Electrodomestico {
	private int id;
	private String tipo;
	private String marca;
	private float precio;
	private float consumo;
	private boolean vendido;
	
	public Electrodomestico() {
		id = 0;
		tipo = null;
		marca = null;
		precio = 0;
		consumo = 0;
		vendido = false;
	}

	public Electrodomestico(int id, String tipo, String marca, float precio, float consumo, boolean vendido) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.marca = marca;
		this.precio = precio;
		this.consumo = consumo;
		this.vendido = vendido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
}
