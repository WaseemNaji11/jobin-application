package com.example.job_application.models;

import java.util.List;
import java.util.Map;

public class CountryDetailedInfo {

    public static class Name {
        public String common;
        public String official;
        public Map<String, Map<String, String>> nativeName;
    }

    public static class Currency {
        public String name;
        public String symbol;
    }

    public static class Idd {
        public String root;
        public List<String> suffixes;
    }

    public static class Languages {
        public String rus;
        public String uzb;
    }

    public static class Translations {
        public Map<String, String> ara;
        public Map<String, String> bre;
        // Add other translation fields as needed
    }

    public static class Demonyms {
        public Map<String, String> eng;
        public Map<String, String> fra;
        // Add other demonym fields as needed
    }

    public static class Maps {
        public String googleMaps;
        public String openStreetMaps;
    }

    public static class Flags {
        public String png;
        public String svg;
        public String alt;
    }

    public static class CoatOfArms {
        public String png;
        public String svg;
    }

    public static class CapitalInfo {
        public List<Double> latlng;
    }

    public static class PostalCode {
        public String format;
        public String regex;
    }

    public String status;
    public boolean unMember;
    public String region;
    public String subregion;
    public Name name;
    public List<String> tld;
    public String cca2;
    public String ccn3;
    public String cca3;
    public String cioc;
    public boolean independent;
    public Currency currencies;
    public Idd idd;
    public List<String> capital;
    public List<String> altSpellings;
    public Languages languages;
    public Translations translations;
    public List<Double> latlng;
    public boolean landlocked;
    public List<String> borders;
    public double area;
    public Demonyms demonyms;
    public String flag;
    public Maps maps;
    public int population;
    public Map<String, Double> gini;
    public String fifa;
    public Car car;
    public List<String> timezones;
    public List<String> continents;
    public Flags flags;
    public CoatOfArms coatOfArms;
    public String startOfWeek;
    public CapitalInfo capitalInfo;
    public PostalCode postalCode;

    public static class Car {
        public List<String> signs;
        public String side;
    }
}