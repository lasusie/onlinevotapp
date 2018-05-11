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
@Table(name = "department")
public class DepartmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepto")
    private Integer idDepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dEPARTMENTidDepto", fetch = FetchType.EAGER)
    private List<CandidateEntity> candidateEntityList;
    @JoinColumn(name = "AREA_idArea", referencedColumnName = "idArea")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private AreaEntity aREAidArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dEPARTMENTidDepto", fetch = FetchType.EAGER)
    private List<UserEntity> userEntityList;

    public DepartmentEntity() {
    }

    public DepartmentEntity(Integer idDepto) {
        this.idDepto = idDepto;
    }

    public DepartmentEntity(Integer idDepto, String name) {
        this.idDepto = idDepto;
        this.name = name;
    }

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<CandidateEntity> getCandidateEntityList() {
        return candidateEntityList;
    }

    public void setCandidateEntityList(List<CandidateEntity> candidateEntityList) {
        this.candidateEntityList = candidateEntityList;
    }

    public AreaEntity getAREAidArea() {
        return aREAidArea;
    }

    public void setAREAidArea(AreaEntity aREAidArea) {
        this.aREAidArea = aREAidArea;
    }

    @XmlTransient
    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepto != null ? idDepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentEntity)) {
            return false;
        }
        DepartmentEntity other = (DepartmentEntity) object;
        if ((this.idDepto == null && other.idDepto != null) || (this.idDepto != null && !this.idDepto.equals(other.idDepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysample.springbootsample.entity.DepartmentEntity[ idDepto=" + idDepto + " ]";
    }
    
}
