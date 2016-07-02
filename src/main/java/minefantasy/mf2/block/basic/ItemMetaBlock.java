package minefantasy.mf2.block.basic;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minefantasy.mf2.item.list.ToolListMF;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemMetaBlock extends ItemBlock 
{
	private BlockMeta instance;
	public ItemMetaBlock(Block block) 
	{
		super(block);
		this.instance = (BlockMeta) block;
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
    {
        return instance.getUnlocalisedName(item.getItemDamage());
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for(int i = 0; i < instance.getCount(); i++)
        {
        	list.add(new ItemStack(this, 1, i));
        }
    }
	
	@Override
	public int getMetadata(int subid)
    {
        return subid;
    }
}
