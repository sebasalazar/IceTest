package cl.bancofalabella.icetest.model;

/**
 *
 * @author Javier González M.
 */
public class ForeignResidence extends BaseBean {

    private Long id;
    private Country country;
    // TIN = Taxpayer Identification Number
    private String tin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.country != null ? this.country.hashCode() : 0);
        hash = 47 * hash + (this.tin != null ? this.tin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ForeignResidence other = (ForeignResidence) obj;
        if ((this.tin == null) ? (other.tin != null) : !this.tin.equals(other.tin)) {
            return false;
        }
        if (this.country != other.country && (this.country == null || !this.country.equals(other.country))) {
            return false;
        }
        return true;
    }

}
