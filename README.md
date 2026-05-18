- **Título: AEE-Refactorizacion-de-Codigo-Legado**  
- **Profesor:** Willman Acosta Lugo  
- **Alumnos:** Daniel Jimenez Ramirez y Pepe Gil Cué

---

## Fase 1: Análisis de la Deuda Técnica

1. **Verificación inicial.** Ejecuta los tests unitarios. Todo debe salir en verde. Esto os garantiza que el código original, por muy feo que sea, funciona.

Realizado con éxito, no se encuentra ningún problema en su ejecución.

2. **Oler el código (*Code Smells*).** El Copiloto anotará en un bloc de notas los tres grandes problemas de este código:  
   * **Números mágicos.** ¿Qué significa 0.25 o 0.15? Son valores *hardcodeados* sin contexto. Si mañana el IVA o el descuento cambian, ¿dónde los buscamos?

Para el IVA crearía una constante ya que es un valor fijo y si en algún momento necesitamos modificarlo buscaremos la palabra IVA con CTRL+F e iremos donde está declarada esta variable. Para los descuentos inicializamos una variable normal de tipo float y le pondremos de nombre descuento, esto es normal ya que va variando a lo largo del programa.  

* **Variables sin significado.** Nombres como cT, m, tC o dV no aportan ninguna semántica. Nos obligan a adivinar.

Tenemos las siguientes variables:

* cT → calcularTotal (Nombre del metodo)  
* m → importeBase 
* tC → tipoCliente  
* dV → esSocioVip

* **Código Spaghetti.** La anidación de múltiples if-else crea una estructura en forma de flecha \> que hace casi imposible seguir el flujo lógico de ejecución.

Para la solución a este problema y que sea más legible hemos elegido el usar una estructura Switch la cual según la opción que elijas el programa tendrá un flujo u otro.
```
public class FacturacionLegacy {

    // Método a refactorizar
    public double calcularTotal(double importeBase, int tipoCliente, boolean esSocioVip) {
        // Entorno:
        /* tipoCliente esSocioVip importeBase */
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
```
