class Pedido (private val platos: List<Plato>, val estado: Estado = Estado.PENDIENTE){
    val numero = ++numeroPedido
    companion object {
        var numeroPedido = 0
    }

    fun agregarPlato(plato: Plato){

    }
    fun eliminarPlato(): String


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
        return """ """

    }
}