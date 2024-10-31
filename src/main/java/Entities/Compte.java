package Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import lombok.Generated;

@Entity
@XmlRootElement(
        name = "compte"
)
public class Compte {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.ORDINAL)
    private TypeCompte typeCompte;

    @XmlElement
    public Long getId() {
        return this.id;
    }

    @XmlElement
    public double getSolde() {
        return this.solde;
    }

    @XmlElement
    public Date getDateCreation() {
        return this.dateCreation;
    }

    @XmlElement
    public TypeCompte getTypeCompte() {
        return this.typeCompte;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setSolde(final double solde) {
        this.solde = solde;
    }

    @Generated
    public void setDateCreation(final Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Generated
    public void setTypeCompte(final TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Compte)) {
            return false;
        } else {
            Compte other = (Compte)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (Double.compare(this.getSolde(), other.getSolde()) != 0) {
                return false;
            } else {
                label49: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label49;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label49;
                    }

                    return false;
                }

                Object this$dateCreation = this.getDateCreation();
                Object other$dateCreation = other.getDateCreation();
                if (this$dateCreation == null) {
                    if (other$dateCreation != null) {
                        return false;
                    }
                } else if (!this$dateCreation.equals(other$dateCreation)) {
                    return false;
                }

                Object this$typeCompte = this.getTypeCompte();
                Object other$typeCompte = other.getTypeCompte();
                if (this$typeCompte == null) {
                    if (other$typeCompte != null) {
                        return false;
                    }
                } else if (!this$typeCompte.equals(other$typeCompte)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Compte;
    }

    @Generated
    public int hashCode() {
        int PRIME = true;
        int result = 1;
        long $solde = Double.doubleToLongBits(this.getSolde());
        result = result * 59 + (int)($solde >>> 32 ^ $solde);
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $dateCreation = this.getDateCreation();
        result = result * 59 + ($dateCreation == null ? 43 : $dateCreation.hashCode());
        Object $typeCompte = this.getTypeCompte();
        result = result * 59 + ($typeCompte == null ? 43 : $typeCompte.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Compte(id=" + var10000 + ", solde=" + this.getSolde() + ", dateCreation=" + this.getDateCreation() + ", typeCompte=" + this.getTypeCompte() + ")";
    }

    @Generated
    public Compte() {
    }

    @Generated
    public Compte(final Long id, final double solde, final Date dateCreation, final TypeCompte typeCompte) {
        this.id = id;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.typeCompte = typeCompte;
    }
}

