/*
 * This file is part of Matter Overdrive
 * Copyright (c) 2015., Simeon Radivoev, All rights reserved.
 *
 * Matter Overdrive is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Matter Overdrive is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Matter Overdrive.  If not, see <http://www.gnu.org/licenses>.
 */

package matteroverdrive.network.packet.server;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import matteroverdrive.items.weapon.EnergyWeapon;
import matteroverdrive.network.packet.PacketAbstract;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Simeon on 8/2/2015.
 */
public class PacketReloadEnergyWeapon extends PacketAbstract
{
    public PacketReloadEnergyWeapon(){}

    @Override
    public void fromBytes(ByteBuf buf)
    {

    }

    @Override
    public void toBytes(ByteBuf buf)
    {

    }

    public static class ServerHandler extends AbstractServerPacketHandler<PacketReloadEnergyWeapon>
    {
        @Override
        public IMessage handleServerMessage(EntityPlayer player, PacketReloadEnergyWeapon message, MessageContext ctx)
        {
            if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof EnergyWeapon)
            {
                if (((EnergyWeapon) player.getHeldItem().getItem()).getEnergyStored(player.getHeldItem()) <= ((EnergyWeapon) player.getHeldItem().getItem()).getEnergyUse(player.getHeldItem()))
                {
                    ((EnergyWeapon) player.getHeldItem().getItem()).chargeFromEnergyPack(player.getHeldItem(),player);
                }
            }
            return null;
        }
    }
}