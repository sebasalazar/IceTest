package cl.bancofalabella.icetest.web.jsf;

import cl.bancofalabella.icetest.model.Country;
import cl.bancofalabella.icetest.model.ForeignResidence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
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
    private boolean modalOpened = false;
    
    private boolean foreignResidence = false;
    private List<SelectItem> countries = null;
    private List<ForeignResidence> foreignResidences = null;
    
    private Country frCountry = null;
    private String frTin = null;
    
    private boolean acceptConditions = false;

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexBean.class);

    @PostConstruct
    public void initBean() {
        countries = new ArrayList<SelectItem>();
        countries.add(new SelectItem(new Country("AR","Argentina"),"Argentina"));
        countries.add(new SelectItem(new Country("PE","Perú"),"Perú"));
        countries.add(new SelectItem(new Country("PA","Paraguay"),"Paraguay"));
        countries.add(new SelectItem(new Country("US","Estados Unidos"),"Estados Unidos"));
        foreignResidences = new ArrayList<ForeignResidence>() ;
    }

    public boolean isModalOpened() {
        return modalOpened;
    }

    public void setModalOpened(boolean modalOpened) {
        this.modalOpened = modalOpened;
    }
    
    public void toggleOpened(ActionEvent event) {
        modalOpened = !modalOpened;
    }

    public boolean isForeignResidence() {
        return foreignResidence;
    }

    public void setForeignResidence(boolean foreignResidence) {
        this.foreignResidence = foreignResidence;
    }

    public List<SelectItem> getCountries() {
        return countries;
    }

    public void setCountries(List<SelectItem> countries) {
        this.countries = countries;
    }

    public List<ForeignResidence> getForeignResidences() {
        return foreignResidences;
    }

    public void setForeignResidences(List<ForeignResidence> foreignResidences) {
        this.foreignResidences = foreignResidences;
    }

    public boolean isAcceptConditions() {
        return acceptConditions;
    }

    public void setAcceptConditions(boolean acceptConditions) {
        this.acceptConditions = acceptConditions;
    }

    public Country getFrCountry() {
        return frCountry;
    }

    public void setFrCountry(Country frCountry) {
        this.frCountry = frCountry;
    }

    public String getFrTin() {
        return frTin;
    }

    public void setFrTin(String frTin) {
        this.frTin = frTin;
    }    
    
}
