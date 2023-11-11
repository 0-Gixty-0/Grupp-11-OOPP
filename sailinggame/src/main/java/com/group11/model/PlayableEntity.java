package com.group11.model;

public class PlayableEntity extends AMovableEntity {

    public PlayableEntity(AMovableBody body, String name) {
        super(body, name, true);

    }


    @Override
    public void moveCommand(Integer direction) {
        switch(direction) {
            case 0:
              
              break;
            case 1:
              // code block
              break;
            case 2:
              // code block
              break;
            case 3:
              // code block
              break;
            case 4:
              // code block
              break;
            case 5:
              // code block
              break;
            default:
              // code block
          }
    }

    @Override
    public void attackCommand(Integer direction) {
        
    }

    @Override
    public void interactCommand() {
        
    }
  
}
