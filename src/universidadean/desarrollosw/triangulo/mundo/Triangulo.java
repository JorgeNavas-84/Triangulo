/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudio: Desarrollo de Software
 * Ejercicio: Triangulo
 * Fecha: Agosto 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.triangulo.mundo;

import static java.lang.Math.*;

/**
 * Clase que representa un triángulo.
 */
public class Triangulo {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Primer punto del triángulo.
     */
    private final Punto punto1;

    /**
     * Segundo punto del triángulo.
     */
    private final Punto punto2;

    /**
     * Tercer punto del triángulo.
     */
    private final Punto punto3;

    /**
     * Color de las líneas.
     */
    private final Color colorLineas;

    /**
     * Color del relleno.
     */
    private final Color colorRelleno;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el triángulo
     */
    public Triangulo() {
        // Inicializa los puntos

        punto1 = new Punto(200, 50);
        punto2 = new Punto(300, 200);
        punto3 = new Punto(100, 200);

        // Inicializa los colores
        colorRelleno = new Color(60, 168, 56);
        colorLineas = new Color(0, 83, 24);
    }

    /**
     * Retorna el punto 1 del triángulo.
     */
    public Punto darPunto1() {
        return punto1;
    }

    /**
     * Retorna el punto 2 del triángulo.
     */
    public Punto darPunto2() {
        return punto2;
    }

    /**
     * Retorna el punto 3 del triángulo.
     */
    public Punto darPunto3() {
        return punto3;
    }

    /**
     * Retorna el color de las líneas del triángulo.
     */
    public Color darColorLineas() {
        return colorLineas;
    }

    /**
     * Retorna el color del relleno del triángulo.
     */
    public Color darColorRelleno() {
        return colorRelleno;
    }

    /**
     * Retorna el perímetro del triángulo.
     */
    public double darPerimetro() {
        //Retorna la suma de todos los lados
        double a = calcularLado1(); //Le asigna al lado "a" el valor que calculamos a la distancia del lado1
        double b = calcularLado2(); //Le asigna al lado "b" el valor que calculamos a la distancia del lado2
        double c = calcularLado3(); //Le asigna al lado "c" el valor que calculamos a la distancia del lado3

        return a + b + c;
    }

    /**
     * Retorna el área del triángulo, calculada utilizando la formula de Herón. <br>
     */
    public double darArea() {
        // Utilizando formula de Herón
        double a = calcularLado1(); //Le asigna al lado "a" el valor que calculamos a la distancia del lado1
        double b = calcularLado2(); //Le asigna al lado "b" el valor que calculamos a la distancia del lado2
        double c = calcularLado3(); //Le asigna al lado "c" el valor que calculamos a la distancia del lado3
        double s = ((a+b+c)/2); //semiperimetro de la formula
        double area = sqrt(s*(s-a)*(s-b)*(s-c)); // formula de heron
        return area;
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2. <br>
     * Tenga en cuenta que Área = (Base * Altura) / 2.
     */
    public double darAltura() {
        // Obteine y retorna la altura del triángulo
        double area = darArea(); //El area calculada del metodo de heron
        double base = calcularLado2(); //base del angulo calculada del punto 2 y punto 3
        return (area*2) /base ;
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     */
    private double calcularLado1() {
        // calcula la distancia
        double x1 = punto1.darX(); //Esta es la x del punto 1
        double y1 = punto1.darY(); //Esta es la y del punto 1
        double x2 = punto2.darX(); //Esta es la x del punto 2
        double y2 = punto2.darY(); //Esta es la y del punto 2

        double distancia = Math.sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     */
    private double calcularLado2() {
        double x1 = punto2.darX(); //Esta es la x del punto 2
        double y1 = punto2.darY(); //Esta es la y del punto 2
        double x2 = punto3.darX(); //Esta es la x del punto 3
        double y2 = punto3.darY(); //Esta es la y del punto 3

        double distancia = Math.sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     */
    private double calcularLado3() {
        double x1 = punto3.darX(); //Esta es la x del punto 3
        double y1 = punto3.darY(); //Esta es la y del punto 3
        double x2 = punto1.darX(); //Esta es la x del punto 1
        double y2 = punto1.darY(); //Esta es la y del punto 1

        double distancia = Math.sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
        return distancia;
    }

    /**
     * Calcula el ángulo opuesto entre un vértice de referencia y los otros dos vértices de un triángulo.
     */
    public double calcularAnguloOpuesto(double pX1, double pY1, double pX2, double pY2, double pX3, double pY3) {
        // Ángulo 1
        double angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1);

        // Ángulo 2
        double angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1);

        // Garantiza que la diferencias de ángulos sea la más pequeña.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = angulo1 < 0 ? angulo1 + 2.d * Math.PI : angulo1;
            angulo2 = angulo2 < 0 ? angulo2 + 2.d * Math.PI : angulo2;
        }

        // Calcula el ángulo opuesto
        double anguloOpuesto = (angulo1 + angulo2) / 2.d + Math.PI;
        anguloOpuesto = anguloOpuesto % (2.d * Math.PI);
        return anguloOpuesto;
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     */
    public void cambiarPunto1(double pX, double pY) {
        punto1.cambiarX(pX);
        punto1.cambiarY(pY);
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     */
    public void cambiarPunto2(double pX, double pY) {
        punto2.cambiarX(pX);
        punto2.cambiarY(pY);
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     */
    public void cambiarPunto3(double pX, double pY) {
        punto3.cambiarX(pX);
        punto3.cambiarY(pY);
    }

    /**
     * Cambia el color de relleno del triángulo.
     */
    public void cambiarColorRelleno(int pRojo, int pVerde, int pAzul) {
        colorRelleno.cambiarRojo(pRojo);
        colorRelleno.cambiarVerde(pVerde);
        colorRelleno.cambiarAzul(pAzul);
    }

    /**
     * Cambia el color de la líneas del triángulo.
     */
    public void cambiarColorLineas(int pRojo, int pVerde, int pAzul) {
        // Realiza el cambio de los colores
        colorLineas.cambiarRojo(pRojo);
        colorLineas.cambiarVerde(pVerde);
        colorLineas.cambiarAzul(pAzul);
    }

    /**
     * Obtener el tipo de triángulo. Este puede ser:
     * - equilatero: los tres lados iguales
     * - isosceles: solo dos lados iguales
     * - escaleno: todos los lados diferentes.
     */
    public String tipo() {
        // Obtiene el tipo de triangulo
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();
        String tipotriangulo = "Escaleno";
        if (lado1==lado2 && lado2==lado3 && lado1==lado3 )
            tipotriangulo = "Equilatero";
        else{
            if ( lado1==lado2 || lado1==lado3 || lado2==lado3 )
                tipotriangulo = "Isoceles";

        }
        return tipotriangulo;
    }

    /**
     * Obtener el ángulo (en radianes) entre el lado 1 y el lado 2.
     * Use la ley del coseno para tal fin
     */
    public double angulo1() {
        // Obtiene y retorna el ángulo entre los lado 1 (entre P1 y P2) y lado 2 (entre P2 y P3)
        double a = calcularLado1(); // lado 1
        double b = calcularLado2(); // lado 2
        double c = calcularLado3(); // lado 3
        double angulo = acos((pow(a,2)+pow(b,2)-pow(c,2))/(2*a*b)); //teorema del coseno para el angulo
        return angulo;
    }

    /**
     * Obtener el ángulo (en radianes) entre el lado 2 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo2() {
        // Obtiene y retorna el ángulo entre los lado 2 (entre P2 y P3) y lado 3 (entre P3 y P1)
        double a = calcularLado1(); // lado 1
        double b = calcularLado2(); // lado 2
        double c = calcularLado3(); // lado 3
        double angulo = acos((pow(b,2)+pow(c,2)-pow(a,2))/(2*b*c)); //teorema del coseno para el angulo
        return angulo;
    }

    /**
     * Obtener el ángulo (en radianes) entre el lado 1 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo3() {
        // Obtiene y retorna el ángulo entre los lado 1 (entre P1 y P2) y lado 3 (entre P3 y P1)
        double a = calcularLado1(); // lado 1
        double b = calcularLado2(); // lado 2
        double c = calcularLado3(); // lado 3
        double angulo = acos((pow(a,2)+pow(c,2)-pow(b,2))/(2*a*c)); //teorema del coseno para el angulo
        return angulo;
    }

}
