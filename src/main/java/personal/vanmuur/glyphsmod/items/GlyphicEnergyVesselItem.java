package personal.vanmuur.glyphsmod.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GlyphicEnergyVesselItem extends Item {
    private int energyStored = 0; // Start with no energy

    public GlyphicEnergyVesselItem(Properties properties) {
        super(properties);
    }

    public int getEnergyStored() {
        return energyStored;
    }

    public void addEnergy(int energy) {
        this.energyStored += energy;
        // Clamp to a max energy value of 1000
        this.energyStored = Math.min(this.energyStored, 1000);
    }

    public void removeEnergy(int energy) {
        this.energyStored -= energy;
        // Ensure energy doesn't go negative
        this.energyStored = Math.max(this.energyStored, 0);
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).append(" - Energy: " + energyStored);
    }
}
