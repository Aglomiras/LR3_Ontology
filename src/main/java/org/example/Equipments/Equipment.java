package org.example.Equipments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.EquipmentsType.EquipType;
import org.example.Protections.ProtectionAndAutomatic;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Equipment {
    protected EquipType type;
    protected int voltageClass;
    protected String name;
    protected List<ProtectionAndAutomatic> addProtection = new ArrayList<>();
    public void addProtection(ProtectionAndAutomatic protection) {
        if (!addProtection.contains(protection)){
            this.addProtection.add(protection);
        }
    }
}
