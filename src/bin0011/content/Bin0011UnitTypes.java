package bin0011.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import mindustry.ai.types.*;
import mindustry.ctype.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;
import bin0011.content.*;

public class Bin0011UnitTypes implements ContentList{
        public static UnitType
                guram;
	@Override
	public void load() {
		guram = new UnitType("guram"){{
			localizedName = "Guram";
	 	 	speed = 0.67f;
            	 	drag = 0.4f;
		        hitSize = 13f;
		        flying = false;
            	 	rotateSpeed = 4.5f;
            	 	health = 600;
	 	 	legCount = 4;
            	 	legLength = 10f;
            	 	legTrns = 0.6f;
            	 	legMoveSpace = 1.4f;
            	 	hovering = true;
            	 	armor = 4f;
            	 	visualElevation = 0.3f;
	 	 	groundLayer = Layer.legUnit - 1f;
		}};
	}
}
