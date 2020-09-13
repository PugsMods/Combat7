package com.putopug.combat7.init.items;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.SoundEvent;

import java.util.function.Supplier;

public class ModMusicDisc extends MusicDiscItem {
    public ModMusicDisc(int comparatorValue, Supplier<SoundEvent> soundSupplier, Properties builder) {
        super(comparatorValue, soundSupplier, builder);
    }
}
