class Mesa (val pedidos: MutableList<Pedido> = mutableListOf(), var estado: EstadoMesa = EstadoMesa.LIBRE, var capacidad: Int){
    val numero = ++numeroMesa

    companion object {
        var numeroMesa = 0
    }

    fun ocuparMesa() {
        if (estado == EstadoMesa.LIBRE) {
            estado = EstadoMesa.OCUPADA
        }
    }
    fun ocuparReserva() {
        if (estado == EstadoMesa.RESERVADA) {
            estado = EstadoMesa.OCUPADA
        }
    }

    fun liberarMesa() {
        estado = EstadoMesa.LIBRE
        pedidos.clear()
    }

    fun agregarPedido(pedido: Pedido) {
        if (estado == EstadoMesa.OCUPADA) {
            pedidos.add(pedido)
        }
    }

    override fun toString(): String {
        val estadoMesa = "Estado de la mesa: $estado"
        val infoMesa = "Mesa #$numero (Capacidad: $capacidad)"
        val pedidosStr = if (pedidos.isEmpty()) {
            "No hay pedidos."
        } else {
            pedidos.joinToString(separator = "\n") { it.toString() }
        }

        return "$infoMesa\n$estadoMesa\n$pedidosStr"
    }
}