package com.decagon.utils;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.decagon.entity.Product;

public class StoreCSV {
    private static final String filePath = "src/main/resources/STORE.csv";
    private volatile static Vector<Product> productsFromCSV = new Vector<>();
    private static void readFromStore() {

        try{
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                productsFromCSV.add(
                        new Product(row[0],row[1],Integer.parseInt(row[2]),Double.parseDouble(row[3]),
                                Double.parseDouble(row[4]),row[5]));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateStoreCSV(String replace,
                                      int row, int col) throws IOException, CsvException {
        File inputFile = new File(filePath);
        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile));
        List<String[]> csvBody = reader.readAll();
        // get StoreCSV row column  and replace with by using row and column
        csvBody.get(row)[col] = replace;
        reader.close();

        // Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
    }

    public static Vector<Product> getProductsFromCSV(){
        readFromStore();
        return productsFromCSV;
    }

}
