
package app;


public class Contact {
    private String firstName; 
    private String lastName;
    private String city;
    private String country;
    private String email;

    public Contact(String firstName, String lastName, String city, String country, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        if(email.isBlank()){
        return firstName + " " + lastName + "(" + city  + ")";
    }
        return firstName + " " + lastName + "(" + city + ")" + " "+email;
    }

     public Object[] getProperties(){
        return new Object[] {firstName, lastName, city, country, email};
    }
}
