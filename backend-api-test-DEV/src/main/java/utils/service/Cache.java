package utils.service;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    public static ConcurrentHashMap<String, ServiceCache> chamadas = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, String> valores = new ConcurrentHashMap<>();
    public static String tokenSkyHub;
    public static Faker faker = new Faker(new Locale("pt-BR"));
}
