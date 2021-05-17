import java.io.*;
import java.util.ArrayList;

public class Lector {

    /**
     * Constructor vacio
     */
    public Lector() {}

    /**
     * @return devuelve la linea escrita en el txt 
     */
    public ArrayList<Paciente> readFile(String file_path) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Paciente> salida = new ArrayList<>();

        try {
            
            archivo = new File(file_path);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
               String[] atributos = linea.split(", ");
               salida.add(new Paciente(atributos[0], atributos[1], atributos[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return salida;
    }

}