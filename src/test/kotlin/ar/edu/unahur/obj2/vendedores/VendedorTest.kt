package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)
  //Creamos Mas Ciudades
  val buenosAires = Provincia (17000000 )
  val moronCity = Ciudad (buenosAires)

  val laPampa = Provincia ( 9050000)
  val santaRosa = Ciudad (laPampa)

  val cordoba = Provincia(2000000)
  val villaDolores = Ciudad(cordoba)

  val entreRios = Provincia (150000)
  val villaParanacito = Ciudad (entreRios)
  // Estas las hago para pruevas.
  val villaNomepregunten = Ciudad (entreRios)
  val villaCalamuchita = Ciudad (misiones)
  val villaTekeneje = Ciudad (misiones)
  val villaPacake = Ciudad (misiones)

  // Creamos Certificaciones
  val certificacion1 = Certificacion(true,10)
  val certificacion2 = Certificacion(false,200)
  val certificacion3 = Certificacion(true,10)
  val certificacion4 = Certificacion(true,30)

  // Vendedor Fijo

  describe("Vendedor fijo") {

    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)
    // Agregamos certificaciones
    vendedorFijo.agregarCertificacion(certificacion1)
    vendedorFijo.agregarCertificacion(certificacion2)
    vendedorFijo.agregarCertificacion(certificacion3)

    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
    }
    // Prueva si es versatil
    describe ("esVersatil Y esFirme Vendedor Fijo") {
      it ( "Si es Versatil Y esFirme ") {
        vendedorFijo.esVersatil().shouldBeTrue()
        vendedorFijo.esFirme().shouldBeTrue()
      }
      // Le saco una certificacion y agrege la funcion sacar certificacion(oviamente).
      vendedorFijo.sacarCertificaciones(certificacion2)
      it ("No es Versatil Y No esFirme porque le saque una certificacion") {
        vendedorFijo.esVersatil().shouldBeFalse()
        vendedorFijo.esFirme().shouldBeFalse()
      }
      //Este lo dejo comentado por si queiren provar que despues de sacar una certificacion deja de ser versatil
      //it ( "es Versatil tendria que dar error ") {
      // vendedorFijo.esVersatil().shouldBeTrue()
      //}
    }
    //Es Influyente
    describe("Es influyente"){
      it ("No es influyente") {
        vendedorFijo.esInfluyente().shouldBeFalse()
      }
    }
  }
  // Vendedor Viajante

  describe("Viajante") {

    val viajante = Viajante(listOf(misiones))

    viajante.agregarCertificacion(certificacion1)
    viajante.agregarCertificacion(certificacion2)
    viajante.agregarCertificacion(certificacion3)

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
    }
      // Prueva si es versatil
      describe ("esVersatil Y esFirme Vendedor viajante") {
        it ( "Si es Versatil Y esFirme ") {
          viajante.esVersatil().shouldBeTrue()
          viajante.esFirme().shouldBeTrue()
        }
        // Le saco una certificacion y agrege la funcion sacar certificacion(oviamente).
        viajante.sacarCertificaciones(certificacion2)
        it ("No es Versatil y No es Firme porque le saque una certificacion") {
          viajante.esVersatil().shouldBeFalse()
          viajante.esFirme().shouldBeFalse()
        }
        //Este lo dejo comentado por si queiren provar que despues de sacar una certificacion deja de ser versatil
        //it ( "es Versatil tendria que dar error ") {
        // viajante.esVersatil().shouldBeTrue()
        //}
    }
    //Es Influyente
    describe("Es influyente Viajante1") {
      it("No es influyente") {
        viajante.esInfluyente().shouldBeFalse()
      }
    }

      describe("Viajante2 Influyente") {
        // Creo otro viajante con una lista de provincias habilitadas diferentes para el "Si es influyente
        val viajante2 = Viajante(listOf(laPampa,misiones))

        it("Si Es influyente"){
          viajante2.esInfluyente().shouldBeTrue()
        }
      }

  }

  // Comercio corresponsal

  describe( "ComercioCorresponsal ") {

    val comercioCorresponsal = ComercioCorresponsal()
    val comercioCorresponsal2 = ComercioCorresponsal()

    //Agrego ciudades al comercioCorresponsal 1
    comercioCorresponsal.agregarCiudades(sanIgnacio)
    comercioCorresponsal.agregarCiudades(moronCity)
    comercioCorresponsal.agregarCiudades(villaDolores)
    comercioCorresponsal.agregarCiudades(villaCalamuchita)
    //Agrego certificaciones
    comercioCorresponsal.agregarCertificacion(certificacion1)
    comercioCorresponsal.agregarCertificacion(certificacion2)
    comercioCorresponsal.agregarCertificacion(certificacion3)

    //Puede trabajar en
    describe("puedeTrabajarEn ") {
      it("Si puede trabajar en") {
        comercioCorresponsal.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
        comercioCorresponsal.puedeTrabajarEn(moronCity).shouldBeTrue()
      }
      it("No puede trabajar en") {
        comercioCorresponsal.puedeTrabajarEn(santaRosa).shouldBeFalse()
      }
    }
    //Es versatil y es Firme
    describe("Es Versatil Y Es Firme ") {
      it("Si es versatil Y Es Firme") {
        comercioCorresponsal.esVersatil().shouldBeTrue()
        comercioCorresponsal.esFirme().shouldBeTrue()
      }

      // No es Versatil y No es Firme
      // Le saco una certificacion y agrege la funcion sacar certificacion(oviamente).
      comercioCorresponsal.sacarCertificaciones(certificacion2)

      it("No es Versatil y no Es Firme porque le saque una certificacion") {
        comercioCorresponsal.esVersatil().shouldBeFalse()
        comercioCorresponsal.esFirme().shouldBeFalse()
      }
    }
    describe("Vendedor Ingluyente comercioCorresponsal1") {
      it("Si esInfluyente: Tiene 4 Ciudades de 3 diferentes provincias") {
        comercioCorresponsal.esInfluyente().shouldBeTrue()
      }
      // Le saco una ciudad y tiene que dar que no es influyente
      comercioCorresponsal.sacarCiudades(villaDolores)
      it("No esInfluyente: Tiene 3 ciudades de 2 diferentes provincias") {
        comercioCorresponsal.esInfluyente().shouldBeFalse()
      }

      // Utilizo comercioCorresponsal2. Agrego ciudades hasta tener 5 de tan solo dos provincias diferentes.
      comercioCorresponsal2.agregarCiudades(villaCalamuchita)
      comercioCorresponsal2.agregarCiudades(villaNomepregunten)
      comercioCorresponsal2.agregarCiudades(villaTekeneje)
      comercioCorresponsal2.agregarCiudades(sanIgnacio)
      comercioCorresponsal2.agregarCiudades(villaParanacito)
      describe("Vendedor Influyente comercioCorresponsal2 ") {
        it("Si esInfluyente: tiene 5 ciudades de 2 dif. provincias") {
          comercioCorresponsal2.esInfluyente().shouldBeTrue()
        }

        comercioCorresponsal2.sacarCiudades(villaParanacito)
        comercioCorresponsal2.sacarCiudades(villaNomepregunten)
        comercioCorresponsal2.agregarCiudades(villaPacake)
        it("No esInfluyente: tiene 4 ciudades de 2 dif. provincias") {
          comercioCorresponsal2.esInfluyente().shouldBeFalse()
        }
      }
    }
  }
})
