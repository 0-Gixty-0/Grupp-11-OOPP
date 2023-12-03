package com.group11.model.gameentites;

public interface ICommandable {
    
    public void moveIfAble(Integer direction);

    public void attackIfAble(Integer direction);

    public void interactIfAble();

}
