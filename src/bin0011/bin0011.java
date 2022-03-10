package bin0011;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

import bin0011.content.*;

public class bin0011 extends Mod{
	public bin0011(){
                Log.info("Loaded ExampleJavaMod constructor.");

                //listen for game load event
                Events.on(ClientLoadEvent.class, e -> {
                //show dialog upon startup
                        Time.runTask(10f, () -> {
				BaseDialog dialog = new BaseDialog("icon");
				dialog.cont.add("Welcome to Binary0011.").row();
				dialog.cont.image(Core.atlas.find("binary0011-icon")).pad(10f).row();
				dialog.cont.button("OK", dialog::hide).size(100f, 50f);
				dialog.show();
                 	});
            	});
        }
	// load mod content
	@Override
	public void loadContent(){
	 	new Bin0011Liquids().load();
		new Bin0011Items().load();
		new Bin0011Blocks().load();
		new Bin0011Planets().load();
		new Bin0011TechTree().load();
	}
}
