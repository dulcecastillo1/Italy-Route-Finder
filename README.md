# Italy-Route-Finder
Graph-based Java application using custom data structures and Dijkstra’s Algorithm to calculate the shortest path between Italian cities.

**Languages:** Java  
**Topics:** Objects & Classes, Custom Collections (MyHashMap, MyHashSet, DLList), Generics, Graphs, Shortest Path (Dijkstra), Java UI components  
**Map:** Italy (custom background image with country borders)  

---

## Project summary
Italy Route Finder is a Java desktop program that displays a map of Italy with 20 named locations and roads. Users can enter 3-letter location abbreviations to compute and display the shortest route (by distance) using **Dijkstra's algorithm**. All data structures are implemented from scratch (no Java collection imports): `MyHashMap`, `MyHashSet`, `DLList`, etc. Roads have names and the generated directions include road names and distances.

---

## Demo
<img width="1396" height="825" alt="Screenshot 2025-10-18 at 12 10 12 AM" src="https://github.com/user-attachments/assets/8f59557f-783a-4797-b164-c5c5cb9bfed7" />



---

## Features
- Custom adjacency-list graph implementation using your own `MyHashMap` and `MyHashSet`.
- `Location` class with name and 3-letter abbreviation; custom `hashCode` and `equals` based on the 3-letter code (not `String.hashCode()`).
- Dijkstra's algorithm to compute the shortest path (total distance) between two locations.
- Visual map of Italy with:
  - at least 20 location nodes,
  - roads drawn between locations with displayed distances and road names,
  - at least 5 nodes with degree > 2.
- Highlighted route on the map when a path is found.
- Directions printed step-by-step including road names and per-segment distances and the total distance.
- Challenge 3 implemented: **each connecting road has a name** and directions include the road name.  
  Example direction line:
