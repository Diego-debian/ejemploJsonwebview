package unal.todosalau.apiwebcomunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MainActivity extends AppCompatActivity {
    private TextView nombreTextView;
    private TextView edadTextView;
    private TextView direccionTextView;
    private TextView telefonosTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener las vistas de texto
        nombreTextView = findViewById(R.id.nombreTextView);
        edadTextView = findViewById(R.id.edadTextView);
        direccionTextView = findViewById(R.id.direccionTextView);
        telefonosTextView = findViewById(R.id.telefonosTextView);

        // Simular la respuesta JSON recibida desde la API web
        String respuestaJSON = "{\n" +
                "  \"nombre\": \"Juan\",\n" +
                "  \"edad\": 35,\n" +
                "  \"direccion\": {\n" +
                "	\"calle\": \"Calle 10\",\n" +
                "	\"numero\": 123,\n" +
                "	\"ciudad\": \"Bogotá\"\n" +
                "  },\n" +
                "  \"telefonos\": [\"12345678\", \"98765432\"]\n" +
                "}";

        // Procesar la respuesta JSON con la biblioteca Gson
        Gson gson = new Gson();
        try {
            Usuario usuario = gson.fromJson(respuestaJSON, Usuario.class);

            // Actualizar las vistas de texto con la información del usuario
            nombreTextView.setText(usuario.getNombre());
            edadTextView.setText(Integer.toString(usuario.getEdad()));
            direccionTextView.setText(usuario.getDireccion().toString());
            telefonosTextView.setText(usuario.getTelefonos().toString());
        } catch (JsonSyntaxException e) {
            // Manejar errores de sintaxis JSON
            e.printStackTrace();
        }
    }
}
