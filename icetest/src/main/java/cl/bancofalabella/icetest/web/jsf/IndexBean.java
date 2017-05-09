package cl.bancofalabella.icetest.web.jsf;

import cl.bancofalabella.icetest.model.Country;
import cl.bancofalabella.icetest.model.ForeignResidence;
import cl.bancofalabella.icetest.utils.FacesUtils;
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
    private boolean hasForeignResidence = false;
    private boolean showForeignResidencePanel = false;
    private List<SelectItem> countries = null;
    private Country noCountry = new Country("", "No Country");
    private List<ForeignResidence> foreignResidences = null;
    private boolean acceptConditions = false;

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexBean.class);

    @PostConstruct
    public void initBean() {
        countries = new ArrayList<SelectItem>();
        countries.add(new SelectItem(new Country("AR", "Argentina"), "Argentina"));
        countries.add(new SelectItem(new Country("PE", "Perú"), "Perú"));
        countries.add(new SelectItem(new Country("PA", "Paraguay"), "Paraguay"));
        countries.add(new SelectItem(new Country("US", "Estados Unidos"), "Estados Unidos"));
        foreignResidences = new ArrayList<ForeignResidence>();
        foreignResidences.add(new ForeignResidence());
        refresh();
    }

    public void refresh() {
        if ((int) (Math.random() * 10) == 7) {
            hasForeignResidence = true;
        }
    }

    public void reset(ActionEvent event) {
        showForeignResidencePanel = false;
        foreignResidences = new ArrayList<ForeignResidence>();
        foreignResidences.add(new ForeignResidence());
        acceptConditions = false;
        modalOpened = false;
    }

    public void open(ActionEvent event) {
        showForeignResidencePanel = false;
        acceptConditions = false;
        modalOpened = true;
    }

    public void process(ActionEvent event) {
        ForeignResidence last = foreignResidences.get(foreignResidences.size() - 1);
        if (!last.getCountry().getCode().equals("")) {
            if (!last.getTin().equals("")) {
                if (acceptConditions) {
                    modalOpened = false;
                } else {
                    FacesUtils.errorMessage("errorTerms");
                }
            } else {
                FacesUtils.errorMessage("errorTin");
            }
        } else {
            FacesUtils.errorMessage("errorCountry");
        }
    }

    public void addForeignResidence(ActionEvent event) {
        ForeignResidence last = foreignResidences.get(foreignResidences.size() - 1);
        if (!last.getCountry().getCode().equals("")) {
            if (!last.getTin().equals("")) {
                foreignResidences.add(new ForeignResidence());
            } else {
                FacesUtils.errorMessage("errorTin");
            }
        } else {
            FacesUtils.errorMessage("errorCountry");
        }
    }

    public void removeForeignResidence(int i) {
        ForeignResidence remove = foreignResidences.get(i);
        foreignResidences.remove(remove);
    }

    public boolean isModalOpened() {
        return modalOpened;
    }

    public void setModalOpened(boolean modalOpened) {
        this.modalOpened = modalOpened;
    }

    public boolean isHasForeignResidence() {
        return hasForeignResidence;
    }

    public void setHasForeignResidence(boolean hasForeignResidence) {
        this.hasForeignResidence = hasForeignResidence;
    }

    public boolean isShowForeignResidencePanel() {
        return showForeignResidencePanel;
    }

    public void setShowForeignResidencePanel(boolean showForeignResidencePanel) {
        this.showForeignResidencePanel = showForeignResidencePanel;
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

    public Country getNoCountry() {
        return noCountry;
    }

}
