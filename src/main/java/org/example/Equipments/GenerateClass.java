package org.example.Equipments;

import lombok.Getter;
import lombok.Setter;
import org.example.EquipmentsType.EquipType;
import org.example.EquipmentsType.GenerateType;

import java.util.Map;

@Getter
@Setter
public class GenerateClass extends Equipment {
    private GenerateType generateType;

    public GenerateClass(Map<String, String> equipment) {
        this.type = EquipType.GENERATE;
        this.name = equipment.get("name");
        this.voltageClass = Integer.parseInt(equipment.get("voltageClass"));
        this.generateType = GenerateType.valueOf(equipment.get("generateType"));
    }
}
