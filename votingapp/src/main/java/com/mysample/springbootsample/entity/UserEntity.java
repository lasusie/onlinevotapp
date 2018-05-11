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
@Table(name = "user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "surnames")
    private String surnames;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "docID")
    private String docID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSERidUser", fetch = FetchType.EAGER)
    private List<AuditEntity> auditEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSERidUser", fetch = FetchType.EAGER)
    private List<VotePoolEntity> votePoolEntityList;
    @JoinColumn(name = "DEPARTMENT_idDepto", referencedColumnName = "idDepto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private DepartmentEntity dEPARTMENTidDepto;

    public UserEntity() {
    }

    public UserEntity(Integer idUser) {
        this.idUser = idUser;
    }

    public UserEntity(Integer idUser, String name, String surnames, String email, String docID, String username, String password) {
        this.idUser = idUser;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.docID = docID;
        this.username = username;
        this.password = password;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<AuditEntity> getAuditEntityList() {
        return auditEntityList;
    }

    public void setAuditEntityList(List<AuditEntity> auditEntityList) {
        this.auditEntityList = auditEntityList;
    }

    @XmlTransient
    public List<VotePoolEntity> getVotePoolEntityList() {
        return votePoolEntityList;
    }

    public void setVotePoolEntityList(List<VotePoolEntity> votePoolEntityList) {
        this.votePoolEntityList = votePoolEntityList;
    }

    public DepartmentEntity getDEPARTMENTidDepto() {
        return dEPARTMENTidDepto;
    }

    public void setDEPARTMENTidDepto(DepartmentEntity dEPARTMENTidDepto) {
        this.dEPARTMENTidDepto = dEPARTMENTidDepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mysample.springbootsample.entity.UserEntity[ idUser=" + idUser + " ]";
    }
    
}
