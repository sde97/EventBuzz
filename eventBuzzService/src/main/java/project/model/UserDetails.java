package project.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;



@Entity
@Table(name="UserDetails")
public class UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="udtls_id")
    private Long userDetailsId;
    private String name;
    private String email;
    private String phone;
    private String idType;
    private String idUrl;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    protected UserDetails(){}
    
    
    public UserDetails(String name, String email, String phone, String idType, String idUrl, User user) {
        
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idType = idType;
        this.idUrl = idUrl;
        this.user=user;
    }

    public Long getUserDetailsId() {
        return userDetailsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdUrl() {
        return idUrl;
    }

    public void setIdUrl(String idUrl) {
        this.idUrl = idUrl;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

    
    


