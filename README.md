Project Overview

This project simulates an air traffic control tower using the Mediator design pattern. The control tower mediates communication between aircraft (passenger planes, cargo planes, helicopters) for landing, takeoff, and emergency handling.
Features:
ControlTower manages landing and takeoff queues.
Emergency Handling: Aircraft sending "MAYDAY" are given immediate priority for landing.
Simulation: Ten random aircraft are spawned every second with random fuel levels and requests.

Example Console Output:

Control Tower: requestLanding from Plane1
Plane1 is in the landing queue.
Control Tower: MAYDAY from Helicopter50
Helicopter50 is priority for landing due to MAYDAY. Clearing runway!
Control Tower: requestLanding from Helicopter50
Helicopter50 is in the landing queue.


File Structure:
src/
 ├─ mediator/               <-- Mediator logic
 ├─ aircraft/               <-- Aircraft types
 ├─ simulation/             <-- Simulation driver
 ├─ Main.java               <-- Main entry point
 ├─ README.md              <-- Documentation
