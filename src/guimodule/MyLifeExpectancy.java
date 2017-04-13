package guimodule;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Damian on 4/11/2017.
 */
public class MyLifeExpectancy extends PApplet {
    UnfoldingMap map;
    Map<String, Float> lifeExpByCountry;
    List<Feature> countries;
    List<Marker> countryMarkers;

    public void setup(){
        size(800,800, OPENGL);
        map = new UnfoldingMap(this,50,50,500,500, new OpenStreetMap.OpenStreetMapProvider());
        MapUtils.createDefaultEventDispatcher(this, map);
        lifeExpByCountry = loadLifeExpectancyFromCSV("D:\\GOOGLE\\PROGRAMOWANIE\\Coursera\\UCSDUnfoldingMaps\\data\\LifeExpectancyWorldBankModule3.csv");
        countries = GeoJSONReader.loadData(this, "D:\\GOOGLE\\PROGRAMOWANIE\\Coursera\\UCSDUnfoldingMaps\\data\\countries.geo.json");
        countryMarkers = MapUtils.createSimpleMarkers(countries);
    }

    public void draw(){
        map.draw();
        map.addMarkers(countryMarkers);
        shadeCountries();

    }

    private void shadeCountries() {
        for (Marker marker : countryMarkers){
            String countryID = marker.getId();
            if(lifeExpByCountry.containsKey(countryID)){
                float lifeExp = lifeExpByCountry.get(countryID);
                int colorLevel = (int) map(lifeExp,40,90,10,255);
                marker.setColor(color(255-colorLevel,100,colorLevel));
            }
            else
                marker.setColor(color(150,150,150));
        }

    }

    private Map<String, Float> loadLifeExpectancyFromCSV(String filename){
        Map<String, Float> lifeExpMap = new HashMap<String,Float>();
        String[]rows = loadStrings(filename);
        for (String row : rows){
            String[]columns = row.split(",");
            if (columns.length == 6 && !columns[5].equals("..")) {
                lifeExpMap.put(columns[4], Float.parseFloat(columns[5]));
            }
        }

        return lifeExpMap;
    }

}
