package org.example.Equipments;

import lombok.Getter;
import lombok.Setter;
import org.example.EquipmentsType.EquipType;
import org.example.EquipmentsType.LineType;

import java.util.Map;

@Getter
@Setter
public class LineClass extends Equipment {
    private LineType lineType;
    public int length;

    public LineClass(Map<String, String> equipment) {
        this.type = EquipType.LINE;
        this.name = equipment.get("name");
        this.voltageClass = Integer.parseInt(equipment.get("voltageClass"));
        this.lineType = LineType.valueOf(equipment.get("lineType"));
        this.length = Integer.parseInt(equipment.get("length"));
    }
}
