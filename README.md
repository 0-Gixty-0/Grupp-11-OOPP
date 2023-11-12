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

### TAS-24: Implement Basic Map Generation
Date of completion: 09/11/2023 <br>
Completed by: William Norland

Implement basic map generation according to the UML diagram. Basic generation meaning that it should be barebones and simply generate a map consisting of Tiles in a certain order. I suggest the following order of implementation:

#### What
Implementing a basic inheritance hierarchy and interface for the world generation and creating basic world generation.

#### How
I completed the task by implementing the followign classes as specified by the UML-diagram.
Two abstract baseclasses (AWorldGenerator, AMapGenerator).
A filler class ATile (a class that is really meant to be created in another unfinished task).
Two classes (Map, World) to be used in the model/logic of the game.
Two concrete implementations of abstract classes (BasicMapGenerator, BasicWorldGenerator) for creating Map and World.

#### Why
I choose to make AWorldGenerator and AMapGenerator abstract to follow the DIP, so that the game may use any type of world and map generation.
These two classes can/should be interfaces as they only contain one method each, i choose to make them abstract classes for four reasons.

(1) I dont wany any class to be able to be a Map/World generator, making classes that are Map/World generators be subclasses of abstract classes rather than interface implementors makes it so it cant be subclasses of anything else.

(2) There probably will be additions to these classes that makes it so they cant be interfaces.

(3) Semantically it makese a little more sense if you imagine inheritance as "is a" and interface implementations as "can do".

(4) In the current state there is no practical difference.

This also uses the abstract factory pattern which is a great way to do the same thing different ways with a common interface.

I choose to make the ATile class because my task could not be implemented in a functional way without it. I am aware that this is not ideal and that tasks shouldnt be made in such a way that it is dependent on other taks, however, we as a group decided that this time we solve it with a hack (The task that involves making the real Tile class is underway) and in the future we construct tasks in a better way. By doing it this way we dont need to change two tasks (which might have cascading effects) and nobody is confused because we had a discussion about it.

I choose to make Map an aggregation of a ATile matrix and Integer matrix to make View less dependent on model, if view uses the integer matrix (with each Integer representing a certain texture) it doesnt need to know about the ATile type.

#### Tutorial
The player will see the implementation of this task by seeing different worlds in the game.

### TAS-29: Implement Drawing Basic Terrain Types
Date of completion: 11/11/2023  
Completed by: Erik Andreasson

Implement ability to draw certain graphical icons / pictures based on tile id to the view. 
This should be integrated into the View Module and the Tile code. 
The drawing logic should be generalized for all possible terrain ID:s and all possible "tile sets". 
Essentially ability to switch out which images correspond to which id and in turn which terrain type is to be drawn. 
At current development focus should be put into how the land and sea tile should be drawn.

#### What
Implementing drawing tiles of different terrain types to the screen according to specifications from the model.
The implementation is to be semi-general and independent of the models representation of terrain.

#### How
I began by creating a png texture map which is 64x64 pixels from merging the two land and sea tile png:s and scaling up.
I then implemented an extension to the AbstractViewTile class by implementing the methods createImageIcon and getTextureMatrixCoordinate.
I also modified the constructor and the method createComponent. 

The method getTextureMatrixCoordinate takes a terrain id and converts that number to a matrix position (row, column). 
This matrix position is the position of the tile image for that terrain type in the texture map. This method is 
currently dependent on the size of the texture map being a 4x4 matrix.

The method createImageIcon creates an object of type ImageIcon which is then later applied to the JLabel component in createComponent.
It creates the icon by loading in the texture map and then creating a BufferedImage based on the pixel position of the two opposite
corners of the tile in the texture map. This pixel position is obtained by scaling the matrix position previously obtained.
It then adds the BufferedImage to the ImageIcon and returns.

#### Why
I tried to make the code as general as possible. Granted it is dependent on the size and layout of the texture map, but I made
a reasonability assessment and concluded that 16 different terrain textures is more than enough to start with. This way we can add
14 more terrains before having to change a number or two in the code. Something I don't believe will happen.
However, it is general in the sense that one can change the representations of tiles by simply exchanging the texture map png
for another one. Furthermore, the whole system is based on terrain id:s which is just a number between 0 - 15 which has no other
information from the model. Instead, the number simply points to a certain tile in the texture map.

#### Tutorial
This feature does not require a tutorial since it doesn't have functionality for the player other than visual

---

### TAS-22: Implement Ship Module 
Date of completion: 12/11/2023  
Completed by: Noa Cavassi

Implement Ship Module as declared in UML diagram. This task encompasses creating abstract classes and interfaces.

#### What
Implementing interfaces and abstract classes as templates for the concrete class Ship. The functionality and methods
will be updated and changed during the course of the project.

#### How
The task had a checklist with the intefaces and classes required, and the UML diagram showed what methods and variables that was needed.
During the course of implementing the module, I understood better which ones was necessary and which ones that was not.

The abstract class ABody is a template for a body. It's implemented such that it contains a dimension, a position, it has hitpoints, and a velocity.
It uses the interface IDamageable, since every body can take damage.

The abstract class AMovableBody is the structure for every body that can move around on the map. It is a subclass of ABody. It contains the method "move", which changes the position (x,y) of the body.

The class Ship is the concrete class of the module. It gets the general structure of ABody and AMovableBody, and also implements It's own specific functionality, altough at the moment It's very limited.
It has a level, armor, cannons, and sailStatus, which tells if the sail is up or down. It also has an anchor which can reduce the velocity of the ship to 0 when lowered down.

#### Why
The functionality of the code is very limited for the moment, since specific functionality is not in the main focus now. The code should follow the Open-closed principle. It should be easy to extend the code, add more functionality, without the need to modify the already existing code.

The whole module is needed to get a good structure of how instances of objects, specifically movable objects, are created in the game. 

#### Tutorial
This module will be updated during the course of the project. For the moment no tutorial is needed.
