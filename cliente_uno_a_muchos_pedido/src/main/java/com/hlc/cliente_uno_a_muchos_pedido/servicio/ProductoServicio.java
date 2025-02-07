package com.hlc.cliente_uno_a_muchos_pedido.servicio;

import java.util.List;
import java.util.Set;

import com.hlc.cliente_uno_a_muchos_pedido.entidad.Producto;
import com.hlc.cliente_uno_a_muchos_pedido.entidad.Pedido;

public interface ProductoServicio {
	  Producto guardarProducto(Producto producto);
	  Producto obtenerProductoPorId(Long id);
	  List<Producto> obtenerTodosLosProductos();
	  Producto actualizarProducto(Long id, Producto producto);
	  void eliminarProducto(Long id);
	  Set<Pedido> obtenerPedidosConProducto(Producto producto);
}
