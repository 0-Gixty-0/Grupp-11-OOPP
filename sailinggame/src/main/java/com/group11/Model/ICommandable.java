package com.group11.Model;

public interface ICommandable {
    
    public void moveCommand(Integer direction);

    public void attackCommand(Integer direction);

    public void interactCommand();

}
