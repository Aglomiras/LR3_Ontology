package org.example.Equipments;

import lombok.Getter;
import lombok.Setter;
import org.example.EquipmentsType.EquipType;
import org.example.EquipmentsType.TransformerType;

import java.util.Map;

@Getter
@Setter
public class TransformerClass extends Equipment {
    private TransformerType transformerType;
    private int power;
    private boolean parallel;

    public TransformerClass(Map<String, String> equipment) {
        this.type = EquipType.TRANSFORMER;
        this.name = equipment.get("name");
        this.power = Integer.parseInt(equipment.get("power"));
        this.parallel = Boolean.parseBoolean(equipment.get("parallel"));
        this.voltageClass = Integer.parseInt(equipment.get("voltageClass"));
        this.transformerType = TransformerType.valueOf(equipment.get("transformerType"));
    }
}
