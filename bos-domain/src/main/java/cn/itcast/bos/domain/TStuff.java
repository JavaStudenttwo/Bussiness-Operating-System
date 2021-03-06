package cn.itcast.bos.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_stuff", schema = "bos")
public class TStuff implements Serializable {
    private String id;
    private String name;
    private Integer telephone;
    private Integer haspda;
    private Integer daltag;
    private String standard;
    private String station;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "telephone", nullable = true)
    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "haspda", nullable = true)
    public Integer getHaspda() {
        return haspda;
    }

    public void setHaspda(Integer haspda) {
        this.haspda = haspda;
    }

    @Basic
    @Column(name = "daltag", nullable = true)
    public Integer getDaltag() {
        return daltag;
    }

    public void setDaltag(Integer daltag) {
        this.daltag = daltag;
    }

    @Basic
    @Column(name = "standard", nullable = true, length = 20)
    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Basic
    @Column(name = "station", nullable = true, length = 20)
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TStuff tStuff = (TStuff) o;

        if (id != null ? !id.equals(tStuff.id) : tStuff.id != null) return false;
        if (name != null ? !name.equals(tStuff.name) : tStuff.name != null) return false;
        if (telephone != null ? !telephone.equals(tStuff.telephone) : tStuff.telephone != null) return false;
        if (haspda != null ? !haspda.equals(tStuff.haspda) : tStuff.haspda != null) return false;
        if (daltag != null ? !daltag.equals(tStuff.daltag) : tStuff.daltag != null) return false;
        if (standard != null ? !standard.equals(tStuff.standard) : tStuff.standard != null) return false;
        if (station != null ? !station.equals(tStuff.station) : tStuff.station != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (haspda != null ? haspda.hashCode() : 0);
        result = 31 * result + (daltag != null ? daltag.hashCode() : 0);
        result = 31 * result + (standard != null ? standard.hashCode() : 0);
        result = 31 * result + (station != null ? station.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TStuff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", telephone=" + telephone +
                ", haspda=" + haspda +
                ", daltag=" + daltag +
                ", standard='" + standard + '\'' +
                ", station='" + station + '\'' +
                '}';
    }
}
