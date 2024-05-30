package org.example.Equipments;

import lombok.Getter;
import lombok.Setter;
import org.example.EquipmentsType.BusType;
import org.example.EquipmentsType.EquipType;

import java.util.Map;

@Getter
@Setter
public class BusClass extends Equipment {
    private BusType busType;

    public BusClass(Map<String, String> equipment) {
        this.type = EquipType.BUS;
        this.name = equipment.get("name");
        this.voltageClass = Integer.parseInt(equipment.get("voltageClass"));
        this.busType = BusType.valueOf(equipment.get("busType"));
    }
}
