package com.example.dummydatabases;

import com.example.model.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by odzhara-ongom on 01.02.2016.
 */
public class ReferenceDatabase {

    public static Random random = new Random();

    public static String randomNumericString(int n) {
        String result = "" + (new Date()).getTime();
        for (int i = 0; i < n; i++) {
            result += random.nextInt(10);
        }
        return result;
    }
    private static List<Reference> allReference = new ArrayList<>();

    private static void addReference(String name, String description) {
        Reference reference = new Reference(name, description);
        reference.setId(randomNumericString(15));
        allReference.add(reference);
    }

    public static List<Reference> getAllReference() {
        addReference("Vanille dea Oerba", "Final Fantasy XXIII");
        addReference("Clair Farron", "Final Fantasy XXIII");
        addReference("Shepard", "Mass Effect 1-3");
        return allReference;
    }

    public static void setAllReference(List<Reference> allReference) {
        ReferenceDatabase.allReference = allReference;
    }
}
