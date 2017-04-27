package cl.bancofalabella.icetest.web.jsf;

import cl.bancofalabella.icetest.utils.FacesUtils;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sebastián Salazar Molina.
 */
@Component
@Scope("request")
@Qualifier("indexBean")
public class IndexBean implements Serializable {

    private static final long serialVersionUID = 8491384550722840576L;

    private String token = null;
    private String loginUrl = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexBean.class);

    @PostConstruct
    public void initBean() {
        loginUrl = String.format("%s/login", FacesUtils.getRequest().getContextPath());
        token = FacesUtils.getRequestParameter("token");
        LOGGER.debug("Se ha recibido el token: '{}'", token);
    }

    public String getToken() {
        return token;
    }

    public String getLoginUrl() {
        return loginUrl;
    }
}
