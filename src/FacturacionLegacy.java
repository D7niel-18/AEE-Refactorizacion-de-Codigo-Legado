/**
 * Clase Legacy del sistema de facturación.
 * ADVERTENCIA: Código con alta deuda técnica. No modificar la firma del método.
 */
public class FacturacionLegacy {
/**
* Calcula el importe total a pagar por un cliente, aplicando descuentos según su categoría y si es socio VIP.
/ Parámetros:
    * - importeBase: el importe inicial de la factura.
    * - tipoCliente: 1 para VIP, 2 para Estándar, cualquier otro valor para Sin categoría.
    * - esSocioVip: true si el client es socio VIP, false en caso contrario.
    * Reglas de negocio:
    * - Clientes VIP con descuento extra (tipoCliente = 1 y esSocioVip = true): 25% de descuento.
    * - Clientes VIP sin descuento extra (tipoCliente = 1 y esSocioVip = false): 15% de descuento.
    * Clientes Estándar (tipoCliente = 2): 5% de descuento, independientemente de esSocioVip.
    * Clientes sin categoría conocida (cualquier otro valor de tipoCliente): 0% de descuento.
    * - El método debe retornar 0 si el importeBase es negativo o cero.
    * - El resultado final se calcula aplicando el descuento correspondiente al importeBase.
    * - El método debe ser refactorizado para mejorar su legibilidad y mantenibilidad, sin modificar su comportamiento externo ni la firma del método.
    * - Ejemplo de uso:
    *  FacturacionLegacy facturacion = new FacturacionLegacy();
    * double total = facturacion.calcularTotal(100.0, 1, true); // Debería retornar 75.0
    *  FacturacionLegacy facturacion = new FacturacionLegacy();
    * double total = facturacion.calcularTotal(100.0, 1, false); // Debería retornar 85.0
    * FacturacionLegacy facturacion = new FacturacionLegacy();
    * double total = facturacion.calcularTotal(100.0, 2, true
    * // Debería retornar 95.0
    * FacturacionLegacy facturacion = new FacturacionLegacy();
    * double total = facturacion.calcularTotal(100.0, 3, false); // Debería retornar 100.0
    * FacturacionLegacy facturacion = new FacturacionLegacy();
    * double total = facturacion.calcularTotal(-50.0, 1, true); // Debería retornar 0.0
    * FacturacionLegacy facturacion = new FacturacionLegacy();
    * double total = facturacion.calcularTotal(0.0, 2, false); // Debería retornar 0.0
    * Nota: El código original del método se encuentra comentado al final del método para referencia durante la refactorización.
*/
    // Método a refactorizar
    public double calcularTotal(double importeBase, int tipoCliente, boolean esSocioVip) {
        // Entorno:
        final float IVA = 0.25f;
        final float DESCUENTO = 0.15f;
        final float DESCUENTOEXTRA = 0.05f;
        
        // Algoritmo:
        if (importeBase > 0){
            switch (tipoCliente) {
                case 1:
                    if (esSocioVip == true)
                        return importeBase - (importeBase * IVA);
                    else
                        return importeBase - (importeBase * DESCUENTO);
                case 2:
                    return importeBase - (importeBase * DESCUENTOEXTRA);
                default:
                    return importeBase - (importeBase * 0);
            }
        } else {
            return 0;
        }
        /*if (importeBase > 0) {
            if (tipoCliente == 1) {
                if (esSocioVip == true)
                    return importeBase - (importeBase * IVA);
                else
                    return importeBase - (importeBase * DESCUENTO);
            } else {
                if (tipoCliente == 2) {
                    return importeBase - (importeBase * DESCUENTOEXTRA);
                } else {
                    return importeBase - (importeBase * 0);
                }
            }
        } else {
            return 0;
        } */
    }
}