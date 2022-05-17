/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JAIME
 */

@NamedQueries({

    @NamedQuery(name="searchMovementByDate", query="SELECT m FROM Movement m WHERE m.timestamp=:timestamp")

})

@Entity
@Table(name="movement", schema="bank")
@XmlRootElement
public class Movement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private Date timestamp;
    
    private float amount;
    private float balance;
    private String description;
    
    @ManyToOne
    private Account account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.timestamp);
        hash = 17 * hash + Float.floatToIntBits(this.amount);
        hash = 17 * hash + Float.floatToIntBits(this.balance);
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.account);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movement other = (Movement) obj;
        if (Float.floatToIntBits(this.amount) != Float.floatToIntBits(other.amount)) {
            return false;
        }
        if (Float.floatToIntBits(this.balance) != Float.floatToIntBits(other.balance)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.timestamp, other.timestamp)) {
            return false;
        }
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movement{" + "id=" + id + ", timestamp=" + timestamp + ", amount=" + amount + ", balance=" + balance + ", description=" + description + ", account=" + account + '}';
    }
    
    
}
