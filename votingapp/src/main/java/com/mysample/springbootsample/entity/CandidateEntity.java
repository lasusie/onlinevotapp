/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysample.springbootsample.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "candidate")
public class CandidateEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCandidate")
    private Integer idCandidate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "COMMITTEE_idComm", referencedColumnName = "idComm")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CommitteeEntity cOMMITTEEidComm;
    @JoinColumn(name = "DEPARTMENT_idDepto", referencedColumnName = "idDepto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private DepartmentEntity dEPARTMENTidDepto;
    @OneToMany(mappedBy = "cANDIDATEidCandidate", fetch = FetchType.EAGER)
    private List<VotePoolEntity> votePoolEntityList;

    public CandidateEntity() {
    }

    public CandidateEntity(Integer idCandidate) {
        this.idCandidate = idCandidate;
    }

    public CandidateEntity(Integer idCandidate, String name) {
        this.idCandidate = idCandidate;
        this.name = name;
    }

    public Integer getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Integer idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommitteeEntity getCOMMITTEEidComm() {
        return cOMMITTEEidComm;
    }

    public void setCOMMITTEEidComm(CommitteeEntity cOMMITTEEidComm) {
        this.cOMMITTEEidComm = cOMMITTEEidComm;
    }

    public DepartmentEntity getDEPARTMENTidDepto() {
        return dEPARTMENTidDepto;
    }

    public void setDEPARTMENTidDepto(DepartmentEntity dEPARTMENTidDepto) {
        this.dEPARTMENTidDepto = dEPARTMENTidDepto;
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
        hash += (idCandidate != null ? idCandidate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidateEntity)) {
            return false;
        }
        CandidateEntity other = (CandidateEntity) object;
        if ((this.idCandidate == null && other.idCandidate != null) || (this.idCandidate != null && !this.idCandidate.equals(other.idCandidate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysample.springbootsample.entity.CandidateEntity[ idCandidate=" + idCandidate + " ]";
    }
    
}
