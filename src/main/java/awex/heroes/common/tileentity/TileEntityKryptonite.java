package awex.heroes.common.tileentity;

import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.block.BlockTreadmill;
import fiskfille.heroes.common.network.MessageTileTrigger;
import fiskfille.heroes.common.tileentity.IMultiTile;
import fiskfille.heroes.common.tileentity.TileEntitySH;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.block.BlockDirectional;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;

public class TileEntityKryptonite extends TileEntitySH implements IMultiTile, MessageTileTrigger.ITileDataCallback {
    public int playerId = -1;

    public TileEntityKryptonite() {
    }

    public void updateEntity() {
        EntityPlayer player = this.getPlayer();
        int metadata = this.getBlockMetadata();
        int direction = BlockDirectional.getDirection(metadata);
        if (player != null) {
            float yaw = (float)(direction * 90 % 360);
            double yOffset = (double)(player.yOffset + 0.32F);
            player.setPosition((double)((float)this.xCoord + 0.5F + (float) BlockTreadmill.directions[direction][0] * 0.3F), (double)this.yCoord + yOffset, (double)((float)this.zCoord + 0.5F + (float)BlockTreadmill.directions[direction][1] * 0.3F));
            player.fallDistance = 0.0F;
            player.renderYawOffset = yaw;
            player.rotationYaw = MathHelper.clamp_float(player.rotationYaw, yaw - 30.0F, yaw + 30.0F);
            player.setSprinting(false);
            if (player.isSneaking() || SHHelper.getHero(player) == null || !SHHelper.getHero(player).hasAbility(Ability.SUPER_SPEED)) {
                this.setPlayer((EntityPlayer)null);
                player.setPosition((double)((float)this.xCoord + 0.5F - (float)BlockTreadmill.directions[direction][0]), (double)this.yCoord + yOffset, (double)((float)this.zCoord + 0.5F - (float)BlockTreadmill.directions[direction][1]));
            }
        }

    }

    public void setPlayer(EntityPlayer player) {
        if (player == null) {
            this.playerId = -1;
            this.markBlockForUpdate();
        } else if (this.playerId != player.getEntityId()) {
            this.playerId = player.getEntityId();
            this.markBlockForUpdate();
        }

    }

    public EntityPlayer getPlayer() {
        return this.playerId >= 0 && this.worldObj.getEntityByID(this.playerId) instanceof EntityPlayer ? (EntityPlayer)this.worldObj.getEntityByID(this.playerId) : null;
    }

    public AxisAlignedBB getRenderBoundingBox() {
        return AxisAlignedBB.getBoundingBox((double)this.xCoord, (double)this.yCoord, (double)this.zCoord, (double)(this.xCoord + 1), (double)(this.yCoord + 1), (double)(this.zCoord + 1)).expand(1.0D, 0.0D, 1.0D);
    }

    protected void writeCustomNBT(NBTTagCompound nbt) {
    }

    protected void readCustomNBT(NBTTagCompound nbt) {
    }

    public int[] getBaseOffsets(int metadata) {
        if (BlockTreadmill.isBlockFrontOfTreadmill(metadata)) {
            int[] offsets = BlockTreadmill.directions[BlockDirectional.getDirection(metadata)];
            return new int[]{-offsets[0], 0, -offsets[1]};
        } else {
            return new int[3];
        }
    }

    public void receive(EntityPlayer player, int action) {
        this.setPlayer(player);
    }
}
