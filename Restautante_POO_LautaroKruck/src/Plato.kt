class Plato(var nombre: String, var precio: Double, var tiempoPreparacion: Int, private val ingredientes: MutableList<String>) {

    init {
        require(precio > 0) { "El precio no puede ser negativo." }
        require(tiempoPreparacion > 0) { "El tiempo de preparacion no puede ser negativo." }
        require(nombre.trim().isNotEmpty()) { "El nombre no puede estar vacío." }

    }

    fun agregarIngrediente(ingrediente: String) {
        require(ingrediente.trim().isNotEmpty()) { "El ingrediente no puede estar vacío." }
        ingredientes.add(ingrediente)
    }

    private fun formatIngredientes(): String {
        var listaIngredientes = ""
        for (i in ingredientes.indices) {
            listaIngredientes += when {
                i == ingredientes.size - 1 && ingredientes.size > 1 -> " y ${ingredientes[i]}"
                i == ingredientes.size - 2 -> ingredientes[i]
                else -> "${ingredientes[i]}, "
            }
        }
        return listaIngredientes
    }

    override fun toString(): String {
        val listaIngredientes = formatIngredientes()
        return "$nombre ($tiempoPreparacion min.) -> $precio€ ($listaIngredientes)"
    }
}