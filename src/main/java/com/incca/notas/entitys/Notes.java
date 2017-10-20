/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.notas.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "notes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notes.findAll", query = "SELECT n FROM Notes n")
    , @NamedQuery(name = "Notes.findByNotCode", query = "SELECT n FROM Notes n WHERE n.notCode = :notCode")
    , @NamedQuery(name = "Notes.findByNotTitle", query = "SELECT n FROM Notes n WHERE n.notTitle = :notTitle")
    , @NamedQuery(name = "Notes.findByNotText", query = "SELECT n FROM Notes n WHERE n.notText = :notText")
    , @NamedQuery(name = "Notes.findByNotFecreate", query = "SELECT n FROM Notes n WHERE n.notFecreate = :notFecreate")
    , @NamedQuery(name = "Notes.findByNotFeupdate", query = "SELECT n FROM Notes n WHERE n.notFeupdate = :notFeupdate")})
public class Notes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "not_code")
    private Integer notCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "not_title")
    private String notTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "not_text")
    private String notText;
    @Column(name = "not_fecreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date notFecreate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "not_feupdate")
    private String notFeupdate;
    @JoinColumn(name = "use_code", referencedColumnName = "use_code")
    @ManyToOne(optional = false)
    private Users users;

    public Notes() {
    }

    public Notes(Integer notCode) {
        this.notCode = notCode;
    }

    public Notes(Integer notCode, String notTitle, String notText, String notFeupdate) {
        this.notCode = notCode;
        this.notTitle = notTitle;
        this.notText = notText;
        this.notFeupdate = notFeupdate;
    }

    public Integer getNotCode() {
        return notCode;
    }

    public void setNotCode(Integer notCode) {
        this.notCode = notCode;
    }

    public String getNotTitle() {
        return notTitle;
    }

    public void setNotTitle(String notTitle) {
        this.notTitle = notTitle;
    }

    public String getNotText() {
        return notText;
    }

    public void setNotText(String notText) {
        this.notText = notText;
    }

    public Date getNotFecreate() {
        return notFecreate;
    }

    public void setNotFecreate(Date notFecreate) {
        this.notFecreate = notFecreate;
    }

    public String getNotFeupdate() {
        return notFeupdate;
    }

    public void setNotFeupdate(String notFeupdate) {
        this.notFeupdate = notFeupdate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notCode != null ? notCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notes)) {
            return false;
        }
        Notes other = (Notes) object;
        if ((this.notCode == null && other.notCode != null) || (this.notCode != null && !this.notCode.equals(other.notCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.incca.notas.entitys.Notes[ notCode=" + notCode + " ]";
    }
    
}
