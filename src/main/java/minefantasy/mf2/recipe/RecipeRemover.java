package minefantasy.mf2.recipe;

import minefantasy.mf2.config.ConfigHardcore;
import minefantasy.mf2.util.MFLogUtil;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {
    public static void removeRecipes() {
        MFLogUtil.log("MineFantasy: Removing replaced recipes...");
        for (int a = 0; a < CraftingManager.getInstance().getRecipeList().size(); a++) {
            IRecipe rec = (IRecipe) CraftingManager.getInstance().getRecipeList().get(a);
            if (rec.getRecipeOutput() != null && willRemoveItem(rec.getRecipeOutput(), ConfigHardcore.HCCRemoveCraft)) {
                CraftingManager.getInstance().getRecipeList().remove(a);
            }
        }
    }

    private static boolean willRemoveItem(ItemStack item, boolean HCC) {
        if (item.getItem() == Items.stick)
            return true;

        if (HCC) {
            return item.getItem() == Items.bread ||
                    item.getItem() == Items.pumpkin_pie ||
                    item.getItem() == Items.cake ||
                    item.getItem() == Items.flint_and_steel ||
                    item.getItem() == Items.bucket ||
                    item.getItem() == Items.boat ||
                    item.getItem() == Items.dye ||
                    item.getItem() == Item.getItemFromBlock(Blocks.stonebrick) ||
                    item.getItem() == Item.getItemFromBlock(Blocks.furnace) ||
                    item.getItem() == Item.getItemFromBlock(Blocks.brick_block); // ||item.getItem() == Item.getItemFromBlock(Blocks.planks)
        }
        return false;
    }
}
