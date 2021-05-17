import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Vista {

    public Vista() {
    }

    public void start() {
        Lector lector = new Lector();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes = lector.readFile("assets/pacientes.txt");
        boolean validacion_opcion = false;
        Scanner sc = new Scanner(System.in);
        int version = 0;

        System.out.println("¿Qué versión de árbol quieres usar?");

        while (!validacion_opcion) {
            System.out.println("1. Vector Heap\n2. Priority Queue (JCF):");
            try {
                version = Integer.parseInt(sc.next());
                if (version == 1 || version == 2)
                    validacion_opcion = true;
                else
                    System.out.println("Ingrese una opción válida\n");
            } catch (Exception e) {
                System.out.println("Ingrese una opción válida\n");
            }
        }

        if(version == 1) {
            vectorHeap(pacientes);
        } else {
            javaCollectionFramework(pacientes);
        }
    }

    private void javaCollectionFramework(ArrayList<Paciente> pacientes) {
        PriorityQueue<Paciente> pacientes_ordenados = new PriorityQueue<>();
        pacientes.forEach(paciente -> {
            pacientes_ordenados.add(paciente);
        });
        boolean validacion_pacientes = !pacientes_ordenados.isEmpty();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido doctor, estos son los pacientes a atender hoy: ");

        while (validacion_pacientes) {
            boolean validacion_opcion = false;
            Paciente paciente_actual = pacientes_ordenados.remove();
            System.out.println("El paciente a atender es: " + paciente_actual.getNombre() + " con el diagnostico de: '"
                    + paciente_actual.getEnfermedad() + "' con prioridad: '" + paciente_actual.getPrioridad() + "'");
            String option = "";
            while (!validacion_opcion) {
                System.out.println("¿Mostrar siguiente paciente?: Y/N");
                try {
                    option = sc.next();
                    if (option.equals("Y") || option.equals("N") || option.equals("y") || option.equals("n"))
                        validacion_opcion = true;
                    else
                        System.out.println("Ingrese una opción válida\n");
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida\n");
                }
            }
            if (option.equals("N") || option.equals("n")) {
                System.out.println("Gracias por usar el sistema.");
                break;
            }
            validacion_pacientes = !pacientes_ordenados.isEmpty();
        }

        if (!validacion_pacientes) {
            System.out.println("Ya no existen pacientes por atender hoy, buen día.");
        }
    }

    private void vectorHeap(ArrayList<Paciente> pacientes) {
        VectorHeap<Paciente> pacientes_ordenados = new VectorHeap<>();
        pacientes.forEach(paciente -> {
            pacientes_ordenados.add(paciente);
        });

        boolean validacion_pacientes = !pacientes_ordenados.isEmpty();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido doctor, estos son los pacientes a atender hoy: ");

        while (validacion_pacientes) {
            boolean validacion_opcion = false;
            Paciente paciente_actual = pacientes_ordenados.remove();
            System.out.println("El paciente a atender es: " + paciente_actual.getNombre() + " con el diagnostico de: '"
                    + paciente_actual.getEnfermedad() + "' con prioridad: '" + paciente_actual.getPrioridad() + "'");
            String option = "";
            while (!validacion_opcion) {
                System.out.println("¿Mostrar siguiente paciente?: Y/N");
                try {
                    option = sc.next();
                    if (option.equals("Y") || option.equals("N") || option.equals("y") || option.equals("n"))
                        validacion_opcion = true;
                    else
                        System.out.println("Ingrese una opción válida\n");
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida\n");
                }
            }
            if (option.equals("N") || option.equals("n")) {
                System.out.println("Gracias por usar el sistema.");
                break;
            }
            validacion_pacientes = !pacientes_ordenados.isEmpty();
        }

        if (!validacion_pacientes) {
            System.out.println("Ya no existen pacientes por atender hoy, buen día.");
        }
    }

}
