/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JAIME
 */

@NamedQueries({

    @NamedQuery(name="searchAccountByBalance", query="SELECT a FROM Account a WHERE a.balance=:balance"),
    
    @NamedQuery(name="deleteAccountByDescription", query="DELETE FROM Account a WHERE a.description=:description")

})

@Entity
@Table(name="account", schema="bank")
@XmlRootElement
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String description;
    private float balance;
    private float creditLine;
    private float beginBalance;
    
    @Temporal(TemporalType.DATE)
    private Date beginBalanceTimestamp;
    
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    
    @ManyToMany(fetch = EAGER, cascade = MERGE)
    @JoinTable(schema="bank", name="customer_account")
    private Set <Customer> customers;
    
    @OneToMany(mappedBy="account", fetch = EAGER, cascade = MERGE)
    private Set <Movement> movements;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(float creditLine) {
        this.creditLine = creditLine;
    }

    public float getBeginBalance() {
        return beginBalance;
    }

    public void setBeginBalance(float beginBalance) {
        this.beginBalance = beginBalance;
    }

    public Date getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public void setBeginBalanceTimestamp(Date beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @XmlTransient
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @XmlTransient
    public Set<Movement> getMovements() {
        return movements;
    }

    public void setMovements(Set<Movement> movements) {
        this.movements = movements;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Float.floatToIntBits(this.balance);
        hash = 67 * hash + Float.floatToIntBits(this.creditLine);
        hash = 67 * hash + Float.floatToIntBits(this.beginBalance);
        hash = 67 * hash + Objects.hashCode(this.beginBalanceTimestamp);
        hash = 67 * hash + Objects.hashCode(this.accountType);
        hash = 67 * hash + Objects.hashCode(this.customers);
        hash = 67 * hash + Objects.hashCode(this.movements);
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
        final Account other = (Account) obj;
        if (Float.floatToIntBits(this.balance) != Float.floatToIntBits(other.balance)) {
            return false;
        }
        if (Float.floatToIntBits(this.creditLine) != Float.floatToIntBits(other.creditLine)) {
            return false;
        }
        if (Float.floatToIntBits(this.beginBalance) != Float.floatToIntBits(other.beginBalance)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.beginBalanceTimestamp, other.beginBalanceTimestamp)) {
            return false;
        }
        if (this.accountType != other.accountType) {
            return false;
        }
        if (!Objects.equals(this.customers, other.customers)) {
            return false;
        }
        if (!Objects.equals(this.movements, other.movements)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", description=" + description + ", balance=" + balance + ", creditLine=" + creditLine + ", beginBalance=" + beginBalance + ", beginBalanceTimestamp=" + beginBalanceTimestamp + ", accountType=" + accountType + ", customers=" + customers + ", movements=" + movements + '}';
    }
    
    
    
}
