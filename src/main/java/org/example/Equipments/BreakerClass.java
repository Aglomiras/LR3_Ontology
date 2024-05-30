package org.example.Equipments;

import lombok.Getter;
import lombok.Setter;
import org.example.EquipmentsType.BreakerType;
import org.example.EquipmentsType.EquipType;

import java.util.Map;

@Getter
@Setter
public class BreakerClass extends Equipment {
    private BreakerType breakerType;
    private boolean position;

    public BreakerClass(Map<String, String> equipment) {
        this.type = EquipType.BREAKER;
        this.name = equipment.get("name");
        this.voltageClass = Integer.parseInt(equipment.get("voltageClass"));
        this.breakerType = BreakerType.valueOf(equipment.get("breakerType"));
        this.position = Boolean.parseBoolean(equipment.get("position"));
    }

}
