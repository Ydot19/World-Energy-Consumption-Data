package api.routes.historical;

import api.utils.ReadExcelSheet;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import api.response.bodies.HistoricalCountries;

import java.util.ArrayList;
import java.util.HashMap;


@RestController
public class Countries {

    @GetMapping(value="/historical/countries", produces = "application/json")
    @ResponseBody
    @Cacheable("GetCountries")
    public HistoricalCountries getAllCountries(){

        ReadExcelSheet data = new ReadExcelSheet();
        HashMap<String, String> countriesMap = data.getCountries("IEA_HeadlineEnergyData.xlsx");
        ArrayList<String> retArray = new ArrayList<>(countriesMap.keySet());

        return new HistoricalCountries(retArray);
    }


}
