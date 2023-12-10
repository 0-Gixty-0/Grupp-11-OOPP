package com.group11.model.gameentites;

public interface ICommandable {
    
    public void moveIfPossible(Integer direction);

    public void attackIfPossible(Integer direction);

    public void interactIfPossible();

}
