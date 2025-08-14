package oliver;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.Year;
import java.util.List;
import java.util.Map;

@Path("/menu")
public class menu {

    @Inject
    Template menu;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getMenu() {
        // Datos temporales sacados del PDF (luego pueden ir en BD)
        List<Map<String, Object>> aguachiles = List.of(
            Map.of("nombre", "Bandera Negra", "descripcion", "Chile chiltepin tatemado, salsas negras, limón, cebolla morada, pepino y aguacate", "precio", 199),
            Map.of("nombre", "Bandera Roja", "descripcion", "Chile chiltepin molcajeteado y limón, cebolla morada, pepino y aguacate", "precio", 199)
        );

        List<Map<String, Object>> tacos = List.of(
            Map.of("nombre", "Contramaestre", "descripcion", "Tortilla de maíz, camarón capeado, pico de gallo y repollo", "precio", 59),
            Map.of("nombre", "Capitán", "descripcion", "Tortilla de maíz, pescado capeado, pico de gallo y repollo", "precio", 49)
        );

        List<Map<String, Object>> botanas = List.of(
            Map.of("nombre", "Sables de papa", "descripcion", "200gr de papas gajo sazonadas", "precio", 69),
            Map.of("nombre", "Balas de pollo", "descripcion", "6 piezas de boneless Buffalo o BBQ", "precio", 99)
        );

        List<Map<String, Object>> bebidas = List.of(
            Map.of("nombre", "Refresco", "precio", 35),
            Map.of("nombre", "Jugo Jumex", "precio", 35)
        );

        return menu.data("titulo", "Menú Bandera Negra")
                   .data("year", Year.now().getValue())
                   .data("aguachiles", aguachiles)
                   .data("tacos", tacos)
                   .data("botanas", botanas)
                   .data("bebidas", bebidas);
    }
}
