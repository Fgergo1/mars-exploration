# Mars Exploration
### Overview
Welcome to the Mars Exploration project! This software is designed to generate randomized maps of Mars for simulation exercises, aiding in the calibration of Mars rovers. The application's flexibility allows it to adapt to changing requirements efficiently.

### How It Works
1. 
   A custom map configuration object is created, containing essential features such as the file name, map width, symbols, and numbers for terrain elements and resources.
   The generator produces a unique map with parameters from the configuration every time it runs.

2. 
   Mountains and pits are created with specified areas and random shapes.
   The shape generator code is meticulously tested to ensure accuracy.
   Shapes are placed on the map without overlap, within the defined boundaries.

3. 
   Mineral and water units are strategically placed next to their preferences (mountains and pits) when possible.
   
4. 
   A validator checks the map configuration to ensure safe placement within the given area.
   The program exits if the provided data cannot be safely accommodated.

5. 
   Different shape-generating strategies are implemented, configurable through parameters from the map configuration object.
   The software is designed to be open to extensions, allowing the addition of new terrain elements, resources, or generating strategies.

6. 
   The generated map is saved into a plain text file specified in the configuration.

  ### How to Use
   1. Clone the repository.
   2. Open CMD at the Java file location and run it with this command: javac [filename.java]
   3. Set up the map configuration object with your desired parameters to the prompt.
   

### Technologies

This project is only use Java.

Happy Mars Exploration! 🚀