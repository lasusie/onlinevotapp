/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysample.springbootsample.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "vote_pool")
public class VotePoolEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVotePool")
    private Integer idVotePool;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VoteDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date voteDate;
    @JoinColumn(name = "CANDIDATE_idCandidate", referencedColumnName = "idCandidate")
    @ManyToOne(fetch = FetchType.EAGER)
    private CandidateEntity cANDIDATEidCandidate;
    @JoinColumn(name = "COMMITTEE_idComm", referencedColumnName = "idComm")
    @ManyToOne(fetch = FetchType.EAGER)
    private CommitteeEntity cOMMITTEEidComm;
    @JoinColumn(name = "USER_idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UserEntity uSERidUser;

    public VotePoolEntity() {
    }

    public VotePoolEntity(Integer idVotePool) {
        this.idVotePool = idVotePool;
    }

    public VotePoolEntity(Integer idVotePool, Date voteDate) {
        this.idVotePool = idVotePool;
        this.voteDate = voteDate;
    }

    public Integer getIdVotePool() {
        return idVotePool;
    }

    public void setIdVotePool(Integer idVotePool) {
        this.idVotePool = idVotePool;
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }

    public CandidateEntity getCANDIDATEidCandidate() {
        return cANDIDATEidCandidate;
    }

    public void setCANDIDATEidCandidate(CandidateEntity cANDIDATEidCandidate) {
        this.cANDIDATEidCandidate = cANDIDATEidCandidate;
    }

    public CommitteeEntity getCOMMITTEEidComm() {
        return cOMMITTEEidComm;
    }

    public void setCOMMITTEEidComm(CommitteeEntity cOMMITTEEidComm) {
        this.cOMMITTEEidComm = cOMMITTEEidComm;
    }

    public UserEntity getUSERidUser() {
        return uSERidUser;
    }

    public void setUSERidUser(UserEntity uSERidUser) {
        this.uSERidUser = uSERidUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVotePool != null ? idVotePool.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotePoolEntity)) {
            return false;
        }
        VotePoolEntity other = (VotePoolEntity) object;
        if ((this.idVotePool == null && other.idVotePool != null) || (this.idVotePool != null && !this.idVotePool.equals(other.idVotePool))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysample.springbootsample.entity.VotePoolEntity[ idVotePool=" + idVotePool + " ]";
    }
    
}
