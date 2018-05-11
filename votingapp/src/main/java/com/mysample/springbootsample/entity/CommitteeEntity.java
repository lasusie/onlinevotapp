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
@Table(name = "committee")
public class CommitteeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComm")
    private Integer idComm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cOMMITTEEidComm", fetch = FetchType.EAGER)
    private List<CandidateEntity> candidateEntityList;
    @OneToMany(mappedBy = "cOMMITTEEidComm", fetch = FetchType.EAGER)
    private List<VotePoolEntity> votePoolEntityList;

    public CommitteeEntity() {
    }

    public CommitteeEntity(Integer idComm) {
        this.idComm = idComm;
    }

    public CommitteeEntity(Integer idComm, String name) {
        this.idComm = idComm;
        this.name = name;
    }

    public Integer getIdComm() {
        return idComm;
    }

    public void setIdComm(Integer idComm) {
        this.idComm = idComm;
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

    @XmlTransient
    public List<VotePoolEntity> getVotePoolEntityList() {
        return votePoolEntityList;
    }

    public void setVotePoolEntityList(List<VotePoolEntity> votePoolEntityList) {
        this.votePoolEntityList = votePoolEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComm != null ? idComm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommitteeEntity)) {
            return false;
        }
        CommitteeEntity other = (CommitteeEntity) object;
        if ((this.idComm == null && other.idComm != null) || (this.idComm != null && !this.idComm.equals(other.idComm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysample.springbootsample.entity.CommitteeEntity[ idComm=" + idComm + " ]";
    }
    
}
