class SistemaGestionRestaurante(val mesas: List<Mesa>) {

    fun realizarPedido(numeroMesa: Int, pedido: Pedido) {
        val mesa = mesas.find { it.numero == numeroMesa }
        if (mesa != null && mesa.estado == EstadoMesa.OCUPADA) {
            mesa.agregarPedido(pedido)
        } else {
            println("La mesa no está ocupada y no puede recibir pedidos.")
        }
    }

    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {
        val mesa = mesas.find { it.numero == numeroMesa }
        if (mesa != null) {
            if (numeroPedido == null) {
                if (mesa.pedidos.isNotEmpty()) {
                    mesa.pedidos.last().estado = EstadoPedido.SERVIDO
                }
            } else {
                val pedido = mesa.pedidos.find { it.numero == numeroPedido }
                if (pedido != null) {
                    pedido.estado = EstadoPedido.SERVIDO
                }
            }
        }
    }

    fun cerrarMesa(numeroMesa: Int) {
        val mesa = mesas.find { it.numero == numeroMesa }
        if (mesa != null && mesa.pedidos.all { it.estado == EstadoPedido.SERVIDO }) {
            mesa.liberarMesa()
        } else {
            println("No todos los pedidos están servidos.")
        }
    }

    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }

    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }

    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }
}