package com.example.listeners_filters.utils;

import java.util.Arrays;

public class Comprobate  {
public static boolean verifyValuesInParameter(String[] valuesInPack){
    return Arrays.stream(valuesInPack).anyMatch(x-> x.equalsIgnoreCase(""));
}
}
