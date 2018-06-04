package ua.nure.mediaserver.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.List;

public class User {

    @Id
    private ObjectId _id;

    private String email;
    private String password;
    private Double rating;
    private String name;
    private String surname;
    private String country;
    private List<String> authorities; //was List<GrantedAuthority>

    private User() {

    }

    public ObjectId get_id() {
        return _id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public List<GrantedAuthority> getAuthorities() {
//        return authorities; -- was
        return AuthorityUtils.createAuthorityList(this.authorities.toArray(new String[authorities.size()]));
    }

    public void addAuthority(GrantedAuthority authority) {
        this.authorities.add(authority.toString());
    } // was ..add(authority)

    public static Builder builder (){
        return new User().new Builder();
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    public class Builder {

        private Builder(){

        }

        public Builder set_id (ObjectId _id) {
            User.this._id = _id;
            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setCountry(String country) {
            User.this.country = country;
            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public Builder setRating(Double rating) {
            User.this.rating = rating;
            return this;
        }

        public Builder setName(String name) {
            User.this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            User.this.surname = surname;
            return this;
        }

        /*public Builder setAuthorities(List<GrantedAuthority> authoritiesToAdd) {
            User.this.authorities.add(authoritiesToAdd);
            return this;
        }*/

        public User build(){
            User.this.authorities = new ArrayList<>();
            return User.this;
        }
    }

}
