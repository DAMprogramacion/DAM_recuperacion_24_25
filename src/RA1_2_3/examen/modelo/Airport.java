package RA1_2_3.examen.modelo;

import RA1_2_3.examen.excepciones.AltitudeException;

import java.util.Objects;

//airportName,airporCity,airportCountryCode,airportContinent,airporElevation
public class Airport {
    private String airportName;
    private String airportCity;
    private String airportCountryCode;
    private String airportContinent;
    private int airportElevation;

    public Airport(String airportName, String airportCity, String airportCountryCode,
                   String airportContinent, int airportElevation) throws AltitudeException {
        if (airportElevation < 0)
            throw new AltitudeException("invalid value");
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCountryCode = airportCountryCode;
        this.airportContinent = airportContinent;
        this.airportElevation = airportElevation;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportCountryCode() {
        return airportCountryCode;
    }

    public void setAirportCountryCode(String airportCountryCode) {
        this.airportCountryCode = airportCountryCode;
    }

    public String getAirportContinent() {
        return airportContinent;
    }

    public void setAirportContinent(String airportContinent) {
        this.airportContinent = airportContinent;
    }

    public int getAirportElevation() {
        return airportElevation;
    }

    public void setAirportElevation(int airportElevation) throws AltitudeException {
        if (airportElevation < 0)
            throw new AltitudeException("invalid value");
        this.airportElevation = airportElevation;
    }
    //airportName,airporCity,airportCountryCode,airportContinent,airporElevation
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d", airportName, airportCity,
                airportCountryCode, airportContinent, airportElevation );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airportName, airport.airportName) && Objects.equals(airportCountryCode, airport.airportCountryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportName, airportCountryCode);
    }
}
