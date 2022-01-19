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
        descuentos= new Descuento[]{
            new Descuento(30,0.1f),
        new Descuento(90,0.07f),
         new Descuento(120,0.05f),
         new Descuento(180,0.02f),
         new Descuento(Integer.MAX_VALUE,0f)
        };
    }
   public void pedirClientes(){
       String nombre,cif;
       int dven;
       Fecha fecha;
       Float importe;
       for ( int ncliente=0; ncliente<clientes.length; ncliente++)
       {
          
           cif= Textos.pedirString("CIF");
           nombre= Textos.pedirString("NOMBRE");
           dven=Numero.pedirNumero("DIAS VENCIMIENTO",0);
           fecha= Textos.pedirFecha("Fecha");
           importe=Numero.pedirNumeroReal("IMPORTE FACTURA", 0);
           clientes[ncliente]=new Cliente(cif,nombre,fecha,dven,importe);
           
       }
       
   }
   public void informe(){
       Fecha fhoy=new Fecha();
       System.out.println("\t\t\t\tINFORME DE FACTURAS");
       System.out.println("Fecha:"+ fhoy.fechaCompletaLetra());
       System.out.println("nueva linea"
               + "");
   }
   
    
}
