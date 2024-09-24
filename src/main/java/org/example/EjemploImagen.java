package org.example;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;

public class EjemploImagen extends JPanel {
    private BufferedImage imagen;

    public EjemploImagen() {
        try {
            // Verificar la existencia del archivo antes de cargar
            File archivoImagen = new File("C:\\Users\\darkr\\OneDrive\\Escritorio\\Imagen ejemplo\\descarga.jpg");
            if (!archivoImagen.exists()) {
                System.out.println("El archivo de la imagen no existe: " + archivoImagen.getAbsolutePath());
            } else {
                // Cargar la imagen desde el archivo
                imagen = ImageIO.read(archivoImagen);
                System.out.println("Imagen cargada correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    // Metodo para mostrar la imagen en el panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, this); // Dibujar la imagen en el panel
        }
    }

    // Metodo principal
    public static void main(String[] args) {
        // Crear una ventana para mostrar la imagen
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 500);  // Establecer el tamaño de la ventana

        // Agregar el panel que mostrará la imagen
        EjemploImagen panel = new EjemploImagen();
        ventana.add(panel);
        ventana.setVisible(true);

        // Guardar la imagen en otro formato
        try {
            BufferedImage imagenCargada = ImageIO.read(new File("C:\\Users\\darkr\\OneDrive\\Escritorio\\Imagen ejemplo\\descarga.jpg"));

            File archivoSalida = new File("C:\\Users\\darkr\\OneDrive\\Escritorio\\nueva_imagen.jpg");
            ImageIO.write(imagenCargada, "jpg", archivoSalida);  // Guardar la imagen como JPG
            System.out.println("Imagen guardada correctamente como JPG.");
        } catch (IOException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }
    }
}