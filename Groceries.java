package online;

import java.lang.*;
import java.util.Random;

class Groceries {
    private String sProdId;
    private String sProdName;
    private String sProdDesc;
    private int dwQuantity;
    private float fPrice;

    // c'tor
    Groceries() {
        sProdId = "";
        sProdName = "";
        sProdDesc = "";
        dwQuantity = 0;
        fPrice = 0;
    }

    // c'tor overload
    Groceries(String ProdName, String ProdDesc, int Quantity, float price) {
        sProdName = ProdName;
        sProdDesc = ProdDesc;
        dwQuantity = Quantity;
        fPrice = price;
        GenerateProdId();
    }

    // Generate/Create prod id
    void GenerateProdId() {
        Random rand = new Random();
        sProdId = "" + rand.nextInt(10);
        sProdId += "-" + rand.nextInt(10000);
        sProdId += "-" + rand.nextInt(10000);
        sProdId += "-" + rand.nextInt(10);
    }

    public String GetProdId() {
        return sProdId;
    }

    public String GetProdName() {
        return sProdName;
    }

    public String GetProdDesc() {
        return sProdDesc;
    }

    public int GetProdQuan() {
        return dwQuantity;
    }

    public float GetProdPrice() {
        return fPrice;
    }

    public String DisplayProduct() {
        String prodString = "" + sProdId + "\t\t" + sProdName + "\t\t" + sProdDesc + "\t\t" + dwQuantity + "\t\t"
                + fPrice;

        return prodString;
    }
};