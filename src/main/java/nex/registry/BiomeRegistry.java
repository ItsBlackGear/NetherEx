package nex.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import nex.api.world.biome.INetherBiome;
import nex.api.world.biome.NEXBiomes;
import nex.world.WorldProviderNether;
import nex.world.biome.*;

import java.util.Set;

public class BiomeRegistry implements NEXBiomes.Registry
{
    private static Set<BiomeManager.BiomeEntry> biomes = Sets.newHashSet();

    public static void init()
    {
        NEXBiomes.hell = new BiomeHell();

        DimensionManager.unregisterDimension(-1);
        DimensionType nether = DimensionType.register("Nether", "_nether", -1, WorldProviderNether.class, false);
        DimensionManager.registerDimension(-1, nether);
    }

    @Override
    public Biome addBiome(INetherBiome biome)
    {
        if(biome == null)
        {
            throw new IllegalArgumentException("Biome to be added must not be null");
        }

        biomes.add(new BiomeManager.BiomeEntry(biome.getBiome(), 10));
        return biome.getBiome();
    }

    public static ImmutableList<BiomeManager.BiomeEntry> getBiomes()
    {
        return ImmutableList.copyOf(biomes);
    }
}