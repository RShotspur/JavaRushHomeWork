package com.javarush.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by RS on 02.11.2015.
 */
public class MyWay
{
    public static void main(String[] args)
    {
//        City a1 = new City("A1");
//        City a2 = new City("A2");
//        City a3 = new City("A3");
//        City a4 = new City("A4");
//        City a5 = new City("A5");
//        City b1 = new City("B1");
//        City b2 = new City("B2");
//        City b3 = new City("B3");
//        City b4 = new City("B4");
//        City b5 = new City("B5");

        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");


        a.addNeighbor(b, 80);
        a.addNeighbor(c, 110);
        a.addNeighbor(e, 330);
        b.addNeighbor(f, 340);
        c.addNeighbor(d, 60);
        c.addNeighbor(e, 205);
        d.addNeighbor(f, 192);
        e.addNeighbor(f, 80);



//        a1.addNeighbor(a2, 4);
//        a1.addNeighbor(a5, 4);
//        a2.addNeighbor(a3, 4);
//        a2.addNeighbor(a1, 4);
//        a3.addNeighbor(a2, 4);
//        a3.addNeighbor(a4, 2);
//        a4.addNeighbor(a3, 2);
//        a4.addNeighbor(a5, 2);
//        a4.addNeighbor(b2, 20);
//        a5.addNeighbor(a1, 4);
//        a5.addNeighbor(a4, 2);
//
//        b1.addNeighbor(b2, 2);
//        b1.addNeighbor(b5, 4);
//        b2.addNeighbor(b1, 2);
//        b2.addNeighbor(a4, 20);
//        b2.addNeighbor(b3, 2);
//        b3.addNeighbor(b2, 2);
//        b3.addNeighbor(b4, 4);
//        b4.addNeighbor(b3, 4);
//        b4.addNeighbor(b5, 4);
//        b5.addNeighbor(b1, 4);
//        b5.addNeighbor(b4, 4);


        System.out.println(a.bestWayTo(f));
        System.out.println();


    }

    public static class City {
        private String name;
        private Map<City, Double> neighbors = new HashMap<>();

        public City(String name) {
            this.name = name;
        }

        public void addNeighbor (City city, double distance){
            neighbors.put(city, distance);
        }

        public String getName() {
            return name;
        }

        public ArrayList<LinkedHashMap<City, Double>> listFoundedWays = new ArrayList<>();

        public String bestWayTo(City city){
            this.findWay(city, new LinkedHashMap<City, Double>(), new ArrayList<City>());
            LinkedHashMap<City, Double> best = listFoundedWays.get(0);
            double min = 0;
            for (Double d : listFoundedWays.get(0).values())
                min += d;

            for (LinkedHashMap<City, Double> tempWay : listFoundedWays){
                double temp = 0;
                for (Double d : tempWay.values())
                    temp += d;
                if (temp < min) {
                    best = tempWay;
                    min = temp;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getName());
            for (Map.Entry<City, Double> pair : best.entrySet()){
                stringBuilder.append(" --> ");
                stringBuilder.append(pair.getKey().getName());
            }
            stringBuilder.append("   : in ");
            stringBuilder.append(min);
            stringBuilder.append("km.");

            return stringBuilder.toString();
        }


        public void findWay(City destination, LinkedHashMap<City, Double> allWay, ArrayList<City> visited){
            visited.add(this);
            LinkedHashMap<City, Double> way;
            if (allWay.isEmpty()){
                way = new LinkedHashMap<>();
            } else {
                way = allWay;
            }

            for (Map.Entry<City, Double> pair : neighbors.entrySet()){
                if (!visited.contains(pair.getKey())){
                    way.put(pair.getKey(), pair.getValue());
                    if (destination.equals(pair.getKey())){
                        System.out.println("founded");
                        visited.get(0).listFoundedWays.add((LinkedHashMap<City, Double>)way.clone());
                        way.remove(pair.getKey());
                        continue;
                    } else {
                        pair.getKey().findWay(destination, way, visited);
                    }
                    way.remove(pair.getKey());
                }

            }
            visited.remove(this);

        }
    }
}
