package restaurante.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet {

    /**
     * Función auxiliar para limpiar y formatear texto de los valores del formulario.
     * Ejemplo: "lomo_fino_mostaza" -> "Lomo Fino Mostaza"
     */
    private String formatarTexto(String texto) {
        if (texto == null || texto.isEmpty() || texto.equals("null")) {
            return "No especificado";
        }
        // Reemplaza guiones bajos por espacios y pone en mayúscula la primera letra
        String formatted = texto.replace("_", " ");
        if (formatted.length() > 0) {
            formatted = formatted.substring(0, 1).toUpperCase() + formatted.substring(1);
        }
        return formatted;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configurar la respuesta
        response.setContentType("text/html;charset=UTF-8");

        // 1. Recuperar Parámetros
        String entrada = request.getParameter("entrada");
        String platoFuerte = request.getParameter("plato_fuerte");
        String postre = request.getParameter("postre");
        String tipoBebida = request.getParameter("tipo_bebida");

        // 2. Recuperar Parámetros Condicionales
        String saborHelado = request.getParameter("sabor_helado");
        String jugoFruta = request.getParameter("jugo_fruta");
        String jugoBase = request.getParameter("jugo_base");

        // 3. Generar la Respuesta HTML Detallada
        try (java.io.PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"es\">");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <title>Confirmación de Pedido - El Fogón del Chef</title>");
            // Usamos la misma hoja de estilo
            out.println("    <link rel=\"stylesheet\" href=\"CSS/estilo.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("    <header>");
            out.println("        <h1>¡Pedido Recibido en El Fogón del Chef! 🔥</h1>");
            out.println("        <p>Su solicitud de menú de lujo ha sido enviada a cocina.</p>");
            out.println("    </header>");

            out.println("    <div class=\"pedido-form\">");
            out.println("        <h2>📝 Resumen del Pedido:</h2>");
            out.println("        <ul style=\"list-style: none; padding-left: 0;\">");

            // Platos Principales
            out.println("            <li><strong>Antojito/Entrada:</strong> " + formatarTexto(entrada) + "</li>");
            out.println("            <li><strong>Plato Fuerte:</strong> " + formatarTexto(platoFuerte) + "</li>");
            out.println("            <hr style='border: 0; border-top: 1px dashed #ccc;'>");

            // Lógica Condicional de BEBIDA
            out.println("            <li><strong>Bebida:</strong> " + formatarTexto(tipoBebida));
            if ("jugo".equals(tipoBebida)) {
                String base = (jugoBase != null) ? formatarTexto(jugoBase) : "N/A";
                out.println(" (Jugo de **" + formatarTexto(jugoFruta) + "** en base de **" + base + "**)");
            }
            out.println("</li>");

            // Lógica Condicional de POSTRE
            out.println("            <li><strong>Postre:</strong> " + formatarTexto(postre));
            if ("helado".equals(postre)) {
                String sabor = (saborHelado != null && !saborHelado.isEmpty()) ? formatarTexto(saborHelado) : "Clásico";
                out.println(" (Sabor Gourmet: **" + sabor + "**)");
            }
            out.println("</li>");

            out.println("        </ul>");

            out.println("        <br><p style='text-align:center; font-style:italic; font-weight: bold;'>¡Su experiencia culinaria está por comenzar!</p>");
            out.println("    </div>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}