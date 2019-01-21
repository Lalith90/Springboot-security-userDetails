package com.securityuserDetails.securityuserDetails.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Email
    @NotNull
    private String email;
    private String fname;
    private String lname;
    private int active;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles;

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Users(@NotNull String username, @NotNull String password, @Email @NotNull String email, String fname, String lname, int active, Set<Roles> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.active = active;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", active=" + active +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getId() == users.getId() &&
                getActive() == users.getActive() &&
                Objects.equals(getUsername(), users.getUsername()) &&
                Objects.equals(getPassword(), users.getPassword()) &&
                Objects.equals(getEmail(), users.getEmail()) &&
                Objects.equals(getFname(), users.getFname()) &&
                Objects.equals(getLname(), users.getLname()) &&
                Objects.equals(getRoles(), users.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getEmail(), getFname(), getLname(), getActive(), getRoles());
    }

    public Users(Users users) {
        this.username = users.getUsername();
        this.password = users.getPassword();
        this.email = users.getEmail();
        this.fname = users.getFname();
        this.lname = users.getLname();
        this.active = users.getActive();
        this.roles = users.getRoles();
    }
// java List allow to duplicate item but set cannot allow it

}
