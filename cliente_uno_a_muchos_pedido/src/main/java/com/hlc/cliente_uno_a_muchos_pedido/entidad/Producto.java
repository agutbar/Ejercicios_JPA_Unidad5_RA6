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
}
