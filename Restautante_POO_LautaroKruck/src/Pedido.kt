class Pedido (val platos: MutableList<Plato> = mutableListOf(),  var estado: EstadoPedido = EstadoPedido.PENDIENTE){
    val numero = ++numeroPedido
    companion object {
        var numeroPedido = 0
    }

    fun agregarPlato(plato: Plato) {
        platos.add(plato)
    }
    fun eliminarPlato(nombrePlato: String): Boolean {
        val platoAEliminar = platos.find { it.nombre == nombrePlato }
        return platoAEliminar?.let { platos.remove(it) } ?: false
    }

    fun calcularPrecio(): Double {
        var precioTotal = 0.00
        for (plato in platos) {
            precioTotal += plato.precio
        }
        return precioTotal
    }
    fun calcularTiempo(): Int {
        var tiempoTotal = 0
        for (plato in platos) {
            tiempoTotal += plato.tiempoPreparacion
        }
        return tiempoTotal
    }

    override fun toString(): String {
        val Platos = platos.joinToString(separator = "\n") { it.toString() }
        return "$Platos \nEstado: ${estado.name.lowercase()} \nTotal: ${calcularPrecio()}€, Tiempo: ${calcularTiempo()} min."
    }
}