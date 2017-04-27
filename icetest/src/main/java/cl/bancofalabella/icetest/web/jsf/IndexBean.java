package cl.bancofalabella.icetest.web.jsf;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sebastián Salazar Molina.
 */
@Component
public class IndexBean implements Serializable {

    private static final long serialVersionUID = 8491384550722840576L;

    private Date now = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexBean.class);

    @PostConstruct
    public void initBean() {
        now = new Date();
    }

    public Date getNow() {
        return now;
    }
}
