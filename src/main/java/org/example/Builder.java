package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Equipments.*;
import org.example.EquipmentsType.EquipType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Builder {
    public static List<Equipment> configuration() {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> equipments;
        List<Equipment> resEquipment = new ArrayList<>();

        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/configuration.json")));
            equipments = mapper.readValue(json, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Map<String, String> equipment : equipments) {
            switch (EquipType.valueOf(equipment.get("type"))) {
                case GENERATE -> resEquipment.add(new GenerateClass(equipment));
                case TRANSFORMER -> resEquipment.add(new TransformerClass(equipment));
                case BREAKER -> resEquipment.add(new BreakerClass(equipment));
                case BUS -> resEquipment.add(new BusClass(equipment));
                case LINE -> resEquipment.add(new LineClass(equipment));
            }
        }
        return resEquipment;
    }
}
