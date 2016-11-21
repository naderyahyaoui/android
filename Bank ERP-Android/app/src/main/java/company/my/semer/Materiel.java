package company.my.semer;

/**
 * Created by Faycel M'rabet on 10/11/2015.
 */
public class Materiel {

     int idM;
    float price;
     int qte;
     String description;
     String path;
     String type;
    public Materiel()
    {}

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Materiel:" +

                "  \n\n\n Price:" + price +
                " \n \n Quantity:" + qte +
                " \n \nDescription:" + description +

                " \n \n Type:" + type ;
    }

    public Materiel(int idM, float price, int qte, String description, String path, String type) {
        this.idM = idM;
        this.price = price;
        this.qte = qte;
        this.description = description;
        this.path = path;
        this.type = type;
    }
}
