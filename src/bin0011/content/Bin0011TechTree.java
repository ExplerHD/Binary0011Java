package bin0011.content;

import arc.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static bin0011.content.Blocks.*;
import static bin0011.content.*;

public class Bin0011TechTree implements ContentList{
    static ObjectMap<UnlockableContent, TechNode> map = new ObjectMap<>();
    static TechNode context = null;

    public static Seq<TechNode> all;
    public static TechNode root;

    public static void setup(){
        context = null;
        map = new ObjectMap<>();
        all = new Seq<>();
    }

    //all the "node" methods are hidden, because they are for internal context-dependent use only
    //for custom research, just use the TechNode constructor

    static TechNode node(UnlockableContent content, Runnable children){
        return node(content, content.researchRequirements(), children);
    }

    static TechNode node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        return node(content, requirements, null, children);
    }

    static TechNode node(UnlockableContent content, ItemStack[] requirements, Seq<Objective> objectives, Runnable children){
        TechNode node = new TechNode(context, content, requirements);
        if(objectives != null){
            node.objectives.addAll(objectives);
        }

        TechNode prev = context;
        context = node;
        children.run();
        context = prev;

        return node;
    }

    static TechNode node(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        return node(content, content.researchRequirements(), objectives, children);
    }

    static TechNode node(UnlockableContent block){
        return node(block, () -> {});
    }

    static TechNode nodeProduce(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        return node(content, content.researchRequirements(), objectives.and(new Produce(content)), children);
    }

    static TechNode nodeProduce(UnlockableContent content, Runnable children){
        return nodeProduce(content, new Seq<>(), children);
    }

    @Nullable
    public static TechNode get(UnlockableContent content){
        return map.get(content);
    }

    public static TechNode getNotNull(UnlockableContent content){
        return map.getThrow(content, () -> new RuntimeException(content + " does not have a tech node"));
    }

    public static class TechNode{
        /** Depth in tech tree. */
        public int depth;
        /** Requirement node. */
        public @Nullable TechNode parent;
        /** Content to be researched. */
        public UnlockableContent content;
        /** Item requirements for this content. */
        public ItemStack[] requirements;
        /** Requirements that have been fulfilled. Always the same length as the requirement array. */
        public ItemStack[] finishedRequirements;
        /** Extra objectives needed to research this. */
        public Seq<Objective> objectives = new Seq<>();
        /** Nodes that depend on this node. */
        public final Seq<TechNode> children = new Seq<>();

        public TechNode(@Nullable TechNode parent, UnlockableContent content, ItemStack[] requirements){
            if(parent != null) parent.children.add(this);

            this.parent = parent;
            this.content = content;
            this.depth = parent == null ? 0 : parent.depth + 1;
            setupRequirements(requirements);

            var used = new ObjectSet<Content>();

            //add dependencies as objectives.
            content.getDependencies(d -> {
                if(used.add(d)){
                    objectives.add(new Research(d));
                }
            });

            map.put(content, this);
            all.add(this);
        }

        public void setupRequirements(ItemStack[] requirements){
            this.requirements = requirements;
            this.finishedRequirements = new ItemStack[requirements.length];

            //load up the requirements that have been finished if settings are available
            for(int i = 0; i < requirements.length; i++){
                finishedRequirements[i] = new ItemStack(requirements[i].item, Core.settings == null ? 0 : Core.settings.getInt("req-" + content.name + "-" + requirements[i].item.name));
            }
        }

        /** Resets finished requirements and saves. */
        public void reset(){
            for(ItemStack stack : finishedRequirements){
                stack.amount = 0;
            }
            save();
        }

        /** Removes this node from the tech tree. */
        public void remove(){
            all.remove(this);
            if(parent != null){
                parent.children.remove(this);
            }
        }

        /** Flushes research progress to settings. */
        public void save(){

            //save finished requirements by item type
            for(ItemStack stack : finishedRequirements){
                Core.settings.put("req-" + content.name + "-" + stack.item.name, stack.amount);
            }
        }

    @Override
    public void load(){
        setup();

        root = node(Bin0011IItems.item00, () -> {
            nodeProduce(Bin0011Items.item01, () -> {
                nodeProduce(Bin0011Items.item10, () -> {
                    nodeProduce(Bin0011Items.item11);
                });
                nodeProduce(Bin0011Liquids.liquid0, () -> {
                    nodeProduce(Bin0011Liquids.liquid1);
                });
            });
            node(Bin0011Blocks.crafter0000, () -> {
                node(Bin0011Blocks.crafter0001, Seq.with(new Research(Bin0011Items.item00)), () -> {
                    node(Bin0011Blocks.crafterLarge0000, () -> {
                        node(Bin0011Blocks.crafterLarge0001);
                        node(Bin0011Blocks.crafterLarge0010, () -> {
                            node(Bin0011Blocks.crafterLarge0011);
                        });
                    });
                });
            });
        }); // root end
    }
}
            
