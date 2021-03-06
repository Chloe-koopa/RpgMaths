package moe.gensoukyo.rpgmaths.common.util;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nonnull;

/**
 * 将Cap存储为NBT
 * @param <T> 能力实例的类型
 * @author Chloe_koopa
 */
public class StorageCapToNbt<T extends INBTSerializable<D>, D extends INBT>
        implements Capability.IStorage<T>
{
    @SuppressWarnings("rawtypes")
    private static final StorageCapToNbt INSTANCE = new StorageCapToNbt();

    /**
     * 可自动推断泛型
     * 只要T实现了 {@link INBTSerializable}
     */
    @SuppressWarnings("unchecked")
    public static <T extends INBTSerializable<D>, D extends INBT>
    StorageCapToNbt<T, D> getInstance()
    {
        return (StorageCapToNbt<T, D>) INSTANCE;
    }

    @Nonnull
    @Override
    public INBT writeNBT(Capability<T> capability, T instance, Direction side)
    {
        return instance.serializeNBT();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void readNBT(Capability<T> capability, T instance, Direction side, INBT nbt)
    {
        instance.deserializeNBT((D) nbt);
    }

    private StorageCapToNbt() {}
}
