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
@Table(name = "audit")
public class AuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAudit")
    private Integer idAudit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;
    @JoinColumn(name = "USER_idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UserEntity uSERidUser;

    public AuditEntity() {
    }

    public AuditEntity(Integer idAudit) {
        this.idAudit = idAudit;
    }

    public AuditEntity(Integer idAudit, Date loginDate) {
        this.idAudit = idAudit;
        this.loginDate = loginDate;
    }

    public Integer getIdAudit() {
        return idAudit;
    }

    public void setIdAudit(Integer idAudit) {
        this.idAudit = idAudit;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
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
        hash += (idAudit != null ? idAudit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditEntity)) {
            return false;
        }
        AuditEntity other = (AuditEntity) object;
        if ((this.idAudit == null && other.idAudit != null) || (this.idAudit != null && !this.idAudit.equals(other.idAudit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysample.springbootsample.entity.AuditEntity[ idAudit=" + idAudit + " ]";
    }
    
}
