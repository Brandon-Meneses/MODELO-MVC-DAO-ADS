package org.example;

import org.example.controller.*;
import org.example.model.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();
        ClienteController clienteController = new ClienteController();
        VentaController ventaController = new VentaController();
        FacturaController facturaController = new FacturaController();
        InventarioController inventarioController = new InventarioController();
        ProductoController productoController = new ProductoController();
        PedidoController pedidoController = new PedidoController();

        // Crear un nuevo usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setIdUsuario(1);
        nuevoUsuario.setNombre("Juan Perez");
        nuevoUsuario.setCorreo("juan.perez@example.com");
        nuevoUsuario.setContrasena("password123");
        nuevoUsuario.setRol("admin");
        usuarioController.addUsuario(nuevoUsuario);

        // Leer un usuario
        Usuario usuario = usuarioController.getUsuario(1);
        if (usuario != null) {
            System.out.println("Usuario leído: " + usuario.getNombre());
        }

        // Actualizar un usuario
        if (usuario != null) {
            usuario.setCorreo("juan.perez@updated.com");
            usuarioController.updateUsuario(usuario);
        }

        // Eliminar un usuario
        usuarioController.deleteUsuario(1);

        // Obtener todos los usuarios
        List<Usuario> usuarios = usuarioController.getAllUsuarios();
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre());
        }

        // Crear un nuevo cliente
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setIdCliente(1);
        nuevoCliente.setNombre("Ana Gomez");
        nuevoCliente.setCorreo("ana.gomez@example.com");
        nuevoCliente.setDireccion("Calle Falsa 123");
        nuevoCliente.setTelefono("123456789");
        clienteController.addCliente(nuevoCliente);

        // Leer un cliente
        Cliente cliente = clienteController.getCliente(1);
        if (cliente != null) {
            System.out.println("Cliente leído: " + cliente.getNombre());
        }

        // Actualizar un cliente
        if (cliente != null) {
            cliente.setDireccion("Calle Verdadera 456");
            clienteController.updateCliente(cliente);
        }

        // Eliminar un cliente
        clienteController.deleteCliente(1);

        // Obtener todos los clientes
        List<Cliente> clientes = clienteController.getAllClientes();
        for (Cliente c : clientes) {
            System.out.println(c.getNombre());
        }

        // Crear una nueva venta
        Venta nuevaVenta = new Venta();
        nuevaVenta.setIdVenta(1);
        nuevaVenta.setFecha(new Date());
        nuevaVenta.setTotal(1000.0f);
        nuevaVenta.setIdUsuario(1);
        nuevaVenta.setIdCliente(1);
        ventaController.addVenta(nuevaVenta);

        // Leer una venta
        Venta venta = ventaController.getVenta(1);
        if (venta != null) {
            System.out.println("Venta leída: " + venta.getIdVenta());
        }

        // Actualizar una venta
        if (venta != null) {
            venta.setTotal(1100.0f);
            ventaController.updateVenta(venta);
        }

        // Eliminar una venta
        ventaController.deleteVenta(1);

        // Obtener todas las ventas
        List<Venta> ventas = ventaController.getAllVentas();
        for (Venta v : ventas) {
            System.out.println(v.getIdVenta());
        }

        // Crear una nueva factura
        Factura nuevaFactura = new Factura();
        nuevaFactura.setIdFactura(1);
        nuevaFactura.setFechaEmision(new Date());
        nuevaFactura.setIdVenta(1);
        facturaController.addFactura(nuevaFactura);

        // Leer una factura
        Factura factura = facturaController.getFactura(1);
        if (factura != null) {
            System.out.println("Factura leída: " + factura.getIdFactura());
        }

        // Actualizar una factura
        if (factura != null) {
            factura.setFechaEmision(new Date());
            facturaController.updateFactura(factura);
        }

        // Eliminar una factura
        facturaController.deleteFactura(1);

        // Obtener todas las facturas
        List<Factura> facturas = facturaController.getAllFacturas();
        for (Factura f : facturas) {
            System.out.println(f.getIdFactura());
        }

        // Crear un nuevo inventario
        Inventario nuevoInventario = new Inventario();
        nuevoInventario.setIdInventario(1);
        nuevoInventario.setFechaActualizacion(new Date());
        nuevoInventario.setIdProducto(1);
        nuevoInventario.setCantidad(50);
        inventarioController.addInventario(nuevoInventario);

        // Leer un inventario
        Inventario inventario = inventarioController.getInventario(1);
        if (inventario != null) {
            System.out.println("Inventario leído: " + inventario.getIdInventario());
        }

        // Actualizar un inventario
        if (inventario != null) {
            inventario.setCantidad(60);
            inventarioController.updateInventario(inventario);
        }

        // Eliminar un inventario
        inventarioController.deleteInventario(1);

        // Obtener todos los inventarios
        List<Inventario> inventarios = inventarioController.getAllInventarios();
        for (Inventario i : inventarios) {
            System.out.println(i.getIdInventario());
        }

        // Crear un nuevo producto
        Producto nuevoProducto = new Producto();
        nuevoProducto.setIdProducto(1);
        nuevoProducto.setNombre("Laptop");
        nuevoProducto.setDescripcion("Laptop de última generación");
        nuevoProducto.setPrecio(1500.0f);
        nuevoProducto.setStock(10);
        productoController.addProducto(nuevoProducto);

        // Leer un producto
        Producto producto = productoController.getProducto(1);
        if (producto != null) {
            System.out.println("Producto leído: " + producto.getNombre());
        }

        // Actualizar un producto
        if (producto != null) {
            producto.setPrecio(1400.0f);
            productoController.updateProducto(producto);
        }

        // Eliminar un producto
        productoController.deleteProducto(1);

        // Obtener todos los productos
        List<Producto> productos = productoController.getAllProductos();
        for (Producto p : productos) {
            System.out.println(p.getNombre());
        }

        // Crear un nuevo pedido
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setIdPedido(1);
        nuevoPedido.setIdCliente(1);
        nuevoPedido.setIdProducto(1);
        nuevoPedido.setCantidad(5);
        nuevoPedido.setFecha(new Date());
        pedidoController.addPedido(nuevoPedido);

        // Leer un pedido
        Pedido pedido = pedidoController.getPedido(1);
        if (pedido != null) {
            System.out.println("Pedido leído: " + pedido.getIdPedido());
        }

        // Actualizar un pedido
        if (pedido != null) {
            pedido.setCantidad(10);
            pedidoController.updatePedido(pedido);
        }

        // Eliminar un pedido
        pedidoController.deletePedido(1);

        // Obtener todos los pedidos
        List<Pedido> pedidos = pedidoController.getAllPedidos();
        for (Pedido p : pedidos) {
            System.out.println(p.getIdPedido());
        }
    }
}