/**
 * Clase Legacy del sistema de facturación.
 * ADVERTENCIA: Código con alta deuda técnica. No modificar la firma del método.
 */
public class FacturacionLegacy {
    /** 
     * @param importeBase
     * @param tipoCliente
     * @param esSocioVip
     * @return double
     */
    public double calculoTotal(double importeBase, int tipoCliente, boolean esSocioVip) {
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