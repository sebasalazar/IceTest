package cl.bancofalabella.icetest.servlet;

import com.icesoft.faces.webapp.xmlhttp.PersistentFacesServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sebastián Salazar Molina.
 */
public class PersistentFaces extends PersistentFacesServlet {

    private static final long serialVersionUID = 2258514686439265792L;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistentFaces.class);

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        try {
            super.service(req, res);
        } catch (Exception e) {
            LOGGER.error("Error al procesar petición: {}", e.toString());
            LOGGER.debug("Error al procesar petición: {}", e.toString(), e);
        }
    }

}
