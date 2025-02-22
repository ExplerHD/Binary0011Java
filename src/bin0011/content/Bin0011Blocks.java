package bin0011.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.entities.bullet.*;
import mindustry.entities.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import bin0011.content.*;

import static mindustry.type.ItemStack.with;

public class Bin0011Blocks implements ContentList {
	public static Block 
		
		// ore
		oreItem00, oreItem10,
		// defense
		wall00, wallLarge00, wall01, wallLarge01, wall10, wallLarge10, wallHuge10,
		// power
		node000, node001, gen0000, gen0001, burner000, burner001, panel00, panel01, battery00, battery01,
		// turrets
		turret0000, turret0001, turret0010, turret0011, turret0100, turret0101, turret0110, turret0111, turret1000, turret1001,
		// production
		crafter0000, crafter0001, crafterLarge0000, crafterLarge0001, crafterLarge0010, crafterLarge0011,
		// unit factories
		binaryFactory;

	@Override
	public void load() {
		// reg ore
		oreItem00 = new OreBlock(Bin0011Items.item00);
		oreItem10 = new OreBlock(Bin0011Items.item10);
		// end ore
		// reg defense
		wall00 = new Wall("wall00") {{
			requirements(Category.defense, with(
				Bin0011Items.item00, 6
			));
			localizedName = "wall00";
			size = 1;
			health = 400;
		}};
		wallLarge00 = new Wall("wall-large00") {{
			requirements(Category.defense, with(
				Bin0011Items.item00, 12
			));
			localizedName = "wallLarge00";
			size = 2;
			health = 1600;
		}};
		wall01 = new Wall("wall01") {{
			requirements(Category.defense, with(
				Bin0011Items.item01, 6
			));
			localizedName = "wall01";
			size = 1;
			health = 500;
			insulated = true;
			absorbLasers = true;
		}};
		wallLarge01 = new Wall("wall-large01") {{
			requirements(Category.defense, with(
				Bin0011Items.item01, 12
			));
			localizedName = "wallLarge01";
			size = 2;
			health = 2500;
			insulated = true;
			absorbLasers = true;
		}};
		wall10 =  new Wall("wall10") {{
			requirements(Category.defense, with(Bin0011Items.item10, 6));
			localizedName = "wall10";
			size = 1;
			health = 175 * 4;
			chanceDeflect = 25f;
            		flashHit = true;
		}};
		wallLarge10 =  new Wall("wall-large10") {{
			requirements(Category.defense, with(Bin0011Items.item10, 6));
			localizedName = "wallLarge10";
			size = 2;
			health = 350 * 4;
			chanceDeflect = 35f;
            		flashHit = true;
		}};
		wallHuge10 =  new Wall("wall-huge10") {{
			requirements(Category.defense, with(Bin0011Items.item10, 6));
			localizedName = "wallHuge10";
			size = 3; //bjirrr
			health = 525 * 4;
			chanceDeflect = 35f;
            		flashHit = true;
			insulated = true;
			absorbLasers = true; // bjirr
		}};
		// end defense
		// reg power
		node000 = new PowerNode("node000") {{
			requirements(Category.power, with(
				Bin0011Items.item00, 1,
				Bin0011Items.item01, 2
			));
			localizedName = "node000";
			health = 135;
			maxNodes = 25;
			laserRange = 19f;
		}};
		node001 = new PowerNode("node001") {{
			requirements(Category.power, with(
				Bin0011Items.item00, 4,
				Bin0011Items.item01, 8
			));
			localizedName = "node001";
			health = 270;
			maxNodes = 35;
			laserRange = 120f;
			size = 2;
		}};
		gen0000 = new SingleTypeGenerator("gen0000") {{
			requirements(Category.power, with(Bin0011Items.item00, 60, Bin0011Items.item01, 45, Bin0011Items.item10, 30));
			localizedName = "gen0000";
			health = 750;
			powerProduction = 4.2f;
			itemDuration = 240f;
			hasItems = true;
			size = 2;
			ambientSound = Sounds.steam;
			ambientSoundVolume = 0.03f;
			heatColor = Color.valueOf("FFFFFF47");
			consumes.item(Bin0011Items.item10);
		}};
		gen0001 = new SingleTypeGenerator("gen0001") {{
			requirements(Category.power, with(Bin0011Items.item00, 75, Bin0011Items.item01, 60, Bin0011Items.item10, 35, Bin0011Items.item11, 40));
			localizedName = "gen0001";
			health = 900;
			powerProduction = 7.5f;
			itemDuration = 240f;
			hasItems = true;
			hasLiquids = true;
			size = 3;
			ambientSound = Sounds.steam;
			ambientSoundVolume = 0.03f;
			heatColor = Color.valueOf("FFFFFF44");
			consumes.item(Bin0011Items.item10);
			consumes.liquid(Liquids.water, 0.1f);
		}};
		burner000 = new BurnerGenerator("burner000") {{
			requirements(Category.power, with(Bin0011Items.item00, 28, Bin0011Items.item01, 15));
			localizedName = "burner000";
			health = 185;
			powerProduction = 1.2f;
			itemDuration = 200f;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.04f;
			size = 2;
		}};
		burner001 = new BurnerGenerator("burner001") {{
			requirements(Category.power, with(Bin0011Items.item00, 35, Bin0011Items.item01, 24));
			localizedName = "burner001";
			health = 200;
			powerProduction = 1.4f;
			itemDuration = 240f;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.03f;
			size = 2;
	 	 	heatColor = Color.valueOf("FFFFFF77");
		}};
		panel00 = new SolarGenerator("panel00") {{
			requirements(Category.power, with(Bin0011Items.item00, 65, Bin0011Items.item01, 40, Bin0011Items.item10, 55));
			localizedName = "panel00";
			health = 175 * size * size;
			size = 2;
			powerProduction = 0.65f;
		}};
		panel01 = new SolarGenerator("panel01") {{
			requirements(Category.power, with(Bin0011Items.item00, 100, Bin0011Items.item01, 65, Bin0011Items.item10, 70));
			localizedName = "panel01";
			health = 200 * size * size;
			size = 3;
			powerProduction = 1.42f;
		}};
		battery00 = new Battery("battery00") {{
			requirements(Category.power, with(Bin0011Items.item00, 4, Bin0011Items.item01, 18));
			localizedName = "battery00";
			consumes.powerBuffered(4250f);
			baseExplosiveness = 2.5f;
		}};
		battery01 = new Battery("battery01") {{
			requirements(Category.power, with(Bin0011Items.item00, 12, Bin0011Items.item01, 54, Bin0011Items.item11, 20));
			consumes.powerBuffered(58000f);
			localizedName = "battery01";
			baseExplosiveness = 5f;
			size = 3;
		}};
		// reg turret
		turret0000 = new ItemTurret("turret0000"){{
			requirements(Category.turret, with(Bin0011Items.item00, 28), true);
            		ammo(
				Bin0011Items.item00, Bullets.standardCopper,
				Bin0011Items.item01, Bullets.standardHoming,
				Bin0011Items.item11, Bullets.missileSurge
            		);
			localizedName = "turret0000";
            		spread = 4f;
           		shots = 2;
          		alternate = true;
           		reloadTime = 17.5f;
           		restitution = 0.03f;
           		range = 152;
           		shootCone = 15f;
           		ammoUseEffect = Fx.casing1;
           		health = 250;
           	 	inaccuracy = 2f;
           		rotateSpeed = 10f;

            		limitRange(0f);
        	}};
        	turret0001 = new ItemTurret("turret0001"){{
            		requirements(Category.turret, with(Bin0011Items.item00, 32, Bin0011Items.item01, 15));
            		ammo(
				Bin0011Items.item00, Bullets.artilleryDense,
				Bin0011Items.item01, Bullets.artilleryHoming
			);
			localizedName = "turret0001";
            		targetAir = false;
            		reloadTime = 50f;
            		recoilAmount = 1f;
           	 	range = 256f;
            		inaccuracy = 0f;
            		shootCone = 10f;
            		health = 325;
            		shootSound = Sounds.bang;
            		limitRange(0f);
        	}};
		turret0010 = new PowerTurret("turret0010"){{
			requirements(Category.turret, with(Bin0011Items.item00, 75, Bin0011Items.item01, 45, Bin0011Items.item10, 30));
            		localizedName = "turret0010";
			range = 192f;
            		chargeTime = 40f;
            		chargeMaxDelay = 25f;
            		chargeEffects = 9;
            		recoilAmount = 1.5f;
            		reloadTime = 50f;
            		cooldown = 0.05f;
            		powerUse = 4.7f;
            		shootShake = 2f;
            		shootEffect = Fx.shootBig;
            		smokeEffect = Fx.smokeCloud;
            		chargeEffect = Fx.none;
            		chargeBeginEffect = Fx.none;
            		size = 2;
            		health = 290 * size * size;
            		targetAir = true;
            		shootSound = Sounds.laser;
			
			shootType = new LaserBulletType(140){{
                		colors = new Color[]{Pal.darkestGray.a(1f), Pal.darkishGray, Color.white};
                		hitEffect = Fx.hitLancer;
                		hitSize = 6;
                		lifetime = 18f;
                		drawSize = 400f;
                		collidesAir = true;
                		length = 192f;
                		ammoMultiplier = 2f;
            		}};
        	}};
        	turret0011 = new TractorBeamTurret("turret0011"){{
            		requirements(Category.turret, with(Bin0011Items.item00, 100, Bin0011Items.item01, 70, Bin0011Items.item10, 45));

			localizedName = "turret0011";
            		hasPower = true;
            		size = 2;
            		force = 24f;
            		scaledForce =12f;
            		range = 360f;
            		damage = 1f;
            		health = 160 * size * size;
            		rotateSpeed = 10;

            		consumes.powerCond(3.5f, (TractorBeamBuild e) -> e.target != null);
		}};
        	turret0100 = new ItemTurret("turret0100"){{
            		requirements(Category.turret, with(Bin0011Items.item00, 250, Bin0011Items.item01, 75, Bin0011Items.item11, 57));
            		ammo(
				Bin0011Items.item00, Bullets.standardThorium,
				Bin0011Items.item01, Bullets.standardDenseBig,
				Bin0011Items.item10, Bullets.standardIncendiaryBig,
				Bin0011Items.item11, Bullets.standardThoriumBig
			);
			localizedName = "turret0100";
            		targetAir = true;
            		reloadTime = 78f;
			shots = 7;
            		recoilAmount = 1f;
			size = 3;
           	 	range = 192f;
            		inaccuracy = 0f;
            		shootCone = 10f;
            		health = 325 * size * size;
            		limitRange(0f);
			heatColor = Color.valueOf("FFFFFF55");
        	}};
        	turret0101 = new ItemTurret("turret0101") {{
            		requirements(Category.turret, with(
				Bin0011Items.item00, 250, 
				Bin0011Items.item01, 175, 
				Bin0011Items.item11, 100
			));
            		ammo(
				Bin0011Items.item01, Bullets.missileExplosive,
				Bin0011Items.item10, Bullets.missileIncendiary,
				Bin0011Items.item11, Bullets.missileSurge
			);
			localizedName = "turret0101";
            		targetAir = true;
            		reloadTime = 3.5f;
			shots = 2;
            		recoilAmount = 1f;
			size = 2;
           	 	range = 250f;
            		inaccuracy = 0f;
            		shootCone = 10f;
            		health = 400 * size * size;
            		limitRange(0f);
        	}};
		turret0110 = new PowerTurret("turret0110"){{
			requirements(Category.turret, with(Bin0011Items.item00, 40, Bin0011Items.item01, 32));
			shootType = new LightningBulletType(){{
				damage = 35;
				lightningLength = 38;
				collidesAir = true;
				ammoMultiplier = 1f;
		}};
			localizedName = "turret0110";
	 		reloadTime = 30f;
			shootCone = 40f;
			rotateSpeed = 10f;
			powerUse = 3.4f;
			targetAir = true;
			range = 180f;
			shootEffect = Fx.lightningShoot;
			recoilAmount = 1f;
			size = 2;
			health = 520;
			shootSound = Sounds.spark;
		}};
		turret0111 = new PointDefenseTurret("turret0111"){{
			requirements(Category.turret, with(Bin0011Items.item00, 55, Bin0011Items.item01, 35));
			health = 10 * size * size;
			range = 360f;
			hasPower = true;
			consumes.powerCond(6.7f, (PointDefenseBuild b) -> b.target != null);
			size = 1;
	 	 	shootLength = 5f;
	 	 	bulletDamage = 30f;
	 	 	reloadTime = 0.1f;
			localizedName = "turret0111";
		}};
		turret1000 /* anjai 1000 */ = new ItemTurret("turret1000"){{
			requirements(Category.turret, with(Bin0011Items.item00, 200, Bin0011Items.item01, 175, Bin0011Items.item10, 80, Bin0011Items.item11, 135));
			health = 200 * size * size;
			localizedName = "turret1000";
			size = 3;
			targetAir = false;
            		reloadTime = 30f;
            		recoilAmount = 2f;
            		range = 235f;
            		inaccuracy = 1f;
            		shootCone = 10f;
            		limitRange(0f);
			shots = 2;
			rotateSpeed = 7.5f;
			shootSound = Sounds.bang;
			
			ammo(
				Bin0011Items.item00, new ArtilleryBulletType(){{
					hitEffect = Fx.flakExplosion;
					speed = 6.5f;
					knockback = 1f;
					lifetime = 80f;
					width = height = 11f;
					collidesTiles = false;
					splashDamageRadius = 30f * 0.75f;
					splashDamage = 45f;
				}},
				Bin0011Items.item01, new ArtilleryBulletType(){{
					hitEffect = Fx.flakExplosion;
            				knockback = 0.8f;
					speed = 6.8f;
            				lifetime = 80f;
            				width = height = 11f;
            				collidesTiles = false;
            				splashDamageRadius = 25f * 0.75f;
            				splashDamage = 54f;
            				reloadMultiplier = 1.2f;
            				ammoMultiplier = 3f;
            				homingPower = 1f;
            				homingRange = 50f;
				}},
				Bin0011Items.item10, new ArtilleryBulletType(){{
					hitEffect = Fx.blastExplosion;
            				knockback = 0.8f;
					speed = 7.2f;
            				lifetime = 80f;
            				width = height = 14f;
            				collidesTiles = false;
            				ammoMultiplier = 4f;
            				splashDamageRadius = 45f * 0.75f;
            				splashDamage = 55f;
            				backColor = Color.valueOf("ffffff");
            				frontColor = Pal.darkishGray;

            				status = StatusEffects.shocked;
				}}
			);
		}}; // iya, gw bikin code shoot types barengan sama turret, gw males
        	turret1001 = new ItemTurret("turret1001") {{
            		requirements(Category.turret, with(
				Bin0011Items.item00, 300, 
				Bin0011Items.item01, 275, 
				Bin0011Items.item10, 195,
				Bin0011Items.item11, 75
			));
			health = 275 * size * size;
			localizedName = "turret1001";
			size = 3;
			targetAir = true;
            		reloadTime = 6f;
            		recoilAmount = 2f;
			restitution = 0.15f;
            		range = 240f;
            		inaccuracy = 2f;
            		shootCone = 10f;
            		limitRange(0f);
			shots = 3;
			rotateSpeed = 12f;
			heatColor = Color.valueOf("FFFFFF55");
			shootSound = Sounds.missile;
            		ammo(
				Bin0011Items.item00, new MissileBulletType(4f, 11){{
            	 	 		width = 10f;
            				height = 10f;
            				shrinkY = 0f;
            				splashDamageRadius = 35f;
            				splashDamage = 58f * 1.5f;
            				ammoMultiplier = 6f;
            				hitEffect = Fx.blastExplosion;
            				despawnEffect = Fx.blastExplosion;
            				lightningDamage = 10;
            				lightning = 3;
            				lightningLength = 10;
            				status = StatusEffects.unmoving;
            				statusDuration = 240f;
        			}},
				Bin0011Items.item01, new MissileBulletType(4f, 11){{
            	 	 		width = 10f;
            				height = 10f;
            				shrinkY = 0f;
            				splashDamageRadius = 37.5f;
            				splashDamage = 65f * 1.5f;
            				ammoMultiplier = 6f;
            				hitEffect = Fx.blastExplosion;
            				despawnEffect = Fx.blastExplosion;
            				lightningDamage = 15;
            				lightning = 3;
            				lightningLength = 10;
            				status = StatusEffects.unmoving;
            				statusDuration = 240f;
        			}}
			);
        	}};
		// end turret
		// reg production
		crafter0000 = new GenericCrafter("mcrft0000") {{
			requirements(Category.crafting, with(
				Items.copper, 35,
				Items.lead, 12
			));
			size = 2;
			localizedName = "crafter0000";
			health = 145 * size * size;
			itemCapacity = 25;
			craftTime = 90f;
			craftEffect = Fx.smelt;
			consumes.items(with(
				Items.copper, 1,
				Items.coal, 1
			));
			outputItem = new ItemStack(Bin0011Items.item00, 1);
		}};
		crafter0001 = new GenericCrafter("mcrft0001") {{
			requirements(Category.crafting, with(
				Items.copper, 50,
				Items.graphite, 30,
				Items.lead, 45
			));
			size = 2;
			localizedName = "crafter0001";
			health = 150 * size * size;
			itemCapacity = 25;
			craftTime = 90f;
			craftEffect = Fx.smokeCloud;
			consumes.items(with(
				Items.copper, 1,
				Items.lead, 2,
				Items.metaglass, 1
			));
			outputItem = new ItemStack(Bin0011Items.item01, 1);
		}};
		crafterLarge0000 = new GenericCrafter("crft0000") {{
			requirements(Category.crafting, with(
				Items.copper, 60,
				Items.lead, 35
			));
			size = 3;
			localizedName = "crafterLarge0000";
			health = 280 * size * size;
			itemCapacity = 50;
			craftTime = 60f;
			craftEffect = Fx.smelt;
			drawer = new DrawSmelter(Color.valueOf("FFFFFF"));
			consumes.items(with(
				Items.copper, 2,
				Items.coal, 1
			));
			consumes.power(1.2f);
			outputItem = new ItemStack(Bin0011Items.item00, 2);
		}};
		crafterLarge0001 = new GenericCrafter("crft0001") {{
			requirements(Category.crafting, with(
				Items.copper, 45,
				Items.lead, 25,
				Items.silicon, 15
			));
			size = 3;
			localizedName = "crafterLarge0001";
			health = 290 * size * size;
			itemCapacity = 50;
			craftTime = 60f;
			craftEffect = Fx.smelt;
			drawer = new DrawSmelter(Color.valueOf("FFFFFF"));
			consumes.items(with(
				Items.copper, 2,
				Items.metaglass, 1,
				Items.lead, 1
			));
			consumes.power(1.3f);
			outputItem = new ItemStack(Bin0011Items.item01, 2);
		}};
		crafterLarge0010 = new GenericCrafter("crft0010") {{
			requirements(Category.crafting, with(
				Items.copper, 60,
				Items.lead, 45,
				Items.silicon, 40,
				Items.titanium, 35
			));
			size = 3;
			localizedName = "crafterLarge0010";
			health = 300 * size * size;
			itemCapacity = 65;
			craftTime = 45f;
			craftEffect = Fx.smokeCloud;
			consumes.items(with(
				Items.graphite, 2,
				Items.titanium, 1
			));
			consumes.power(1.4f);
			outputItem = new ItemStack(Bin0011Items.item10, 2);
		}};
		crafterLarge0011 = new GenericCrafter("crft0011") {{
			requirements(Category.crafting, with(
				Items.copper, 85,
				Items.silicon, 75,
				Items.titanium, 50
			));
			size = 3;
			localizedName = "crafterLarge0011";
			health = 325 * size * size;
			itemCapacity = 65;
			craftTime = 45f;
			craftEffect = Fx.smokeCloud;
			consumes.items(with(
				Items.titanium, 2,
				Items.silicon, 1
			));
			consumes.power(1.5f);
			outputItem = new ItemStack(Bin0011Items.item11, 2);
		}};
		// end production
		// reg unit factories
		binaryFactory = new UnitFactory("binary-factory") {{
			requirements(Category.units, with(
				Items.copper, 120,
				Items.lead, 75
			));
			size = 3;
			health = 300;
			consumes.power(1.05f);
			plans = Seq.with(
				new UnitPlan(Bin0011UnitTypes.guram, 60f * 7f, with(Bin0011Items.item00, 15))
			);
		}};
	}
}
