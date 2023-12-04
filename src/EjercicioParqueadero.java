import java.util.Scanner;
import java.util.ArrayList;

public class EjercicioParqueadero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarCarro(scanner, parqueadero);
                    break;
                case 2:
                    darSalidaCarro(scanner, parqueadero);
                    break;
                case 3:
                    informarIngresos(parqueadero);
                    break;
                case 4:
                    consultarPuestosDisponibles(parqueadero);
                    break;
                case 5:
                    avanzarReloj(parqueadero);
                    break;
                case 6:
                    cambiarTarifa(scanner, parqueadero);
                    break;
                case 7:
                    mostrarTiempoPromedio(parqueadero);
                    break;
                case 8:
                    mostrarCarroMasDeOchoHoras(parqueadero);
                    break;
                case 9:
                    mostrarCarrosMasDeTresHoras(parqueadero);
                    break;
                case 10:
                    mostrarHayCarrosPlacaIgual(parqueadero);
                    break;
                case 11:
                    mostrarContarCarrosPlacaPB(parqueadero);
                    break;
                case 12:
                    mostrarHayCarroCon24Horas(parqueadero);
                    break;
                case 13:
                    mostrarMetodo1(parqueadero);
                    break;
                case 14:
                    mostrarDesocuparParqueadero(parqueadero);
                    break;
                case 15:
                    mostrarMetodo2(parqueadero);
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("------- Menú -------");
        System.out.println("1. Ingresar un carro al parqueadero");
        System.out.println("2. Dar salida a un carro del parqueadero");
        System.out.println("3. Informar los ingresos del parqueadero");
        System.out.println("4. Consultar la cantidad de puestos disponibles");
        System.out.println("5. Avanzar el reloj del parqueadero");
        System.out.println("6. Cambiar la tarifa del parqueadero");
        System.out.println("7. Mostrar tiempo promedio de estadia");
        System.out.println("8. Mostrar que carro ha estado paqueado mas de ocho horas");
        System.out.println("9. Indicar si algun carro a estado parqueado mas de tres horas");
        System.out.println("10. Mostrar si hay carros con placas iguales");
        System.out.println("11. Mostrar los carros con la placa que incia en PB");
        System.out.println("12. Mostrar si hay carros parqueados por 24 horas");
        System.out.println("13. Mostrar el metodo 1");
        System.out.println("14. Desocupar un espacio de parqueo");
        System.out.println("15. Mostrar metodo 2");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void ingresarCarro(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del carro: ");
        String placa = scanner.next();
        int resultado = parqueadero.entrarCarro(placa);
        if (resultado == Parqueadero.NO_HAY_PUESTO) {
            System.out.println("El parqueadero está lleno.");
        } else if (resultado == Parqueadero.PARQUEADERO_CERRADO) {
            System.out.println("El parqueadero está cerrado.");
        } else if (resultado == Parqueadero.CARRO_YA_EXISTE) {
            System.out.println("Ya hay un carro con esa placa en el parqueadero.");
        } else {
            System.out.println("Carro ingresado correctamente. Parquee en el puesto: " + resultado);
        }
    }

    private static void darSalidaCarro(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del carro que va a salir: ");
        String placa = scanner.next();
        int resultado = parqueadero.sacarCarro(placa);
        if (resultado == Parqueadero.CARRO_NO_EXISTE) {
            System.out.println("El carro con esa placa no se encuentra en el parqueadero.");
        } else if (resultado == Parqueadero.PARQUEADERO_CERRADO) {
            System.out.println("El parqueadero está cerrado.");
        } else {
            System.out.println("Carro salido correctamente. Total a pagar: $" + resultado);
        }
    }

    private static void informarIngresos(Parqueadero parqueadero) {
        System.out.println("Ingresos totales del parqueadero: $" + parqueadero.darMontoCaja());
    }

    private static void consultarPuestosDisponibles(Parqueadero parqueadero) {
        int puestosDisponibles = parqueadero.calcularPuestosLibres();
        System.out.println("Puestos disponibles en el parqueadero: " + puestosDisponibles);
    }

    private static void avanzarReloj(Parqueadero parqueadero) {
        parqueadero.avanzarHora();
        System.out.println("Reloj del parqueadero avanzado. Hora actual: " + parqueadero.darHoraActual());
    }

    private static void cambiarTarifa(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la nueva tarifa del parqueadero: ");
        int nuevaTarifa = scanner.nextInt();
        parqueadero.cambiarTarifa(nuevaTarifa);
        System.out.println("Tarifa cambiada correctamente. Nueva tarifa: $" + parqueadero.darTarifa());
    }
    private static void mostrarTiempoPromedio(Parqueadero parqueadero) {
        double tiempoPromedio = parqueadero.darTiempoPromedio();
        System.out.println("Tiempo promedio de carros en el parqueadero: " + tiempoPromedio + " horas");
    }

    private static void mostrarCarroMasDeOchoHoras(Parqueadero parqueadero) {
        Carro carroMasDeOchoHoras = parqueadero.hayCarroMasDeOchoHoras();
        if (carroMasDeOchoHoras != null) {
            System.out.println("Carro que ha estado más de ocho horas: " + carroMasDeOchoHoras.darPlaca());
        } else {
            System.out.println("No hay carros que hayan estado más de ocho horas en el parqueadero.");
        }
    }

    private static void mostrarCarrosMasDeTresHoras(Parqueadero parqueadero) {
        ArrayList<Carro> carrosMasDeTresHoras = parqueadero.darCarrosMasDeTresHorasParqueados();
        if (!carrosMasDeTresHoras.isEmpty()) {
            System.out.println("Carros que han estado más de tres horas en el parqueadero:");
            for (Carro carro : carrosMasDeTresHoras) {
                System.out.println("Placa: " + carro.darPlaca());
            }
        } else {
            System.out.println("No hay carros que hayan estado más de tres horas en el parqueadero.");
        }
    }

    private static void mostrarHayCarrosPlacaIgual(Parqueadero parqueadero) {
        boolean hayCarrosPlacaIgual = parqueadero.hayCarrosPlacaIgual();
        if (hayCarrosPlacaIgual) {
            System.out.println("Hay carros parqueados con la misma placa.");
        } else {
            System.out.println("No hay carros parqueados con la misma placa.");
        }
    }

    private static void mostrarContarCarrosPlacaPB(Parqueadero parqueadero) {
        int cantidadCarrosPB = parqueadero.contarCarrosQueComienzanConPlacaPB();
        System.out.println("Cantidad de carros con placa PB: " + cantidadCarrosPB);
    }

    private static void mostrarHayCarroCon24Horas(Parqueadero parqueadero) {
        boolean hayCarroCon24Horas = parqueadero.hayCarroCon24Horas();
        if (hayCarroCon24Horas) {
            System.out.println("Hay al menos un carro que ha estado parqueado por 24 o más horas.");
        } else {
            System.out.println("No hay carros que hayan estado parqueados por 24 o más horas.");
        }
    }

    private static void mostrarMetodo1(Parqueadero parqueadero) {
        String resultadoMetodo1 = parqueadero.metodo1();
        System.out.println(resultadoMetodo1);
    }

    private static void mostrarDesocuparParqueadero(Parqueadero parqueadero) {
        int carrosSacados = parqueadero.desocuparParqueadero();
        System.out.println("Cantidad de carros sacados: " + carrosSacados);
    }

    private static void mostrarMetodo2(Parqueadero parqueadero) {
        String resultadoMetodo2 = parqueadero.metodo2();
        System.out.println(resultadoMetodo2);
    }

}

