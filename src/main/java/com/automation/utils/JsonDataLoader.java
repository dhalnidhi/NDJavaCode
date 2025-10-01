package com.automation.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A utility class to read data from a JSON file and
 * provide it in a structured format for data-driven testing.
 * Requires the 'json-simple' library in the classpath.
 */
public class JsonDataLoader {

    /**
     * Reads a JSON file containing an array of user objects and converts the data
     * into a two-dimensional Object array. The number of columns in the array
     * is determined dynamically by the number of keys in the first JSON object.
     *
     * @param filePath The path to the JSON file.
     * @return A 2D Object array where each row contains the values from a JSON object.
     * @throws Exception If there is an error reading or parsing the file.
     */
    public static Object[][] getTestDataFromJsonFile(String filePath) throws Exception {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;

        try {
            // Step 1: Parse the file. The top-level element is expected to be an array.
            Object obj = parser.parse(new FileReader(filePath));
            jsonArray = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            // Handle case where the file is not found
            throw new FileNotFoundException("File not found at: " + filePath);
        }

        // Check if the JSON array is empty
        if (jsonArray.isEmpty()) {
            return new Object[0][0];
        }

        // Step 2: Dynamically determine the number of columns
        // Get the keys from the first JSON object to establish the order and count.
        JSONObject firstObject = (JSONObject) jsonArray.get(0);
        List<String> keys = new ArrayList<>(firstObject.keySet());
        Collections.sort(keys); // Sort the keys to ensure a consistent column order

        int numRows = jsonArray.size();
        int numCols = keys.size();
        Object[][] testData = new Object[numRows][numCols];

        // Step 3: Iterate through each object in the JSONArray
        for (int i = 0; i < numRows; i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

            // Step 4: Iterate through the sorted keys to extract values in a consistent order
            for (int j = 0; j < numCols; j++) {
                String key = keys.get(j);
                Object value = jsonObject.get(key);
                testData[i][j] = value;
            }
        }

        return testData;
    }

    /**
     * Main method to demonstrate the usage of getTestDataFromJsonFile.
     * Ensure the path to the login.json file is correct.
     */
    public static void main(String[] args) {
        // IMPORTANT: Replace this with the actual path to your login.json file.
        // For this example, let's assume 'login.json' is in the project root.

//        C:\Selenium\JavaSelenium_Aug25\src\main\java\com\automation\day7\JsonDataLoader.java
        String jsonFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\login.json";

        try {
            System.out.println("Attempting to load data from: " + jsonFilePath);
            Object[][] testUserCredentials = getTestDataFromJsonFile(jsonFilePath);

            System.out.println("Data successfully loaded. Contents:");
            System.out.println("------------------------------------");

            // Assuming a fixed structure for demonstration
            if (testUserCredentials.length > 0 && testUserCredentials[0].length >= 2) {
                System.out.println("Headers: userId, password");
                System.out.println("------------------------------------");
            }

            // Iterate and print the data from the 2D array
            for (int i = 0; i < testUserCredentials.length; i++) {
                System.out.print("Row " + (i + 1) + ": ");
                for (int j = 0; j < testUserCredentials[i].length; j++) {
                    System.out.print(testUserCredentials[i][j] + (j < testUserCredentials[i].length - 1 ? ", " : ""));
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
