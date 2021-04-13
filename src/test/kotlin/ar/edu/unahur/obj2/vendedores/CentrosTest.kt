package ar.edu.unahur.obj2.vendedores
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave

class CentrosTest : DescribeSpec ({
    // Ciudades y Provincias
    val misiones = Provincia(1300000)
    val sanIgnacio = Ciudad(misiones)
    val buenosAires = Provincia (17000000 )
    val moronCity = Ciudad (buenosAires)
    val laPampa = Provincia ( 70500000)
    val santaRosa = Ciudad (laPampa)
    //Centros
    val centroDeDistribucionSa1 = CentrosDeDistribution(sanIgnacio)
    val centroDeDistribucionMo2 = CentrosDeDistribution(moronCity)
    val centroDeDistribucionMo3 = CentrosDeDistribution(santaRosa)
    //Vendedores
    val vendedorFijo1 = VendedorFijo(sanIgnacio)
    val vendedorFijo2 = VendedorFijo(santaRosa)
    val viajante1 = Viajante(listOf(misiones,buenosAires))
    val viajante2 = Viajante(listOf(laPampa))
    // Creamos Certificaciones
    val certificacion10 = Certificacion(true,10)
    val certificacion200 = Certificacion(false,200)
    val certificacion30 = Certificacion(true,30)
    val certificacion300 = Certificacion(true, 300)
    // Agrego certificaciones
    vendedorFijo1.agregarCertificacion(certificacion10)
    vendedorFijo2.agregarCertificacion(certificacion200)
    viajante1.agregarCertificacion(certificacion30)
    // Agrego vendedores a los centro de distrubucion
    centroDeDistribucionSa1.agregarVendedor(vendedorFijo1)
    centroDeDistribucionSa1.agregarVendedor(vendedorFijo2)
    centroDeDistribucionSa1.agregarVendedor(viajante1)

    // Centros: Vendedor estrella
   describe("Centro 1 Vendedor estrella") {
       it("El vendedor estrella es el vendedorfijo2") {
           centroDeDistribucionSa1.vendedorEstrella().shouldBe(vendedorFijo2)
       }
       // Saco al vendedorFijo2
       centroDeDistribucionSa1.sacarVendedor(vendedorFijo2)

       it ("Saco 1 Vendedor, vendedor estrella viajante1") {
           centroDeDistribucionSa1.vendedorEstrella().shouldBe(viajante1)
       }
   }
})