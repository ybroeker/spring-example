package gpse.example.domain;

import java.util.*;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

    private static final long serialVersionUID = 0L;

    @Id
    @Column
    private String username;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    protected User() {

    }


    public User(final String username, final String firstname, final String lastname, final String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

// tag::addRole[]
    public void addRole(String role) {
        if (roles == null) {
            this.roles = new ArrayList<>();//<1>
        }

        this.roles.add(role);//<2>
    }
// end::addRole[]

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(roles.toArray(new String[0]));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


}
