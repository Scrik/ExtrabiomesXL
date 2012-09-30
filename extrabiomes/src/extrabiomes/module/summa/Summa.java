/**
 * This work is licensed under the Creative Commons
 * Attribution-ShareAlike 3.0 Unported License. To view a copy of this
 * license, visit http://creativecommons.org/licenses/by-sa/3.0/.
 */

package extrabiomes.module.summa;

import extrabiomes.Extrabiomes;
import extrabiomes.IModule;
import extrabiomes.api.BiomeManager;
import extrabiomes.configuration.ExtrabiomesConfig;
import extrabiomes.module.summa.biome.BiomeManagerImpl;
import extrabiomes.module.summa.block.Cube;
import extrabiomes.module.summa.worldgen.MarshGenerator;
import extrabiomes.module.summa.worldgen.MountainDesertGenerator;
import extrabiomes.module.summa.worldgen.MountainRidgeGenerator;
import extrabiomes.module.summa.worldgen.VanillaFloraGenerator;

public class Summa implements IModule {

	private static BiomeManagerImpl	biomeManager	= new BiomeManagerImpl();

	private static void registerWorldGenerators() {
		if (BiomeManager.marsh.isPresent())
			Extrabiomes.proxy
					.registerWorldGenerator(new MarshGenerator());

		if (BiomeManager.mountaindesert.isPresent())
			Extrabiomes.proxy
					.registerWorldGenerator(new MountainDesertGenerator());

		if (BiomeManager.mountainridge.isPresent())
			Extrabiomes.proxy
					.registerWorldGenerator(new MountainRidgeGenerator());

		Extrabiomes.proxy
				.registerWorldGenerator(new VanillaFloraGenerator());
	}

	@Override
	public void init() throws InstantiationException, IllegalAccessException {

		registerWorldGenerators();

		biomeManager.init();
		Cube.init();
	}

	@Override
	public void preInit(ExtrabiomesConfig config)
			throws InstantiationException, IllegalAccessException
	{
		biomeManager.preInit(config);
		Cube.preInit(config);
	}

}
