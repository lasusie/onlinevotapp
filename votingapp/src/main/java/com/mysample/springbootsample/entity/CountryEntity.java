/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysample.springbootsample.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "country")
public class CountryEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCountry")
    private Integer idCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cOUNTRYidCountry", fetch = FetchType.EAGER)
    private List<AreaEntity> areaEntityList;

    public CountryEntity() {
    }

    public CountryEntity(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public CountryEntity(Integer idCountry, String name) {
        this.idCountry = idCountry;
        this.name = name;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<AreaEntity> getAreaEntityList() {
        return areaEntityList;
    }

    public void setAreaEntityList(List<AreaEntity> areaEntityList) {
        this.areaEntityList = areaEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCountry != null ? idCountry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryEntity)) {
            return false;
        }
        CountryEntity other = (CountryEntity) object;
        if ((this.idCountry == null && other.idCountry != null) || (this.idCountry != null && !this.idCountry.equals(other.idCountry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysample.springbootsample.entity.CountryEntity[ idCountry=" + idCountry + " ]";
    }
    
}
