package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class pruebas {

	public static void main(String[] args) {
		try {
            // URL de la API que quieres consumir
            String apiUrl = "http://localhost:8080/api/usuarios/get";

            // Crear la conexión
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar el método de solicitud (GET en este caso)
            connection.setRequestMethod("GET");

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String linea;
                StringBuilder respuesta = new StringBuilder();

                while ((linea = reader.readLine()) != null) {
                    respuesta.append(linea);
                }
                reader.close();

                // Aquí puedes procesar la respuesta (almacenarla, analizarla, etc.)
                System.out.println("Respuesta de la API: " + respuesta.toString());
            } else {
                System.out.println("Error al hacer la solicitud. Código de respuesta: " + responseCode);
            }

            // Cerrar la conexión
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
