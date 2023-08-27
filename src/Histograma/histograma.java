package Histograma;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class histograma {

   
    public static void main(String[] args) {
    String archivo = "C:/Users/Hp/Downloads/divina_comedia_sp.txt";
    HashMap<Integer, Integer> histograma = new HashMap<>();

        try {
            BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
            String linea;
            
            while ((linea = leerArchivo.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                
                for (String palabra : palabras) {
                    palabra = palabra.replaceAll("[^a-zA-Z]", ""); // Eliminar caracteres no alfabéticos
                    int longitudPalabra = palabra.length();
                    
                    if (longitudPalabra >= 2 && longitudPalabra <= 10) {
                        histograma.put(longitudPalabra, histograma.getOrDefault(longitudPalabra, 0) + 1);
                    }
                }
            }
            
            leerArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir histograma
        for (int largo = 2; largo <= 10; largo++) {
            int contador = histograma.getOrDefault(largo, 0);
            System.out.println("Palabras de " + largo + " letras: " + contador);
        }
    }
    
}
