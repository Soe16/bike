package de.hsba.test.bike.bike.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderForm {

    @Size(min = 3, max = 30, message = "Geben Sie den Namen der Person an, bei der die Lieferung abgeholt werden soll (min. 3, max 30 Zeichen)")
    private String fromName;

    @Size(min = 3, max = 30, message = "Geben Sie die Straße an, an der die Lieferung abgeholt werden soll (min. 3, max 30 Zeichen)" )
    private String fromStreetName;

    @Size(min = 1, max = 5, message = "Geben Sie die Straßennummer an, an der die Lieferung abgeholt werden soll (min. 1, max 5 Ziffern)")
    private String fromStreetNumber;

    @Size(min=5, max=5, message = "Geben Sie eine valide PLZ an, an der die Lieferung abgeholt werden soll")
    private String fromZip;

    @Size(min = 3, max = 30, message = "Geben Sie den Namen der Person an, an die die Lieferung geliefert werden soll (min. 3, max 30 Zeichen)")
    private String toName;

    @Size(min = 3, max = 30, message = "Geben Sie die Straße an, an die die Lieferung geliefert werden soll (min. 3, max 30 Zeichen)")
    private String toStreetName;

    @Size(min = 1, max = 5, message = "Geben Sie die Straßennummer an, an die die Lieferung geliefert werden soll (min. 1, max 5 Ziffern)")
    private String toStreetNumber;

    @Size(min=5, max=5, message = "Geben Sie eine valide PLZ an, an die die Lieferung geliefert werden soll")
    private String toZip;

    @NotNull(message = "Bitte wählen Sie die gewünschte Paketgröße")
    private String packageType;

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromStreetName() {
        return fromStreetName;
    }

    public void setFromStreetName(String fromStreetName) {
        this.fromStreetName = fromStreetName;
    }

    public String getFromStreetNumber() {
        return fromStreetNumber;
    }

    public void setFromStreetNumber(String fromStreetNumber) {
        this.fromStreetNumber = fromStreetNumber;
    }

    public String getFromZip() {
        return fromZip;
    }

    public void setFromZip(String fromZip) {
        this.fromZip = fromZip;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToStreetName() {
        return toStreetName;
    }

    public void setToStreetName(String toStreetName) {
        this.toStreetName = toStreetName;
    }

    public String getToStreetNumber() {
        return toStreetNumber;
    }

    public void setToStreetNumber(String toStreetNumber) {
        this.toStreetNumber = toStreetNumber;
    }

    public String getToZip() {
        return toZip;
    }

    public void setToZip(String toZip) {
        this.toZip = toZip;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
}

