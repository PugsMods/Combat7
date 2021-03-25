package com.putopug.combat7.objects.entities.pug;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;

/*
 * @author: PutoPug
 */
public class PugEntity extends CreatureEntity {

    public PugEntity(EntityType<PugEntity> type, World worldIn) {
        super(type, worldIn);
    }
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_()
            .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3)
            .createMutableAttribute(Attributes.MAX_HEALTH, 25)
            .createMutableAttribute(Attributes.ARMOR, 0)
            .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new SwimGoal(this));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
    }

}

