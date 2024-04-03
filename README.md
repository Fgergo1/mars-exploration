### Mars Exploration
Welcome to the Mars Exploration project! This software is designed to generate randomized maps of Mars for simulation exercises, aiding in the calibration of Mars rovers. The application's flexibility allows it to adapt to changing requirements efficiently.

### How It Works
1. A custom map configuration object is created, defining essential features such as file name, map width, and symbols for terrain elements and resources. The generator utilizes these parameters to produce a unique map upon each run.

2. Mountains and pits are generated with specified areas and random shapes, ensuring non-overlapping placement within defined boundaries. The shape generator undergoes rigorous testing for accuracy.

3. Mineral and water units are strategically positioned near their preferred terrain (mountains and pits) whenever possible.

4. A validator ensures safe map configuration, exiting the program if provided data cannot be safely accommodated within the given area.

5. Various shape-generating strategies are implemented, configurable via parameters from the map configuration object, fostering adaptability and extension for new terrain elements, resources, or generation strategies.

6. The resulting map is saved to a plain text file specified in the configuration.


### Built With
[![Java](https://skillicons.dev/icons?i=java&theme=light)](https://skillicons.dev)

### How to Use

**Prerequisites:**

1. Install Java from [https://www.java.com/en/download/help/download_options.html]
2. Install JDK from [https://www.oracle.com/java/technologies/downloads/]
3. Install Git from : [https://git-scm.com/downloads]


**Usage:**

To set up the Buffet Management System locally, follow these simple steps:

1. Clone the repository from Github
   ```sh
   git clone git@github.com:Fgergo1/mars-exploration.git
   ```
2. Within your file explorer or terminal, navigate to the directory containing the cloned repository (e.g., `path/to/your/mars-exploration`).
   Once there, locate the folder named `classes` (it might be within a folder named `target`). Open this `classes` folder.

3. Open a terminal or command prompt and run the following command :
```sh
   java com.codecool.ehotel.Application
   ```
and press enter.


### Contact

Email: farkasgergot@gmail.com


### Useful resources

[Install Java and JDK](https://www.youtube.com/watch?v=SQykK40fFds&t=1s)

Happy Mars Exploration! 🚀