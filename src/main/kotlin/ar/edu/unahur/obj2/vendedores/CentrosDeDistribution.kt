package ar.edu.unahur.obj2.vendedores

class CentrosDeDistribution(val ciudad: Ciudad) {

    val vendedores = mutableListOf<Vendedor>()

    fun agregarVendedor(vendedor: Vendedor) {
     // Aca verifica si esta o no ya agregegado en al lista
        if (vendedores.contains(vendedor)) {
            print("Este vendedor ya esta en la lista")
        }
        // Aca si no esta en la lista lo agrega
        else vendedores.add (vendedor)
    }

    fun sacarVendedor (vendedor: Vendedor) {
        vendedores.remove(vendedor)
    }
    // Devuelve el elemento maximo basado en el predicado.
    fun vendedorEstrella() = vendedores.maxBy { c -> c.puntajeCertificaciones()}
    
}