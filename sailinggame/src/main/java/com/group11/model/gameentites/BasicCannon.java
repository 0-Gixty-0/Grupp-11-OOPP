package com.group11.model.gameentites;
import java.lang.reflect.InvocationTargetException;

public class BasicCannon<T> extends AWeapon {
    private final T projectileType;

    public BasicCannon(T projectileType){
        if (projectileType instanceof AProjectile) {
            this.projectileType = projectileType;
        } else {
            throw new IllegalArgumentException("projectileType must be of type AProjectile");
        }
        this.maxTimesFired = 5;
    }

    public T getProjectileType() {
        return this.projectileType;
    }

    public int getFiredProjectilesSize() {
        return this.firedProjectiles.size();
    }

    @Override
    public void fireWeapon() {
        if (this.firedProjectiles.size() < this.maxTimesFired) {
            try {
                this.firedProjectiles.add((AProjectile) this.projectileType.getClass().getConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException("Could not instantiate projectile because of: " + e.getMessage());
            }
        }
    }
}