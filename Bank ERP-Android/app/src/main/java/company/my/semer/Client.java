package company.my.semer;

/**
 * Created by ji on 08/11/2015.
 */
public class Client {

    int idUser;
    String  adresse;
    String firstName;
    String lastName;
    String tel;
    String mail;
    int dateNaissance;
    String lieuNaissance;
    String etatCivil;
    String nationalite;
    int cin;
    String login;
    String password;




    public Client() {
    }


    public Client(String adresse, String firstName, String lastName, String tel, String mail, int dateNaissance, String lieuNaissance, String etatCivil, String nationalite, int cin, String login, String password) {
        super();
        this.adresse = adresse;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.mail = mail;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.etatCivil = etatCivil;
        this.nationalite = nationalite;
        this.cin = cin;
        this.login = login;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(int dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    @Override
    public String toString() {
        return "Bonjour Mr:" + firstName +
                "\n Last Name:" + lastName  +
                "\n Telephone:" + tel +
                "\n Mail:" + mail +
                "\n Cin:" + cin +
                "\n Etat Civil=" + etatCivil+
                 "\n Password:  " + password ;









    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
