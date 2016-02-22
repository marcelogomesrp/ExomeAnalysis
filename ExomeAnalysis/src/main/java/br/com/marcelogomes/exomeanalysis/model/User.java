package br.com.marcelogomes.exomeanalysis.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Marcelo Gomes de Paula
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @ElementCollection(targetClass=Profile.class , fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Profile> profiles;
    @Column(columnDefinition="tinyint(1) default 0")
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Profile defaultProfile;
    @OneToMany(mappedBy = "manager")
    private List<Project> projects;

    public User() {
        this.profiles = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public void addProfile(Profile profile){
        this.profiles.add(profile);
    }
    
    public void removeProfile(Profile profile){
        this.profiles.remove(profile);
    }
    
    public boolean isProfile(Profile profile){
        for(Profile p : profiles){
            if(profile.equals(p)){
                return true;
            }
        }
        return false;
    }
    public boolean isAdministrator(){
        return this.isProfile(Profile.administrator);
    }
    public boolean isManager(){
        return this.isProfile(Profile.manager);
    }
    public boolean isReviser(){
        return this.isProfile(Profile.reviser);
    }

    public Profile getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Profile defaultProfile) {
        this.defaultProfile = defaultProfile;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + '}';
    }

    
    
}
