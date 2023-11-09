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

### TAS-28: Create A Tile Class In View Module
Date of completion: 08/11/2023  
Completed by: Erik Andreasson  

There should be a Tile class in the view module that represents individual tiles and their attributes and functionality

#### What:
This task was about creating a Tile class to represent the tiles that are to be drawn to the screen. The Tile class
is an extension of the AbstractTile and implements the interface drawable. It contains functionality for creating objects
of type AbstractTile and Tile. It also has multiple getters for each attribute of the AbstractTile. Along with creating the Tile
module I also connected it to the view module. 

#### How:
I completed this task by creating three classes. Interface Drawable, Abstract class AbstractTile, and concrete class Tile.
I also gave them basic functionality for representing a tile such as matrixPosition, pixelPosition, id, and size.
I also modified the functionality of GameWorld and AppWindow to utilize the new Tile module in drawing the window to the frame.
I also made GameWorld and AppWindow dependent on the AbstractTile class instead of  directly dependent on the Tile class implementation. 
I did this in order to follow the dependency inversion principle. This along with creating an abstract tile and an interface makes
the code more open for extension rather than having to modify the code in the future.

#### Why:
The tile module in the view is an important step in following good design principles such as the single responsibility principle,
dependency inversion principle, and open closed principle. A tile should be responsible for handling its own attributes and methods
instead of the GameWorld. The abstract class and interface makes the Tile module more open to extension.

#### Tutorial:
This feature does not require a tutorial for the player since tiles being separate objects is not represented visually.


### TAS-10 Design player model
Date of completion: 08/11/2023  
Completed by: Alexander Muhr

There is a player model that can be displayed on the screen. 

#### What
Created png using pixel-art that have 8 different rotations that can be switched to depending on what direction the player is moving.

#### How
I completed the class by creating a png containing 8 models of the player ship in the form of pixelart, all att the same y-height and with 16px increments in x directions.

#### Why
I chose to do it this way so that it could be easily extended to implement animation of the sprite by adding more sprites "below" each direction respectively. Since all sprites take up 16px with no space in between this could easily be done using a loop incrementing the y-value representing what part of the png to draw and then start over on the first sprite.

#### Tutorial
This feature does not require a tutorial since it doesnt have functionality for the player other than visual

### TAS-20: Create Tile Designs For Terrain Types
Date of completion: 08/11/2023  
Completed by: Erik Andreasson

Create tile designs for different types of terrain meaning that we should create unique tiles that have different appearance and color. 
At this point in development only two tile designs are necessary for future tasks, That being a land tile and a sea tile.

#### What
Created two PNGS:s using pixel-art that represent a land tile and a water tile respectively

#### How
I completed the task by creating two PNG:s with the same dimensions 16x16 pixels.

#### Why
I created the two PNG:s separately filling the entire 16x16 area. I did this in orde to allow for different ways to access
the tile image. We may create a tile set containing all tiles and we may not. With this approach we keep our options open which
is important this early in development.

#### Tutorial
This feature does not require a tutorial since it doesn't have functionality for the player other than visual