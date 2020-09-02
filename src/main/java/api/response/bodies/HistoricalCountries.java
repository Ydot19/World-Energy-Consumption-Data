package api.response.bodies;

import java.util.ArrayList;

public class HistoricalCountries {
    public final ArrayList<String> countries;

    public HistoricalCountries(ArrayList<String> countries){
        this.countries = countries;
    }
}
