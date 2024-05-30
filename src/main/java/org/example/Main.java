package org.example;

import org.example.ConfigFiles.DRLConfig;
import org.example.Equipments.Equipment;
import org.kie.api.runtime.StatelessKieSession;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StatelessKieSession kieSession = DRLConfig.kieSession;

        List<Equipment> equipmentList = Builder.configuration();

        for (Equipment equipment : equipmentList) {
            kieSession.execute(equipment);
        }

        equipmentList.forEach(e -> {
            System.out.println("Оборудование: " + e.getType() + " - " + e.getName() + "\nЗащиты объекта: " + e.getAddProtection() + "\n");
        });
    }
}