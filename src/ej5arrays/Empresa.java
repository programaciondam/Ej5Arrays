/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5arrays;

import fechas.Fecha;
import numeros.Numero;
import textos.Textos;

/**
 *
 * @author dam
 */
public class Empresa {

    Cliente[] clientes;
    Descuento[] descuentos;

    public Empresa(int nClientes) {
        clientes = new Cliente[nClientes];
        descuentos = new Descuento[]{
            new Descuento(30, 0.1f),
            new Descuento(90, 0.07f),
            new Descuento(120, 0.05f),
            new Descuento(180, 0.02f),
            new Descuento(Integer.MAX_VALUE, 0f)
        };
    }

    public void pedirClientes() {
        String nombre, cif;
        int dven;
        Fecha fecha;
        Float importe;
        for (int ncliente = 0; ncliente < clientes.length; ncliente++) {

            cif = Textos.pedirString("CIF");
            nombre = Textos.pedirString("NOMBRE");
            dven = Numero.pedirNumero("DIAS VENCIMIENTO", 0);
            fecha = Textos.pedirFecha("Fecha");
            importe = Numero.pedirNumeroReal("IMPORTE FACTURA", 0);
            clientes[ncliente] = new Cliente(cif, nombre, fecha, dven, importe);

        }

    }

    public void informe() {
        Fecha fhoy = new Fecha();
        float descuento;
        float importeNeto;
        int pos;
        System.out.println("\t\t\t\tINFORME DE FACTURAS");
        System.out.println("Fecha:" + fhoy.fechaCompletaLetra());
        System.out.println("CIF \t NOMBRE\t FECHA FACTURA\t"
                + " IMPORTE BRUTO \t FECHA VENCIMIENTO\t IMPORTE NETO");
        for (int ncli = 0; ncli < clientes.length; ncli++) {
            pos = busqueda(clientes[ncli].getDiasVen());
            if (pos == -1) {
                descuento = 0;
            } else {
                descuento = clientes[ncli].getImporte()
                        * descuentos[pos].getDescuento();
            }
            importeNeto=clientes[ncli].getImporte()-descuento;
            Fecha vencimiento = new Fecha(
                    clientes[ncli].getFechaFra().getDia(),
                    clientes[ncli].getFechaFra().getMes(),
                    clientes[ncli].getFechaFra().getAnno());

            vencimiento.calcularVencimiento(clientes[ncli].getDiasVen());

            System.out.print(clientes[ncli].getCif());
            System.out.print("\t" + clientes[ncli].getNombre());
            System.out.print("\t"
                    + clientes[ncli].getFechaFra().fechaCompleta());

            System.out.print("\t" + clientes[ncli].getImporte());
            System.out.print("\t\t" + vencimiento.fechaCompleta());
            System.out.println("\t"+ importeNeto);

        }
    }

    /**
     * Método de búsqueda
     *
     * @param valor Del elemento a buscar
     * @return posicion del valor encontrado y -1 en el caso de que no lo
     * encuentre
     */
    public int busqueda(int valor) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < descuentos.length) {
            if (valor > descuentos[pos].getLimite()) {
                pos++;
            } else {
                encontrado = true;
            }
        }
        if (!encontrado) {
            pos = -1;
        }
        return pos;
    }

}
