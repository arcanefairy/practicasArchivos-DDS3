package Matrices;
import java.io.*;


public class PracticaAr {

    public static void main(String[] args) throws InterruptedException {
        String archivoA = "a.mat";
        String archivoB = "b.mat";
        String archivoC = "c.mat";

        try {
        DataInputStream ArchivoA = new DataInputStream(new FileInputStream(archivoA));
        DataInputStream ArchivoB = new DataInputStream(new FileInputStream(archivoB));

            int filasA = ArchivoA.read();
            int columnasA = ArchivoA.read();
            int filasB = ArchivoB.read();
            int columnasB = ArchivoB.read();

        if (columnasA != filasB) {
        System.out.println("No se puede multiplicar las matrices debido a dimensiones incorrectas.");
        return;
        }

        double[][] matrizA = new double[filasA][columnasA];
        double[][] matrizB = new double[filasB][columnasB];

            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasA; j++) {
            matrizA[i][j] = ArchivoA.readDouble();
            }
        }

            for (int i = 0; i < filasB; i++) {
                 for (int j = 0; j < columnasB; j++) {
            matrizB[i][j] = ArchivoB.readDouble();
             }
         }

            ArchivoA.close();
            ArchivoB.close();

    // Realizar la multiplicación de matrices
        double[][] resultadoMatriz = new double[filasA][columnasB];
            for (int i = 0; i < filasA; i++) {
               for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                resultadoMatriz[i][j] += matrizA[i][k] * matrizB[k][j];
            }
        }
    }

    DataOutputStream ArchivoC = new DataOutputStream(new FileOutputStream(archivoC));
    ArchivoC.write(filasA);
    ArchivoC.write(columnasB);

    for (int i = 0; i < filasA; i++) {
        for (int j = 0; j < columnasB; j++) {
            ArchivoC.writeDouble(resultadoMatriz[i][j]);
        }
    }

    ArchivoC.close();

    System.out.println("El resultado se ha guardado en c.mat.");

        } catch (IOException e) {
            e.printStackTrace();
            }
    
    }
    
}
