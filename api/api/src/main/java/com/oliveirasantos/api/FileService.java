package com.oliveirasantos.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.time.LocalDateTime;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private static final String FILE_PATH = "historico_consultas.json";
    private Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
        .setPrettyPrinting()
        .create();

    public void saveHistory(Consulta consulta) throws JsonSyntaxException {
        List<Consulta> consultas = loadHistory();
        consultas.add(consulta);
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(consultas, writer);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Consulta> loadHistory() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Consulta>>() {}.getType();
            List<Consulta> consultas = gson.fromJson(reader, listType);
            return consultas != null ? consultas : new ArrayList<>();
        } catch (IOException e) {
            System.err.println(" Error reading from file: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveDataToFile(String data){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Data.txt"));
            writer.write(data);
            writer.close();
            System.out.println("Data saved successfully");
        }catch(IOException e){
            System.out.println("Error saving data to file: "+e.getMessage());
        }
    }
}