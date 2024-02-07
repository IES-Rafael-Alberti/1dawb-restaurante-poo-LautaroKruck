class Plato(var nombre: String, var precio: Double, var tiempoPreparacion: Int, private val ingredientes: MutableList<String>) {

    init {
        require(precio > 0) { "El precio no puede ser negativo." }
        require(tiempoPreparacion > 0) { "El tiempo de preparacion no puede ser negativo." }
        require(nombre.trim().isNotEmpty()) { "El nombre no puede estar vacío." }

    }

    /*
    agregarIngrediente(ingrediente: String): Añade un nuevo ingrediente a la lista de ingredientes del plato.
    toString(): Retornar la información del plato (por ejemplo, "Hamburguesa (8 min.) -> 8.99€ (carne, huevo, queso, pan y tomate)")
     */
    fun agregarIngrediente(ingrediente: String): MutableList<String> {

        ingredientes
        return ingredientes
    }

    override fun toString(): String {
        return "$nombre ($tiempoPreparacion min.) -> $precio€ $ingredientes"
    }
}