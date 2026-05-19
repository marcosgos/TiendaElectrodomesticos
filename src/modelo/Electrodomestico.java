package modelo;

/**
 * Clase electrodoméstico con sus atributos necesarios
 */
public class Electrodomestico {
	private int id;
	private String tipo;
	private String marca;
	private float precio;
	private float consumo;
	private boolean vendido;
	
	/**
	 * Constructor por defecto para el objeto electrodoméstico
	 */
	public Electrodomestico() {
		id = 0;
		tipo = null;
		marca = null;
		precio = 0;
		consumo = 0;
		vendido = false;
	}
	
	/**
	 * Constructor por parametros para el objeto electrodoméstico
	 * @param id
	 * @param tipo
	 * @param marca
	 * @param precio
	 * @param consumo
	 * @param vendido
	 */
	public Electrodomestico(int id, String tipo, String marca, float precio, float consumo, boolean vendido) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.marca = marca;
		this.precio = precio;
		this.consumo = consumo;
		this.vendido = vendido;
	}
	
	/**
	 * Método que devuelve el id
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Método que rellena el objeto con el id que le pasamos
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Método que devuelve el tipo
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Método que rellena el objeto con el tipo que le pasamos
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Método que devuelve la marca
	 * @return
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * Método que rellena el objeto con la marca que le pasamos
	 * @param marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	/**
	 * Método que devuelve el precio
	 * @return
	 */
	public float getPrecio() {
		return precio;
	}
	
	/**
	 * Método que rellena el objeto con el precio que le pasamos
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	/**
	 * Método que devuelve el consumo
	 * @return
	 */
	public float getConsumo() {
		return consumo;
	}
	
	/**
	 * Método que rellena el objeto con el consumo que le pasamos
	 * @param consumo
	 */
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	
	/**
	 * Método que devuelve true o false si está vendido o no
	 * @return
	 */
	public boolean isVendido() {
		return vendido;
	}
	
	/**
	 * Método que rellena el objeto sabiendo si está vendido o no, con lo que le pasamos
	 * @param vendido
	 */
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
}