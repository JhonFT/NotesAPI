/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.notas.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 *
 * @author Home
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUseCode", query = "SELECT u FROM Users u WHERE u.useCode = :useCode")
    , @NamedQuery(name = "Users.findByUseName", query = "SELECT u FROM Users u WHERE u.useName = :useName")
    , @NamedQuery(name = "Users.findByUseUser", query = "SELECT u FROM Users u WHERE u.useUser = :useUser")
    , @NamedQuery(name = "Users.findByUsePass", query = "SELECT u FROM Users u WHERE u.usePass = :usePass")
    , @NamedQuery(name = "Users.findByUseEmail", query = "SELECT u FROM Users u WHERE u.useEmail = :useEmail")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "use_code")
    private Integer useCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "use_name")
    private String useName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "use_user")
    private String useUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "use_pass")
    private String usePass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "use_email")
    private String useEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Notes> notesList;

    public Users() {
    }

    public Users(Integer useCode) {
        this.useCode = useCode;
    }

    public Users(Integer useCode, String useName, String useUser, String usePass, String useEmail) {
        this.useCode = useCode;
        this.useName = useName;
        this.useUser = useUser;
        this.usePass = usePass;
        this.useEmail = useEmail;
    }

    public Integer getUseCode() {
        return useCode;
    }

    public void setUseCode(Integer useCode) {
        this.useCode = useCode;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getUseUser() {
        return useUser;
    }

    public void setUseUser(String useUser) {
        this.useUser = useUser;
    }

    public String getUsePass() {
        return usePass;
    }

    public void setUsePass(String usePass) {
        this.usePass = usePass;
    }

    public String getUseEmail() {
        return useEmail;
    }

    public void setUseEmail(String useEmail) {
        this.useEmail = useEmail;
    }

    @XmlTransient
    public List<Notes> getNotesList() {
        return notesList;
    }

    public void setNotesList(List<Notes> notesList) {
        this.notesList = notesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (useCode != null ? useCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.useCode == null && other.useCode != null) || (this.useCode != null && !this.useCode.equals(other.useCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.incca.notas.entitys.Users[ useCode=" + useCode + " ]";
    }
    
}
