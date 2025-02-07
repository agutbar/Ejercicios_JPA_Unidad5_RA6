package com.hlc.cliente_uno_a_muchos_pedido.entidad;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank(message = "El nombre del producto no puede estar vacío")
	private String nombre;
	
	@NotNull
	@NotBlank(message = "Debe incluir una descripcion del producto")
	private String descripcion;
	
	@NotNull
	@NotBlank(message = "Debe incluir el peso del producto")
	private float peso;
	
	@NotNull
	@NotBlank(message = "Debe incluir el stock del producto")
	private int stock;
	
	@ManyToMany
    @JoinTable(
        name = "producto_pedido", 
        joinColumns = @JoinColumn(name = "producto_id"), 
        inverseJoinColumns = @JoinColumn(name = "pedido_id")
    )
	private Set<Pedido> pedidos;
	
	public Producto() {}
	
	public Producto(Long id, @NotNull @NotBlank(message = "El nombre del producto no puede estar vacío") String nombre,
			@NotNull @NotBlank(message = "Debe incluir una descripcion del producto") String descripcion,
			@NotNull @NotBlank(message = "Debe incluir el peso del producto") float peso,
			@NotNull @NotBlank(message = "Debe incluir el stock del producto") int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
	}

	public Producto(Long id, @NotNull @NotBlank(message = "El nombre del producto no puede estar vacío") String nombre,
			@NotNull @NotBlank(message = "Debe incluir una descripcion del producto") String descripcion,
			@NotNull @NotBlank(message = "Debe incluir el peso del producto") float peso,
			@NotNull @NotBlank(message = "Debe incluir el stock del producto") int stock, Set<Pedido> pedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
		this.pedidos = pedidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
