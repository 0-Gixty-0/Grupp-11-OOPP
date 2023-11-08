# SailingGame - Group-11-OOPP

## Implemented features
Following is a list of implemented features in the form of tasks, these tasks are represented by solved GitHub issues with the same name. To get a deeper look into how each task was implemented, check the issues.

### TAS-25: Implement Basic View Module
Date of completion: 07/11/2023  
Completed by: Erik Andreasson
#### What:
Implement a basic view module that can display the map according to specifications obtained from the model. 
This should also be fairly simple so that other features can be integrated quickly. 
Essentially it should draw the map and the player. 

#### How:
No particular design patterns were used in this task. Instead, the purpose was to create a simple and general
interface and functionality for drawing tiles obtained from the model to the screen. In a sense it follows MVC
by keeping model logic as far removed from the view as possible.
The View module in its current state is comprised of three classes:

AppWindow: AppWindow creates the other two classes described below and follows a simple class setup
with a constructor and basic functionality. It stores the terrain map and creates and fills the main window

GameWorld: GameWorld creates and stores the tile matrix which represents a matrix of JLabels where each tile
is a JLabel. It creates this from the specifications given by AppWindow upon constructing the object. 
It has a simple getter for retrieving this matrix. 

GameEntities: GameEntities currently has no functionality and is essentially just boilerplate code from the UMl diagram.
It is meant to be implemented in later tasks.

#### Why:
This module is integral to actually displaying information from the model to the player. Without it the game would be
unplayable or testable.

#### Tutorial:
Upon starting the game a window will be displayed. This window will contain tiles representing terrain in the game
