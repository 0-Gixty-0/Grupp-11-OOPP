# SailingGame - Group-11-OOPP

## ❗ A note about Issues
In the beginning of this project we followed another form of workflow for creating issues which we now deem as confusing and inefficient. Issues created during this time will have titles starting with
TAS while new issues will have titles starting with US. Take a note of this while reading about issues in the project.

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

---

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

---

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

---

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

---

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

---

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

---

### TAS-11
Date of completion: 14/11/2023
Completed by: William Norland

As a user i want to be able to do basic movement of the player on the screen.

#### What
Implementing a class for the player including the movement logic, the purpose of this task was to make the player able to move so we can work on producing a MVP as soon as possible. The player class is going to be further expanded on in later user stories.

#### How
By making am abstract superclass called Entity which has the subclasses PlayableEntity (A entity coontroller by the player), the entity has a body (the physical representation of the entity) this body is specifically a AMovableBody. I also made LocationEntity because it didnt take long and i was in the neighborhood (representing static immovable entities like cities) which should have something like an AImmovableBody, right now however they use ABody

#### Why
I choose to make the inheritance hierarchy like this to follow the OCP (keeping code open for extension), one player (PlayableEntity) can use many different bodies (AMovableBody) by using subtype-polymorphism, the DIP (depend on abstractions) by using abstract classes. There is a small "why?" in the test class of PlayableEntityTest, there im making pretty much the same test for testing moving in different directions. Im pretty sure i could use parametrized testing here but since there is a time constraint and efficient testing isnt the primary scope (dont read this as "we dont care about testing") of this course i chosse to write them like that. Im leaving this choice open for discussion since we might want to change this at a later state of the project.

#### Tutorial
The user will interact heavily with the PlayableEntity when controlling the player in the game world.

---

### US-33
Date of completion: 14/11/2023
Completed by: William Norland

As a developer I want to separate creation of the integer matrix in the Map object to another class so that Map has one single responsibility because this follows the SOLID principles making it simpler to maintain and use.

#### What
Implementening a way of converting Matrixes of ATile into Matrixes of Int and removing that capability from BasicMapGenerator.

#### How
Implementing a utility class to host a function for converting a matrix of ATiles into a matrix of ints that the view then converts to its domain specific language 
and finally draws as the game on the screen. The method decode simply goes through all elements in the argument ATile Matrix and pastes over the textureIds to the int Matrix.

#### Why
I implemented TileMatrixDecoder as a final class because no subclasses of this should exist because its a utility class. It has a private constructor because its functions are static and this class is not intended to be used as an object. The algorithm converting the matrixes is as simple as it can be, you could probably improve it by using vectorization or some paralell process but at this point in the project you dont really need to make it more efficient. If you have a large map you can improve performance by rendering the map in smaller pieces.

#### Tutorial
The user wont really interact with this in anyway more explicit than looking at the game world this class (helped) made.

---

### US-36
Date of completion: 15/11/2023
Completed by: William Norland

As a developer i dont want LocationEntity to be able to have a AMovabelBody. Because a location entity is not supposed to have body capable of moving.

#### What
Making it impossible for a LocationEntity to have a AMovableBody.

#### How
Implementing a new abstract class AImmovableBody and making LocationEntity use an AImmovableBody instead of an ABody.

#### Why
Even though LocationEntity couldnt really move because it had an ABody and therefore could not use the Interface of AMovableBody it could still use a AMovableBody object like a Ship, this is not how its intended and therefore we changed it to AImmovableBody

---

### TAS-23: Implement Tile Module 
Date of completion: 13/11/2023  
Completed by: Adam Kvarnsund

#### What
Creating a base structure for the tiles used in the game. This includes an abstraction of the general tile and two specific concrete implementations. Also implementing an attribute that says which tile the instance is.

#### How
The task was carried out with the help of a list of subtasks directly states in the issue o GitHub. The concrete implementations of the classes and their methods were constructed according to the UML diagram we created before the coding process.

#### Why
This particular task is necessary for the game to be able to display and for the player able to interact with the world. Tiles have their own texture which the world generator will be able to take into account when building a realistic map.

#### Tutorial
A tutorial is not needed in this state of the process.

---

### US-15 Design An Enemy Ship Model
Date of completion: 16/11/2023
Completed by: Noa Cavassi

Design a model for an enemy pirate ship.

#### What
Created an enemy pirate ship in pixel art with the dimension 16x16.

#### How
I created the model by using Pixilart.com. First i took the water model, and then drew over it so the background of the ship matches and lines up with the rest of the water tiles.

#### Why
To make it easier to distinguish if an entity on the map is friendly or an enemy.

#### Tutorial
This feature does not require a tutorial since it doesnt have functionality for the player other than visual

---

### US-37
Date of completion: 16/11/2023  
Completed by: William Norland

As a user i dont want the player to be able to move on land because the player is a ship, a watercraft.

#### What
Preventing any AMovableEntity from moving outside the map or moving over impassable terrain. I also implemented a safe way to get an ABody position, which was through safe copying.

#### How
I Achieved this by making a Utility class MovementUtility, this class is static so it always exists the only thing you have to do is give the map you are using to it during game setup and it will check if any movement trying to be made is legal. 

#### Why
I made the position you get from ABody a safe copy so that outside classes cant modify the true position but they can know about it. I made the utlity class into a static class because its purpose is to house a function, a map, and to act as a middleman between Map and AmovableEntity to prevent dependencies between map and Entity. The function checking if the move is possible is nothing special, it just checks if the tiles in the direction you want to are passable.

#### Tutorial
The player will use this feature a lot when trying to sail over islands or over the edge of the world, or rather, they wont be able to, thanks to this.

---

### US-38: Implement Drawing Player To Map
Date of completion: 17/11/2023  
Completed by: Erik Andreasson

As a player I want to be able to see myself on the map in order to play the game.

Implement drawing the player to the map in the view module based on an int matrix representing entities on the screen.

#### What
Implementing functionality to create entity tiles that are drawn to the screen. This means that the functionality
of GameEntities is extended, AViewTile is refactored for subclass overrides, creating EntityTile class, and
extending AppWindow methods to draw entity tiles.

#### How
Since GameEntities and GameWorld are quite similar extending the functionality was quite simple. I simply added the methods
from GameWorld and made small adjustments for entity tiles instead of terrain tiles. More interesting was refactoring
AViewTile. I realized in the method createImageIcon that two of the steps in the algorithm needed to be abstract for
subsequent subclasses, such as the new EntityTile class. Since most of the algorithm was general to all subclasses I decided
to use the template method design pattern to tackle this problem. The first step to make abstract was for loading in
the texture map. This is because the entity and terrain texture map are two separate  images and I felt that passing down
the path through a constructor was more difficult than simply hardcoding the path since in the projects lifespan it
should never change. Similarly, the step for translating the texture id into a matrix position in the texture map needed
to be generalized because the size (rows, columns) of each texture map could differ.
This makes the calculation vary across subclasses. Following this I created the EntityTile class which essentially just
overrides the abstract methods for the template method in the superclass. Finally, I extended the functionality of AppWindow to
add a terrain tile component to the frame only if there was not an entity to draw in the same position.

#### Why
This task is essential since being able to see yourself as the player is integral to playing the game. In regard to using the
template method in AViewTile, I felt that it was the most natural solution for the issue, Since only small parts of the algorithm
needed to be overriden in the subclasses. Using this pattern instead of for example, if statements for subclass behaviour,
has many benefits such as following the open closed principle by being easy to extend and the liskov substitution principle since
the subclasses only override steps in the algorithm which ultimately lead to the same result / behavior for the algorithm as defined
in the superclass. So one can use the AViewTile type in AppWindow and expect the same behavior regardless of the
object being TerrainTile or EntityTile. Another thing to note is why I chose the Template Method pattern and not Strategy.
This is because the Template Method decides the behaviour of subclasses statically and Strategy allows the behaviour to change
during runtime. There is no need for the behaviour in these steps to be decided at runtime and I wanted to reduce over-engineering the
code by bloating the view module with classes and interfaces for each behaviour. So Template Method was the better choice.

#### Tutorial
A tutorial is not quite necessary for this user story other than that the player is represented by a ship on the map.

---

### US-39: Reduce code duplication for the position attribute
Date of completion: 17/11/2023  
Completed by: Adam Kvarnsund

#### What
Reduced the code duplication for the position attribute by creating a new abstract class called APositionable and refactored the already existing subclasses.

#### How
Created a new abstract class APositionable and refactored the old classes to inherit from this instead of the ATextureIdentifiable

#### Why
This reduces code duplication which is a practice we go by

#### Tutorial
No tutorial needed

---

### US-40: Implement Factory Hierarchy For Movable Game Entities
Date of completion: 18/11/2023
Completed by: Erik Andreasson

As a developer I want to make use of factories when creating movable entities in the game because it makes the code easier to understand and follows “high cohesion, low coupling”

This user story is about creating a hierarchy of classes following the factory design pattern in order to make the process of creating entities, in this case including creating bodies for such entities, more intuitive and automated. This makes the code easier to understand and allows our modules to be usable without having to depend on everything, i.e. high cohesion low coupling.

#### What
Implement a factory class and interface according to the Factory design pattern in order to create
movable game entities such as the player and enemies

#### How
I created an interface IMovableEntityFactory which states that there should be a method for creating a player
and creating an enemy. I also created a concrete class StandardMovableEntityFactory which implements the above two methods.
Currently, createEnemy only returns null since I later realized UnmovableEntity had not been implemented yet.
Also, createPlayer creates an essentially blank ship with the name player.

#### Why
I felt this user story was important to complete since it aid in creating a readable and intuitive code base. The factory pattern
makes our code follow high cohesion and low coupling better by letting client code such as an enemy placer class depend on the factory
instead of each component of an enemy, that being an entity and a body. Essentially it is a nice interface to have when implementing other
user stories. However, during this US I realized that most of the core functionality for these classes was not finished. Such as
default constructors for a Ship. I decided to finish the US anyway with the intent of extending and modifying it once these other
issues are resolved.

#### Tutorial
This US does not require a tutorial since it is for developers.

---

### US-43: As a developer I want to remove ATextureIdentifiable from model
Date of completion: 19/11/2023
Completed by: William Norland

As a developer, I want to remove the dependency on the ATextureIdentifiable class in the model, as it introduces unnecessary code and complexity. Instead, I will use type checking in the TileMatrixDecoder to determine the type of value for different entities.

#### What
The goal of this user story is to remove the ATextureIdentifiable class from the model and update the TileMatrixDecoder to rely on type checking instead of the getTextureId method.

#### How
I made TileMatrixDecoder use a list mapping .class attributes of types to certain Integers.

#### Why
Its very easy to add support for new types, instead of having to write a new if statement you can just write a simple ".add()" to the list.

#### Tutorial
No tutorial is required for this user story, as it is intended for developers familiar with the codebase.

---

### US-44: As a developer i want to make AWorldGenerator and AMapGenerator into Interfaces
Date of completion: 19/11/2023
Completed by: William Norland

They only contain abstract methods and if we should follow convention in other parts of the codebase they should be interfaces.

#### What
Making AWorldGenerator and AMapGenerator into IWorldGenerator and IMapGenerator, pretty much nothing more.

#### How
By refactoring class names into interfaces and changing 2 keywords.

#### Why
When i implemented basic map generation in one of the old TAS's (TAS-24) i debated if the interface (Interface as in not the literal Java ense) for world and map gen should be an abstract class or an interface. I chose abstract class to limit unsolicited use of the interface and to make it easier to add methods that all Map/WorldGens need in the future (Can pretty much be done just as easily with interfaces). But since interfaces are favored in the rest of the codebase im now changing abstract classes to interfaces without any cons.

This is also a much more traditional way of implementing the abstract factory pattern.

