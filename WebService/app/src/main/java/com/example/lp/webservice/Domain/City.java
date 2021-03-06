package com.example.lp.webservice.Domain;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jonathan on 04/12/16.
 */

public class City {

    private String name;
    private int postalCode;
    private int inseeCode;
    private String regionCode;
    private double latitude;
    private double longitude;
    private double remoteness;
    private int inhabitantNumber;

    public static final String NAME_DB_COL = "Nom_Ville";
    public static final String POSTAL_CODE_DB_COL = "Code_Postal";
    public static final String INSEE_CODE_DB_COL = "Code_INSEE";
    public static final String REGION_CODE_DB_COL = "Code_Region";
    public static final String LATITUDE_DB_COL = "Latitude";
    public static final String LONGITUDE_DB_COL = "Longitude";
    public static final String REMOTENESS_DB_COL = "Eloignement";
    public static final String INHABITANT_NUMBER_DB_COL = "nbre_habitants";

    private static final int INVALID_VALUE = -999999;

    public City(String name, int postalCode, int inseeCode, String regionCode, double latitude, double longitude, double remoteness, int inhabitantNumber) {
        this.name = name;
        this.inseeCode = inseeCode;
        this.postalCode = postalCode;
        this.regionCode = regionCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.remoteness = remoteness;
        this.inhabitantNumber = inhabitantNumber;
    }

    public static City createFromJSONArray(JSONArray JSONArrayFromResponse) throws JSONException {

        JSONObject cityJSONObjet = JSONArrayFromResponse.getJSONObject(0);

        return new City(
            ( ! cityJSONObjet.isNull("Nom_Ville") ) ? cityJSONObjet.getString("Nom_Ville") : "",
            ( ! cityJSONObjet.isNull("Code_Postal") ) ? cityJSONObjet.getInt("Code_Postal") : INVALID_VALUE,
            ( ! cityJSONObjet.isNull("Code_INSEE") ) ? cityJSONObjet.getInt("Code_INSEE") : INVALID_VALUE ,
            ( ! cityJSONObjet.isNull("Code_Region") ) ? cityJSONObjet.getString("Code_Region") : "",
            ( ! cityJSONObjet.isNull("Latitude") ) ? cityJSONObjet.getDouble("Latitude") : INVALID_VALUE,
            ( ! cityJSONObjet.isNull("Longitude") ) ? cityJSONObjet.getDouble("Longitude") : INVALID_VALUE,
            ( ! cityJSONObjet.isNull("Eloignement") ) ? cityJSONObjet.getDouble("Eloignement") : INVALID_VALUE,
            ( ! cityJSONObjet.isNull("nbre_habitants") ) ? cityJSONObjet.getInt("nbre_habitants") : INVALID_VALUE
        );
    }

    public HashMap<String, String> getDetailsAsHashMap() {
        HashMap<String, String> cityCharacteristics = new HashMap<>();
        cityCharacteristics.put( City.NAME_DB_COL, this.name );
        cityCharacteristics.put( City.INSEE_CODE_DB_COL, ( (this.inseeCode != INVALID_VALUE) ? Integer.toString(this.inseeCode) : "") );
        cityCharacteristics.put( City.POSTAL_CODE_DB_COL, ( (this.postalCode != INVALID_VALUE) ? Integer.toString(this.postalCode) : "") );
        cityCharacteristics.put( City.REGION_CODE_DB_COL, this.regionCode );
        cityCharacteristics.put( City.LATITUDE_DB_COL, ( (this.latitude != INVALID_VALUE) ? Double.toString(this.latitude) : "") );
        cityCharacteristics.put( City.LONGITUDE_DB_COL, ( (this.longitude != INVALID_VALUE) ? Double.toString(this.longitude) : "") );
        cityCharacteristics.put( City.REMOTENESS_DB_COL, ( (this.remoteness != INVALID_VALUE) ? Double.toString(this.remoteness) : "") );
        cityCharacteristics.put( City.INHABITANT_NUMBER_DB_COL, ( (this.inhabitantNumber != INVALID_VALUE) ? Integer.toString(this.inhabitantNumber) : "") );
        return cityCharacteristics;
    }

    public String getName() {
        return name;
    }

    public int getInseeCode() {
        return inseeCode;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRemoteness() {
        return remoteness;
    }

    public int getInhabitantNumber() {
        return inhabitantNumber;
    }
}
