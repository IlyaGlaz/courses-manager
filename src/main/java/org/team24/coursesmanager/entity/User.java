package org.team24.coursesmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User
        //implements UserDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;

    private String lastname;
    private String email;
    private String password;

    @Column(name = "grades_sum")
    private float gradesSum;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<StudentLog> logs;

    @ManyToMany
    @JoinTable(name = "absence")
    private List<Lesson> missedLessons;

    @OneToMany
    private List<StudentGrade> grades;

    @ManyToMany
    @JoinTable(name = "users_xref_groups")
    private List<Group> group;

    //@Override
    //public Collection<? extends GrantedAuthority> getAuthorities() {
    //    return List.of(new SimpleGrantedAuthority(role.name()));
    //}
    //
    //@Override
    //public String getPassword() {
    //    return password;
    //}
    //
    //@Override
    //public String getUsername() {
    //    return email;
    //}
    //
    //@Override
    //public boolean isAccountNonExpired() {
    //    return true;
    //}
    //
    //@Override
    //public boolean isAccountNonLocked() {
    //    return true;
    //}
    //
    //@Override
    //public boolean isCredentialsNonExpired() {
    //    return true;
    //}
    //
    //@Override
    //public boolean isEnabled() {
    //    return true;
    //}
}
