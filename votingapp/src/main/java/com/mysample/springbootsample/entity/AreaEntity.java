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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "area")
public class AreaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArea")
    private Integer idArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "COUNTRY_idCountry", referencedColumnName = "idCountry")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CountryEntity cOUNTRYidCountry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aREAidArea", fetch = FetchType.EAGER)
    private List<DepartmentEntity> departmentEntityList;

    public AreaEntity() {
    }

    public AreaEntity(Integer idArea) {
        this.idArea = idArea;
    }

    public AreaEntity(Integer idArea, String name) {
        this.idArea = idArea;
        this.name = name;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryEntity getCOUNTRYidCountry() {
        return cOUNTRYidCountry;
    }

    public void setCOUNTRYidCountry(CountryEntity cOUNTRYidCountry) {
        this.cOUNTRYidCountry = cOUNTRYidCountry;
    }

    @XmlTransient
    public List<DepartmentEntity> getDepartmentEntityList() {
        return departmentEntityList;
    }

    public void setDepartmentEntityList(List<DepartmentEntity> departmentEntityList) {
        this.departmentEntityList = departmentEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaEntity)) {
            return false;
        }
        AreaEntity other = (AreaEntity) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysample.springbootsample.entity.AreaEntity[ idArea=" + idArea + " ]";
    }
    
}
